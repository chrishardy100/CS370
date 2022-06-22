import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    // make doors
    List<Door> doorList = new ArrayList<>();
    doorList.add(new Door(Prize.GOAT));
    doorList.add(new Door(Prize.GOAT));
    doorList.add(new Door(Prize.CAR));
//    Random random = new Random();
//    doorList.get(random.nextInt(3)).setPrize(Prize.CAR);

    int switchWins = 0;
    int keepWins = 0;
    final int trials = 1000;
    Player player;
    GameshowHost monty;
    for (int i = 0; i < trials; i++) {
      // make gameshow host
       monty = new GameshowHost(doorList);

      // make player
      player = new SwitchingPlayer(doorList, monty);
      if (player.play())
        switchWins++;

      monty = new GameshowHost(doorList);

      // make player
      player = new KeepingPlayer(doorList, monty);
      if (player.play())
        keepWins++;

    }
    System.out.println("switch pct wins =" + (switchWins / 1000.0));
    System.out.println("keep   pct wins =" + (keepWins / 1000.0));
  }
}
