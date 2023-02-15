/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.edu.unyt.dao.interfaces;

import java.util.List;

/**
 *
 * @author elton.ballhysa
 */
public interface BaseDao <T, K> {
    List<T> findAll();
    T find(K key);
    void insert(T model);
    void update(T model);
    void remove(K key);
}
