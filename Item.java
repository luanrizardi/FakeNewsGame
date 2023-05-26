import java.util.Random;

public class Item {
    private int tipo;
    private int x;
    private int y;

    public Item() {
        Random aleatorio = new Random();
        int x, y, tp;

        tp = aleatorio.nextInt(4) + 1;
        x = aleatorio.nextInt(9) + 1;
        y = aleatorio.nextInt(9) + 1;
        this.tipo = tp;
        this.x = x;
        this.y = y;
    }

    public int getTipo() {
        return tipo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void eliminar() {
    }

}
