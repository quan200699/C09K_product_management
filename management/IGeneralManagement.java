package com.codegym.management;

import java.util.List;

public interface IGeneralManagement<T> {
    List<T> findAll();

    void create(T t);

    void update(int index, T t);

    void remove(int index);
}
