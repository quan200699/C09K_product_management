package com.codegym.management.category;

import com.codegym.management.IGeneralManagement;
import com.codegym.model.Category;

public interface ICategoryManagement extends IGeneralManagement<Category> {
    void writeToFile();
}
