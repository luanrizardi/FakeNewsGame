import java.util.List;
import java.util.Random;

public abstract class Objeto {
  private int x;
  private int y;

  public Objeto() {
    this.x = 1;
    this.y = 1;
  }

  public Objeto(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Objeto(List<Objeto> objetos) {
    boolean unico = false;
    while (!unico) {
      unico = true;
      this.x = generateRandom();
      this.y = generateRandom();
      for (Objeto objeto : objetos) {
        if (objeto.getX() == x && objeto.getY() == y)
          unico = false;
      }
    }
  }

  private static int generateRandom() {
    Random aleatorio = new Random();
    return aleatorio.nextInt(9) + 1;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }
}
