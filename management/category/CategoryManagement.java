package com.codegym.management.category;

import com.codegym.model.Category;
import com.codegym.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryManagement implements ICategoryManagement {
    private static final String FILE_PATH = "category.txt";
    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public void create(Category category) {
        categories.add(category);
        writeToFile();
    }

    @Override
    public void update(int index, Category category) {
        categories.set(index, category);
    }

    @Override
    public void remove(int index) {
        categories.remove(index);
    }

    @Override
    public void writeToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(categories);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile() {
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            categories = (List<Category>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
