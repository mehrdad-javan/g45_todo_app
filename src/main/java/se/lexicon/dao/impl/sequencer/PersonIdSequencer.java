package se.lexicon.dao.impl.sequencer;

public class PersonIdSequencer {

  private static int sequencer = 100;

  public static int nextId() {
    return ++sequencer;
  }
}
