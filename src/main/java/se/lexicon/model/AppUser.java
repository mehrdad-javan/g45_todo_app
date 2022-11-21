package se.lexicon.model;

import se.lexicon.dao.impl.sequencer.PersonIdSequencer;

import java.util.Objects;

public class AppUser {

  private Integer id;
  private String username;
  private String password;
  private boolean active;
  private Role role;

  public AppUser(Integer id, String username, String password, boolean active, Role role) {
    setId(id);
    setUsername(username);
    setPassword(password);
    setActive(active);
    setRole(role);
  }

  public AppUser(String username, String password, Role role) {
    setUsername(username);
    setPassword(password);
    setRole(role);
    this.active = true;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    if (id == null) throw new RuntimeException("id was null");
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    if (username == null || username.length() == 0) throw new IllegalArgumentException("username was null");
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    if (password == null) throw new IllegalArgumentException("password was null");
    if (password.length() < 8) throw new IllegalArgumentException("password length was not valid");
    this.password = password;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    if (role == null) role = Role.ROLE_USER;
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AppUser appUser = (AppUser) o;
    return active == appUser.active && Objects.equals(id, appUser.id) && Objects.equals(username, appUser.username) && role == appUser.role;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, active, role);
  }

  @Override
  public String toString() {
    return "AppUser{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", active=" + active +
            '}';
  }

}
