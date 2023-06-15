/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.ArrayList;

/**
 *
 * @author std
 */
public interface ICommon<T> {
    ArrayList<T> getAll();
    T getOne(int id);
    boolean add(T obj);
    boolean update(T obj);
    boolean delete(int id);
}
