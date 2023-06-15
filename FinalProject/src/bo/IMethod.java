/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.List;

/**
 *
 * @author AnhTH
 * @param <E>
 */
public interface IMethod<E> {

    boolean add();

    boolean update(String rollNumber);

    boolean remove(String rollNumber);

    List<E> search(String text);

    void sort();
    void find();
    void maxmark();
    

    void display();
}
