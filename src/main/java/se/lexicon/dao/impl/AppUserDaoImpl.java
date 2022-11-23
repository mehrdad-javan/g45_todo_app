package se.lexicon.dao.impl;

import se.lexicon.App;
import se.lexicon.dao.AppUserDao;
import se.lexicon.dao.impl.sequencer.AppUserIdSequencer;
import se.lexicon.dao.impl.sequencer.PersonIdSequencer;
import se.lexicon.model.AppUser;
import se.lexicon.model.Role;

import java.util.ArrayList;
import java.util.List;

public class AppUserDaoImpl implements AppUserDao {

  private List<AppUser> storage;

  private static AppUserDaoImpl instance;

  private AppUserDaoImpl() {
    storage = new ArrayList<>();
  }

  public static AppUserDaoImpl getInstance(){
    if (instance == null) instance = new AppUserDaoImpl();
    return instance;
  }

  @Override
  public AppUser create(AppUser appUser) {
    if (appUser == null) throw new IllegalArgumentException("appUser was null");
    // check -> the username must not be duplicate
    appUser.setId(AppUserIdSequencer.nextId());
    storage.add(appUser);
    return appUser;
  }

  @Override
  public AppUser findById(Integer id) {
    if (id == null) throw new IllegalArgumentException("id was null");
    for (AppUser appUser : storage)
      if (appUser.getId().equals(id)) return appUser;

    return null;
  }

  @Override
  public boolean deleteById(Integer id) {
    AppUser result = findById(id);
    return storage.remove(result);
  }

  @Override
  public void update(AppUser toUpdate) {
    if (toUpdate == null) throw new IllegalArgumentException("toUpdate data was null");
    for (AppUser original : storage) {
      if (original.getId().equals(toUpdate.getId())) {
        original.setUsername(toUpdate.getUsername());
        original.setPassword(toUpdate.getPassword());
        original.setRole(toUpdate.getRole());
        original.setActive(toUpdate.isActive());
        break;
      }
    }

  }

  @Override
  public List<AppUser> findAll() {
    return new ArrayList<>(storage);
  }

  @Override
  public AppUser findByUsername(String username) {
    if (username == null) throw new IllegalArgumentException("username was null");
    for (AppUser appUser : storage)
      if (appUser.getUsername().equals(username)) return appUser;
    return null;
  }

  @Override
  public List<AppUser> findByRole(Role role) {
    if (role == null) throw new IllegalArgumentException("role was null");
    List<AppUser> filteredList = new ArrayList<>();
    for(AppUser appUser: storage){
      if (appUser.getRole() == role){
        filteredList.add(appUser);
      }
    }

    return filteredList;
  }
}
