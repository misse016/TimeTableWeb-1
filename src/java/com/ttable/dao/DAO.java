/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.dao;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author MIS
 */
public abstract class DAO<T> {
    protected Connection connection = null;
    
    public DAO (Connection connection) {
        this.connection = connection;
    }
    
    public abstract boolean insert(T obj);
    
    public abstract boolean delete(T obj);
    
    public abstract boolean update(T obj);
    
    public abstract T getById(String id);
    
    public abstract T getById(int id);
    
    public abstract List<T> getAll();
}
