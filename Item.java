class Item {
    private String nome;
    private int posicaoX;
    private int posicaoY;

    public Item(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
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