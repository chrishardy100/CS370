import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameshowHost {
  List<Door> doorList;

  public GameshowHost(List<Door> doorList) {
    this.doorList = doorList;
    for (Door d: doorList)
      d.close();
    Collections.shuffle(doorList);
  }

  public void hearFirstChoice(int selection) {
    Random r = new Random();
    int reveal;
    do {
      reveal = r.nextInt(3);
    } while (doorList.get(reveal).peek() != Prize.GOAT || reveal == selection);

    doorList.get(reveal).open();
  }

  public boolean hearSecondChoice(int selection) {
    if (selection >= 3)
      throw new IllegalArgumentException("Player choice must be between 0 and 2");

    Door theDoor = doorList.get(selection);
    theDoor.open();

    return theDoor.look() == Prize.CAR;
  }

}
