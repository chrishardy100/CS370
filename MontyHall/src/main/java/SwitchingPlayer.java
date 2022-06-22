import java.util.List;

public class SwitchingPlayer extends Player {

  public SwitchingPlayer(List<Door> doors, GameshowHost monty) {
    super(doors, monty);
  }

  @Override
  public boolean makeSecondSelection() {
    for (int i = 0; i < doors.size(); i++) {
      Door d = doors.get(i);
      if (!d.isOpen() && i != selection) {
        selection = i;
        return monty.hearSecondChoice(selection);
      }
    }
    return false;
  }
}
