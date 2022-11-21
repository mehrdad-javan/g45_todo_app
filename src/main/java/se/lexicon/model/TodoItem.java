package se.lexicon.model;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
  private Integer id;
  private String title;
  private String description;
  private LocalDate deadline;
  private boolean done;
  private Person assignee;


  public TodoItem(Integer id, String title, String description, LocalDate deadline, boolean done, Person assignee) {
    setId(id);
    setTitle(title);
    setDescription(description);
    setDeadline(deadline);
    setDone(done);
    setAssignee(assignee);
  }

  public TodoItem(String title, String description, LocalDate deadline) {
    setTitle(title);
    setDescription(description);
    setDeadline(deadline);
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    if (id == null) throw new RuntimeException("id was null");
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    if (title == null) throw new IllegalArgumentException("title was null");

    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDate deadline) {
    if (deadline == null) throw new IllegalArgumentException("deadline was null");
    this.deadline = deadline;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public Person getAssignee() {
    return assignee;
  }

  public void setAssignee(Person assignee) {
    this.assignee = assignee;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TodoItem todoItem = (TodoItem) o;
    return done == todoItem.done && Objects.equals(id, todoItem.id) && Objects.equals(title, todoItem.title) && Objects.equals(description, todoItem.description) && Objects.equals(deadline, todoItem.deadline);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, deadline, done);
  }

  @Override
  public String toString() {
    return "TodoItem{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", deadline=" + deadline +
            ", done=" + done +
            ", personName=" + assignee.getFirstName() + " " + assignee.getLastName() +
            '}';
  }
}
