package com.ecommerce.controller;

import com.ecommerce.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class ProductController {

    // ADD PRODUCT
    @RequestMapping(value = "/add-product", method = RequestMethod.GET)
    public String addProduct(HttpServletRequest request) {
        Product product = new Product();

        product.setProductName("Chocopie");

        request.setAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String addProduct(HttpServletRequest request,
                             @ModelAttribute("product") Product product,
                             BindingResult bindingResult) {

        MultipartFile file = product.getImage();

        try {
            File newFile = new File("D:/Torrent data/SERVLET Project/SpringEcom/files/upload/" + file.getOriginalFilename());

            FileOutputStream fileOutputStream = new FileOutputStream(newFile);

            fileOutputStream.write(file.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        request.setAttribute("product", product);

        return "viewProduct";
    }

    // UPLOAD PRODUCT IMAGE
    @RequestMapping(value = "/upload-product-image", method = RequestMethod.GET)
    public String upload(HttpServletRequest request) {

        return "uploadProductImage";
    }

    @RequestMapping(value = "/upload-product-image", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam(name = "file") MultipartFile file) {

        // Save file to disk
        try {
            File newFile = new File("D:/Torrent data/SERVLET Project/SpringEcom/files/upload/" + file.getOriginalFilename());

            FileOutputStream fileOutputStream = new FileOutputStream(newFile);

            fileOutputStream.write(file.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        request.setAttribute("file", file);

        return "ViewFileOfProduct";
    }
}
