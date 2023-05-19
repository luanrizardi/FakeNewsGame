class NoticiaReal {
    private String titulo;
    private int posicaoX;
    private int posicaoY;

    public NoticiaReal(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
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