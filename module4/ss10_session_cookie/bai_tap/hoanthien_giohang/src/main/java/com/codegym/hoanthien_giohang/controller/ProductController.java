package com.codegym.hoanthien_giohang.controller;

import com.codegym.hoanthien_giohang.model.Cart;
import com.codegym.hoanthien_giohang.model.Product;
import com.codegym.hoanthien_giohang.model.ProductForm;
import com.codegym.hoanthien_giohang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @Value("${upload.path}")
    private String filePath;

    @GetMapping("/product")
    public ModelAndView listProduct(@PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/product/index");
        modelAndView.addObject("products", productService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/product/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute ProductForm productForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(filePath + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Product product = new Product(productForm.getName(), productForm.getPrice(), productForm.getDescription(), fileName);
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create a new successful product");

        return "redirect:/product";
    }


    @GetMapping("/add/{id}")
    public String addProduct(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(product.get());
            return "redirect:/shopping";
        }
        cart.addProduct(product.get());
        return "redirect:/product";
    }


    @GetMapping("/sub/{id}")
    public String subProduct(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "error.404";
        }
        if (action.equals("show")) {
            cart.subProduct(product.get());
            return "redirect:/shopping";
        }
        cart.subProduct(product.get());
        return "redirect:/product";
    }

    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "error.404";
        }
        if (action.equals("show")) {
            cart.removeProduct(product.get());
            return "redirect:/shopping";
        }
        cart.removeProduct(product.get());
        return "redirect:/product";
    }


    @GetMapping("/product/{id}")
    public ModelAndView detailProduct(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/product/detail");
        modelAndView.addObject("product", product.get());
        return modelAndView;
    }


}
