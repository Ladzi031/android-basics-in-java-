package com.example.myapplication12;

public class Product {
    private int _id;
    private String _productName;

    public Product(String productName) {
        this._productName = productName;
    }
    public Product(){}

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_productName() {
        return _productName;
    }

    public void set_productName(String _productName) {
        this._productName = _productName;
    }
}
