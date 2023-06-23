/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author Tuấn Anh
 */
public class Cart {

    private ArrayList<AddProduct> addProducts;

    public Cart() {
        addProducts = new ArrayList<>();
    }

    public void AddProducts(AddProduct product) {
        if (addProducts.contains(product)) {
            AddProduct addProduct = addProducts.get(addProducts.indexOf(product));
            addProduct.setSoluong(addProduct.getSoluong() + product.getSoluong());
        } else {
            addProducts.add(product);
        }
    }

    public double Total() {
        double price = 0;
        for (AddProduct product : addProducts) {
            price += product.getDongia() * product.getSoluong();
        }
        return price; 
    }

    public ArrayList<AddProduct> cart() {

        return addProducts;

    }

}
