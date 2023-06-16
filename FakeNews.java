import java.util.List;
import java.util.Random;

public class FakeNews extends Objeto {
    private int tipo;

    public FakeNews(int tipo, int x, int y) {
        super(x, y);
        this.tipo = tipo;
    }

    // public Objeto(List<Objeto> objetos) {
    // boolean unico = false;
    // while (!unico) {
    // unico = true;
    // this.x = generateRandom();
    // this.y = generateRandom();
    // for (Objeto objeto : objetos) {
    // if (objeto.getX() == x && objeto.getY() == y)
    // unico = false;
    // }
    // }
    // }

    public FakeNews(List<Objeto> objetos) {
        boolean unico = false;
        while (!unico) {
            unico = true;
            setX(gerarPosicaoAleatoria());
            setY(gerarPosicaoAleatoria());
            for (Objeto objeto : objetos) {
                if (objeto.getX() == getX() && objeto.getY() == getY())
                    unico = false;
            }
        }
        this.tipo = gerarTipoAleatorio();
    }

    public int getTipo() {
        return tipo;
    }

    private static int gerarPosicaoAleatoria() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(7) + 2;
    }

    private static int gerarTipoAleatorio() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(3) + 1;
    }

    public void moverF1() {
        Random aleatorio = new Random();
        int tp = aleatorio.nextInt(4);

        switch (tp) {
            case 0:
                setY(getY() + 1);
                break;
            case 1:
                setY(getY() + 1);
                break;
            case 2:
                setX(getX() + 1);
                break;
            case 3:
                setX(getX() + 1);
                break;
        }
    }

    public void moverF2() {
        Random aleatorio = new Random();
        int tp = aleatorio.nextInt(4);

        switch (tp) {
            case 0:
                setY(getY() + 2);
                break;
            case 1:
                setY(getY() - 2);
                break;
            case 2:
                setX(getX() + 2);
                break;
            case 3:
                setX(getX() - 2);
                break;
        }
    }

    public void moverF3() {
        Random aleatorio = new Random();
        int tp = aleatorio.nextInt(4);

        switch (tp) {
            case 0:
                setY(getY() + 1);
                setX(getX() + 1);
                break;
            case 1:
                setY(getY() + 1);
                setX(getX() - 1);
                break;
            case 2:
                setY(getY() - 1);
                setX(getX() + 1);
                break;
            case 3:
                setY(getY() - 1);
                setX(getX() - 1);
                break;
        }
    }

    public void mover() {
        switch (tipo) {
            case 1:
                moverF1();
                break;
            case 2:
                moverF2();
                break;
            case 3:
                moverF3();
        }
    }
}
