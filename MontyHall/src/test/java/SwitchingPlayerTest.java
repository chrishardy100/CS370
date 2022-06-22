
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SwitchingPlayerTest {

    SwitchingPlayer player;

    @org.junit.Before
    public void setUp() throws Exception {
        player = new SwitchingPlayer(Player.doors, Player.monty);
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void makeSecondSelection() {
        player.makeSecondSelection();
        assertEquals(player.selection, player.makeSecondSelection());
    }

}