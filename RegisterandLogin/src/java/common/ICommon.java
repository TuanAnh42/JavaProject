package common;

import java.util.ArrayList;

public interface ICommon<T> {
    ArrayList<T> getAll();
    T getOne(int id);
    T login(String username,String password);
    boolean add(T obj);
    boolean update(T obj, int id);
    boolean delete(int id);
}
