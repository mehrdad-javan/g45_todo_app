package se.lexicon.dao.impl;

import se.lexicon.dao.TodoItemDao;
import se.lexicon.dao.impl.sequencer.TodoItemIdSequencer;
import se.lexicon.model.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class TodoItemDaoImpl implements TodoItemDao {

  private List<TodoItem> storage;

  private static TodoItemDaoImpl instance;

  private TodoItemDaoImpl(){
    storage = new ArrayList<>();
  }

  public static TodoItemDaoImpl getInstance(){
    if (instance == null) instance = new TodoItemDaoImpl();
    return instance;
  }




  @Override
  public TodoItem create(TodoItem model) {
    if (model == null) throw new IllegalArgumentException("TodoItem was null");
    model.setId(TodoItemIdSequencer.nextId());
    storage.add(model);
    return model;
  }

  @Override
  public TodoItem findById(Integer id) {
    // todo: implement later
    return null;
  }

  @Override
  public boolean deleteById(Integer id) {
    // todo: implement later
    return false;
  }

  @Override
  public void update(TodoItem model) {
    // todo: implement later

  }

  @Override
  public List<TodoItem> findAll() {
    return new ArrayList<>(storage);
  }

  @Override
  public List<TodoItem> findAllAvailable() {
    // todo: implement later
    return null;
  }

  @Override
  public List<TodoItem> findExpiredAndInCompleted() {
    // todo: implement later
    return null;
  }
}
