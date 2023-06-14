import java.util.Random;

public class FakeNews {
    private int tipo;
    private int x;
    private int y;
    // teste commit
    public FakeNews(int tipo, int x, int y) {
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moverF1(){
        Random aleatorio = new Random();
        int tp = aleatorio.nextInt(4) + 1;
        int novaLinha = getX();
        int novaColuna = getY();

        switch(tp){
            case 1:
                novaColuna++;
                setY(novaColuna);
            case 2:
                novaColuna--;
                setY(novaColuna);
            case 3:
                novaLinha++;
                setX(novaLinha);
            case 4:
                novaLinha--;
                setX(novaLinha);
        }
    }

    public void moverF2(){
        Random aleatorio = new Random();
        int tp = aleatorio.nextInt(4) + 1;
        int novaLinha = getX();
        int novaColuna = getY();

        switch(tp){
            case 1:
                novaColuna = novaColuna + 2;
                setY(novaColuna);
            case 2:
                novaColuna = novaColuna - 2;
                setY(novaColuna);
            case 3:
                novaLinha = novaLinha + 2;
                setX(novaLinha);
            case 4:
                novaLinha = novaLinha - 2;
                setX(novaLinha);
        }
    }

    public void moverF3(){
        Random aleatorio = new Random();
        int tp = aleatorio.nextInt(4) + 1;
        int novaLinha = getX();
        int novaColuna = getY();

        switch(tp){
            case 1:
                novaColuna++;
                novaLinha++;
                setY(novaColuna);
                setX(novaLinha);
            case 2:
                novaColuna++;
                novaLinha--;
                setY(novaColuna);
                setX(novaLinha);
            case 3:
                novaColuna--;
                novaLinha++;
                setY(novaColuna);
                setX(novaLinha);
            case 4:
                novaColuna--;
                novaLinha--;
                setY(novaColuna);
                setX(novaLinha);
        }
    }

    public void mover(){
        if (this.tipo == 1){
            moverF1();
        }
        else if(this.tipo == 2){
            moverF2();
        }
        else if(this.tipo == 3){
            moverF3();
        }


    }
    
    public void duplicar() {
    }

    public void colidirComJogador() {
    }

    public void eliminada(){
        
    }
}
