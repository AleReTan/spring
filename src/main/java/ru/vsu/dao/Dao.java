package ru.vsu.dao;

import java.util.List;

public interface Dao<T>{
    void delete(T obj);

    long insert(T obj);
    void update(T obj);
    List<T> getAll();









































}
