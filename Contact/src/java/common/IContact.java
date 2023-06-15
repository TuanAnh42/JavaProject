/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package common;

import java.util.ArrayList;

/**
 *
 * @author Tuấn Anh
 */
public interface IContact<T> {
    ArrayList<T> getAll(); 
    boolean add(T obj);
    
}
