package com.codegym.management.product;

import com.codegym.management.IGeneralManagement;
import com.codegym.model.Product;

import java.util.List;

public interface IProductManagement extends IGeneralManagement<Product> {

    void readFile();

    void writeToFile();
}
