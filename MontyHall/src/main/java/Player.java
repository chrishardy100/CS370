import java.util.List;
import java.util.Random;

abstract public class Player {
  protected List<Door> doors;
  protected GameshowHost monty;
  protected int selection;

  public Player(List<Door> doors, GameshowHost monty) {
    this.doors = doors;
    this.monty = monty;
  }

  public void makeFirstSelection() {
    Random r = new Random();
    selection = r.nextInt(3);
    monty.hearFirstChoice(selection);
  }

  public abstract boolean makeSecondSelection();

  // concrete method
  // Template Method Pattern
  public boolean play() {
    makeFirstSelection();
    boolean bDidIWin = makeSecondSelection();
    return bDidIWin;
  }

}
