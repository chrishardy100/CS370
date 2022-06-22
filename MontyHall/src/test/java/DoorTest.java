import static org.junit.Assert.*;

public class DoorTest {
  Door door;
  @org.junit.Before
  public void setUp() throws Exception {
    door = new Door(Prize.CAR);
  }

  @org.junit.After
  public void tearDown() throws Exception {
  }

  @org.junit.Test
  public void setPrize() {
    door.setPrize(Prize.CAR);
    assertEquals(Prize.CAR, door.peek());
  }

  @org.junit.Test
  public void look() {
    door.setPrize(Prize.CAR);
    door.open();
    assertEquals(Prize.CAR, door.look());

    door.close();
    assertEquals(Prize.UNKNOWN, door.look());
  }

  @org.junit.Test
  public void peek() {
    door.setPrize(Prize.CAR);
    assertEquals(Prize.CAR, door.peek());

    door.setPrize(Prize.GOAT);
    assertEquals(Prize.GOAT, door.peek());
  }

  @org.junit.Test
  public void isOpen() {
    door.open();
    assertEquals(true, door.isOpen());

    door.close();
    assertEquals(false, door.isOpen());
  }

  @org.junit.Test
  public void open() {
    door.open();
    assertEquals(true, door.isOpen());
  }

  @org.junit.Test
  public void close() {
    door.close();
    assertEquals(false, door.isOpen());

  }
}