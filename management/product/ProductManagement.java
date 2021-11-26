package com.codegym.management.product;

import com.codegym.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement implements IProductManagement {
    public static final String FILE_PATH = "product.txt";
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void create(Product product) {
        products.add(product);
        writeToFile();
    }

    @Override
    public void update(int index, Product product) {
        products.set(index, product);
    }

    @Override
    public void remove(int index) {
        products.remove(index);
    }

    @Override
    public void readFile() {
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String productLine[] = line.split(",");
                //productLine[0] => id
                //productLine[1] => name
                //productLine[2] => price
                //productLine[3] => description
                int id = Integer.parseInt(productLine[0]);
                String name = productLine[1];
                double price = Double.parseDouble(productLine[2]);
                String description = productLine[3];
                Product product = new Product(id, name, price, description);
                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            for (Product product:products) {
                fileWriter.write(product.toString());
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
