public class Jogador {
    private String nome;
    private int posicaoX;
    private int posicaoY;

    public Jogador(String nome, int posicaoX, int posicaoY) {
        this.nome = nome;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }

    public String getNome() {
        return nome;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void moverParaCima() {
        posicaoX--;
    }

    public void moverParaBaixo() {
        posicaoX++;
    }

    public void moverParaEsquerda() {
        posicaoY--;
    }

    public void moverParaDireita() {
        posicaoY++;
    }

}
