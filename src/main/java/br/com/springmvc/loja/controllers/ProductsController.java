package br.com.springmvc.loja.controllers;

import br.com.springmvc.loja.daos.ProductDao;
import br.com.springmvc.loja.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductsController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/products/form")
    public String form(){
        return "products/form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(Product product){
        productDao.save(product);
        return "products/ok";
    }
}
