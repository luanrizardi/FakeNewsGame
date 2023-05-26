import java.util.Random;

public class FakeNews {
    private int tipo;
    private int x;
    private int y;

    public FakeNews(int tipo) {
        Random aleatorio = new Random();
        int x, y;

        x = aleatorio.nextInt(9) + 1;
        y = aleatorio.nextInt(9) + 1;

        this.tipo = tipo;
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

    public void mover(){
        if (this.tipo == 1){
            
        }


    }
    
    public void duplicar() {
    }

    public void colidirComJogador() {
    }

    public void eliminada(){
        
    }
}
