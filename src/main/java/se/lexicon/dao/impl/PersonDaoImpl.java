package se.lexicon.dao.impl;

import se.lexicon.dao.PersonDao;
import se.lexicon.dao.impl.sequencer.PersonIdSequencer;
import se.lexicon.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDaoImpl implements PersonDao {

  private List<Person> storage;

  // step2: define a static filed with the class type
  private static PersonDaoImpl instance;

  // step1 make constructor private
  private PersonDaoImpl() {
    storage = new ArrayList<>();
  }

  // step3: define a static method with if condition to check the object is null or no
  public static PersonDaoImpl getInstance(){
    if (instance == null) instance = new PersonDaoImpl();
    return instance;
  }


  @Override
  public Person create(Person model) {
    if (model == null) throw new IllegalArgumentException("Person was null");
    // add a new id to person
    model.setId(PersonIdSequencer.nextId());
    storage.add(model);
    return model;
  }

  @Override
  public Person findById(Integer id) {
    if (id == null) throw new IllegalArgumentException("id was null");
    for (Person person : storage) {
      if (person.getId().equals(id)) return person;
    }
    return null;
  }

  @Override
  public boolean deleteById(Integer id) {
    return storage.remove(findById(id));
  }

  @Override
  public void update(Person model) {
    // todo: implement later
  }

  @Override
  public List<Person> findAll() {
    return new ArrayList<>(storage);
  }

  @Override
  public Optional<Person> findByUsername(String username) {
    if (username == null) throw new IllegalArgumentException("username was null");
    for (Person person : storage) {
      if (person.getAppUser().getUsername().equals(username)) return Optional.of(person);
    }
    return Optional.empty();
  }

}
