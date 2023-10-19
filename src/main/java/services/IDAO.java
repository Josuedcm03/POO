package services;

import java.util.List;

public interface IDAO {

    <T> List<T> getAll(String namedQuery, Class<T> clazz);

    <T> void create(T entity);

    <T> T update(T entity);

    <T> T findById(Class<T> clazz, Integer id);

    <T> void remove(T entity);
}



