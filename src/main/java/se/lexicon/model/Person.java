package se.lexicon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
  // fields
  private Integer id;
  private String firstName;
  private String lastName;
  private AppUser appUser;
  private List<TodoItem> assignedTodos;

  // contractors
  public Person(Integer id, String firstName, String lastName, List<TodoItem> assignedTodos) {
   setId(id);
    setFirstName(firstName);
    setLastName(lastName);
    setAssignedTodos(assignedTodos);
  }

  public Person(String firstName, String lastName, AppUser appUser) {
    setFirstName(firstName);
    setLastName(lastName);
    this.assignedTodos = new ArrayList<>();
    setAppUser(appUser);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    if (id == null) throw new RuntimeException("id was null");
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    if(firstName == null) throw new IllegalArgumentException("firstName was null");
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    if(lastName == null) throw new IllegalArgumentException("lastName was null");
    this.lastName = lastName;
  }

  public AppUser getAppUser() {
    return appUser;
  }

  public void setAppUser(AppUser appUser) {
    if(appUser == null) throw new IllegalArgumentException("appUser was null");
    this.appUser = appUser;
  }

  public List<TodoItem> getAssignedTodos() {
    return assignedTodos;
  }

  public void setAssignedTodos(List<TodoItem> assignedTodos) {
    if(assignedTodos == null) assignedTodos = new ArrayList<>();
    this.assignedTodos = assignedTodos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }
}
