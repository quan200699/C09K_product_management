package com.codegym.view;

import com.codegym.management.category.CategoryManagement;
import com.codegym.model.Category;

import java.util.List;
import java.util.Scanner;

public class CategoryView {
    private CategoryManagement categoryManagement = new CategoryManagement();

    public void run() {
        categoryManagement.readFile();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn:");
            choice = scanner.nextInt();
            List<Category> categories = categoryManagement.findAll();
            switch (choice) {
                case 1: {
                    showAllCategory(categories);
                    break;
                }
                case 2: {
                    createCategory(scanner);
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    System.out.println("Đọc file");
                    categoryManagement.readFile();
                    break;
                }
                case 6: {
                    System.out.println("Ghi file");
                    categoryManagement.writeToFile();
                    break;
                }
            }
        } while (choice != 0);
    }

    private void createCategory(Scanner scanner) {
        System.out.println("Thêm mới danh mục");
        Category newCategory = inputCate(scanner);
        categoryManagement.create(newCategory);
    }

    private Category inputCate(Scanner scanner) {
        System.out.println("Nhập id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        return new Category(id, name);
    }

    private void showAllCategory(List<Category> categories) {
        System.out.println("Danh sách sản phẩm:");
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    private void menu() {
        System.out.println("Menu quản lý danh mục");
        System.out.println("1. Hiển thị danh mục");
        System.out.println("2. Thêm danh mục");
        System.out.println("3. Cập nhật danh mục");
        System.out.println("4. Xóa danh mục");
        System.out.println("5. Đọc file");
        System.out.println("6. Ghi file");
        System.out.println("0. Quay lại");
    }
}
