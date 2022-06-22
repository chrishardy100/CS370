import java.util.List;

public class KeepingPlayer extends Player {
  public KeepingPlayer(List<Door> doors, GameshowHost monty) {
    super(doors, monty);
  }

  @Override
  public boolean makeSecondSelection() {
      // Keep the same door!
      return monty.hearSecondChoice(selection);
  }
}