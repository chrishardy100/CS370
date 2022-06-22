public class Door {
  private Prize prize;
  private boolean bOpen;

  public Door(Prize prize) {
    this.prize = prize;
  }

  public void setPrize(Prize prize) {
    this.prize = prize;
  }

  public Prize look() {
    if (isOpen())
      return prize;
    else
      return Prize.UNKNOWN;
  }

  public Prize peek() {
    return prize;
  }

  public boolean isOpen() {
    return this.bOpen;
  }

  public void open() {
    this.bOpen = true;
  }

  public void close() {
    this.bOpen = false;
  }
}
