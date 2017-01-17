package de.apodznoev.angular.dao;

import java.util.List;

/**
 * Created by apodznoev
 * date 17.01.2017.
 */
public interface Dao<T> {

    List<? extends T> getAll();

    T getById(String id);

}