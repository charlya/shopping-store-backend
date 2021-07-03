package com.charly.shopping.service;

import com.charly.shopping.domain.Product;
import com.charly.shopping.domain.Stock;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products;

    public ProductService() {
        Product tamaDrum = createProduct("TAMA drum", 1000.0, 4);
        Product sonorSnare = createProduct("SONOR Snare", 700.0, 3);
        Product pearlTom = createProduct("PEARL tom 8\"", 100.0);
        Product sabianSplash = createProduct("SABIAN splash 8\"", 130.0, 4);
        Product promarkSticks = createProduct("PROMARK sticks", 18.0, 100);
        Product evansHeads = createProduct("EVANS heads", 45.0, 15);
        Product dwBassDrumPedal = createProduct("DW bass drum pedal", 230.0, 2);
        Product yamahaClassicGuitar = createProduct("YAMAHA classic guitar", 140.0, 6);
        Product fenderBassGuitar = createProduct("FENDER bass guitar", 750.0, 2);
        Product gibsonLesPaul = createProduct("GIBSON Les Paul", 2300.0);
        Product korgElecticPiano = createProduct("KORG electic piano", 560.0);
        products = Arrays.asList(tamaDrum, sonorSnare, pearlTom, sabianSplash, promarkSticks, evansHeads, dwBassDrumPedal, yamahaClassicGuitar, fenderBassGuitar, gibsonLesPaul, korgElecticPiano);
    }

    private Product createProduct(String productName, double productPrice, int availableStock) {
        Product product = new Product(productName, productPrice);
        product.setStocks(Arrays.asList(new Stock("BoutiqueParis", availableStock), new Stock("BoutiqueLyon", availableStock), new Stock("BoutiqueBordeaux", availableStock)));
        return product;
    }

    private Product createProduct(String productName, double productPrice) {
        return createProduct(productName, productPrice, 0);
    }

    public List<Product> getProducts() {
        return products;
    }

}
