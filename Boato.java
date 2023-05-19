class Boato {
    private String descricao;
    private int posicaoX;
    private int posicaoY;

    public Boato(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setPosicao(int x, int y) {
        posicaoX = x;
        posicaoY = y;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }
}