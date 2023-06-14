import java.util.Random;

public class FakeNews extends Objeto {
    private int tipo;

    public FakeNews(int tipo, int x, int y) {
        super(x, y);
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
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
