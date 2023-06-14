import java.util.Random;

public class SetorRestrito extends Objeto{

  SetorRestrito() {
    super(generateRandomX(), generateRandomY());
  }

  private static int generateRandomX() {
    Random aleatorio = new Random();
    return aleatorio.nextInt(9) + 1;
  }

  private static int generateRandomY() {
      Random aleatorio = new Random();
      return aleatorio.nextInt(9) + 1;
  }
}
