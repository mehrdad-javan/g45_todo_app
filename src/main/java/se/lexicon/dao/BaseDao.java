package se.lexicon.dao;


import java.util.List;

/**
 * Generic programming is a style of computer programming
 * It is a technique of written the code without specifying datatype(s)
 * E: Element
 * T: Type
 * K: Key
 * N: Number
 * V: Value
 * S, U, V etc
 */
public interface BaseDao<T> {

  T create(T model);

  T findById(Integer id);

  boolean deleteById(Integer id);

  void update(T model);

  List<T> findAll();


}
