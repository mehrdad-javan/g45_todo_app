package se.lexicon.dao;

import se.lexicon.model.AppUser;
import se.lexicon.model.Role;

import java.util.List;

public interface AppUserDao {

  AppUser create(AppUser appUser);

  AppUser findById(Integer id);

  boolean deleteById(Integer id);

  void update(AppUser appUser);

  List<AppUser> findAll();

  AppUser findByUsername(String username);

  List<AppUser> findByRole(Role role);

}
