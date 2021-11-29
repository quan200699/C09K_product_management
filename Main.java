package com.codegym;

import com.codegym.management.category.CategoryManagement;
import com.codegym.management.product.ProductManagement;
import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.view.CategoryView;
import com.codegym.view.ProductView;

import java.util.Scanner;

/*
Menu quản lý
1. Quản lý sản phẩm
2. Quản lý danh mục
0. Thoát chương trình
* */
public class Main {
    private static ProductView productView = new ProductView();
    private static CategoryView categoryView = new CategoryView();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            menu();
            System.out.println("Nhập lựa chọn");
            choice =  scanner.nextInt();
            switch (choice){
                case 1: {
                    productView.run();
                    break;
                }
                case 2: {
                    categoryView.run();
                    break;
                }
            }
        }while (choice != 0);
    }

    private static void menu() {
        System.out.println("Menu quản lý");
        System.out.println("1. Quản lý sản phẩm");
        System.out.println("2. Quản lý danh mục");
        System.out.println("0. Thoát chương trình");
    }

}
