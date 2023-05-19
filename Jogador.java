class Jogador {
    private String nome;
    private Tabuleiro tabuleiro;

    public Jogador(String nome, Tabuleiro tabuleiro) {
        this.nome = nome;
        this.tabuleiro = tabuleiro;
    }

    public String getNome() {
        return nome;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setPosicao(int x, int y) {
        tabuleiro.setPosicao(x, y, 1);
    }
}