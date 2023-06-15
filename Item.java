import java.util.List;
import java.util.Random;

public class Item extends Objeto {
    private int tipo;

    public Item(List<Objeto> objetos) {
        super(objetos);
        this.tipo = gerarTipoAleatorio();
    }

    private static int gerarTipoAleatorio() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(4) + 1;
    }

    public int getTipo() {
        return tipo;
    }
}
