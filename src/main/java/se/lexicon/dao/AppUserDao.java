package se.lexicon.dao;

import se.lexicon.model.AppUser;
import se.lexicon.model.Role;

import java.util.List;

public interface AppUserDao extends BaseDao<AppUser> {


  AppUser findByUsername(String username);

  List<AppUser> findByRole(Role role);

}
