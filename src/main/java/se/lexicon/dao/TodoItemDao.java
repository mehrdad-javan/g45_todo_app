package se.lexicon.dao;

import se.lexicon.model.TodoItem;

import java.util.List;

public interface TodoItemDao extends BaseDao<TodoItem> {


  List<TodoItem> findAllAvailable();

  List<TodoItem> findExpiredAndInCompleted();



}
