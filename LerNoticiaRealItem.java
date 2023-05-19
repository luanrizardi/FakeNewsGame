class LerNoticiaRealItem extends Item {
    public LerNoticiaRealItem() {
        super("Ler Notícia Real");
    }

    public void usarItem(NoticiaReal noticiaReal) {
        System.out.println("Notícia Real lida: " + noticiaReal.getTitulo());
    }
}