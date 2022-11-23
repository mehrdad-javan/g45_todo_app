package se.lexicon.dao.impl.sequencer;

public class AppUserIdSequencer {

  private static int sequencer = 100;

  public static int nextId() {
    return ++sequencer;
  }
}
