import java.util.Random;

public class Item extends Objeto {
    private int tipo;

    public Item() {
        super(generateRandomX(), generateRandomY());
        this.tipo = generateRandomTipo();
    }

    private static int generateRandomX() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(9) + 1;
    }

    private static int generateRandomY() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(9) + 1;
    }

    private static int generateRandomTipo() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(4) + 1;
    }

    public int getTipo() {
        return tipo;
    }

    public void eliminar() {
    }

}
