package com.codegym;

import com.codegym.management.category.CategoryManagement;
import com.codegym.management.product.ProductManagement;
import com.codegym.model.Category;
import com.codegym.model.Product;

import java.util.List;
import java.util.Scanner;

/*
Menu quản lý sản phẩm
1. Hiển thị danh sách
2. Thêm sản phẩm
3. Cập nhật sản phẩm
4. Xóa sản phẩm
5. Đọc thông tin sản phẩm từ file
6. Ghi thông tin danh sách sản phẩm ra file
0. Thoát chương trình
* */
public class Main {
    private static ProductManagement productManagement = new ProductManagement();
    private static CategoryManagement categoryManagement = new CategoryManagement();

    public static void main(String[] args) {
        productManagement.readFile();
        categoryManagement.create(new Category(1, "Điện thoại"));
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn:");
            choice = scanner.nextInt();
            List<Product> products = productManagement.findAll();
            switch (choice) {
                case 1: {
                    showAllProduct(products);
                    break;
                }
                case 2: {
                    createNewProduct(scanner);
                    break;
                }
                case 3: {
                    updateProduct(scanner);
                    break;
                }
                case 4: {
                    removeProduct(scanner);
                    break;
                }
                case 5: {
                    System.out.println("Đọc file");
                    productManagement.readFile();
                    break;
                }
                case 6: {
                    System.out.println("Ghi file");
                    productManagement.writeToFile();
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void removeProduct(Scanner scanner) {
        System.out.println("Xóa sản phẩm");
        System.out.println("Nhập vị trí bạn muốn xóa");
        int index = scanner.nextInt();
        productManagement.remove(index);
    }

    private static void updateProduct(Scanner scanner) {
        System.out.println("Cập nhật sản phẩm");
        System.out.println("Nhập vị trí bạn muốn sửa");
        int index = scanner.nextInt();
        Product newProduct = inputProduct(scanner);
        productManagement.update(index, newProduct);
    }

    private static Product inputProduct(Scanner scanner) {
        boolean isValidId;
        int id = inputId(scanner);
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập giá:");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập mô tả:");
        String description = scanner.nextLine();
        return new Product(id, name, price, description);
    }

    private static int inputId(Scanner scanner) {
        boolean isValidId;
        int id = -1;
        scanner.nextLine();
        do {
            System.out.println("Nhập id:");
            isValidId = true;
            String idInput = scanner.nextLine();
            try {
                id = Integer.parseInt(idInput);
            } catch (NumberFormatException e) {
                isValidId = false;
                System.err.println("Id phải là số");
            }
        }while (!isValidId);
        return id;
    }

    private static void createNewProduct(Scanner scanner) {
        System.out.println("Thêm mới sản phẩm");
        Product newProduct = inputProduct(scanner);
        productManagement.create(newProduct);
    }

    private static void showAllProduct(List<Product> products) {
        System.out.println("Danh sách sản phẩm:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void menu() {
        System.out.println("Menu quản lý sản phẩm");
        System.out.println("1. Hiển thị danh sách");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Cập nhật sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Đọc danh sách sản phẩm từ file");
        System.out.println("6. Ghi danh sách sản phẩm ra file");
        System.out.println("0. Thoát");
    }
}
