class DenunciarFakeNewsItem extends Item {
    public DenunciarFakeNewsItem() {
        super("Denunciar Fake News");
    }

    public void usarItem(FakeNews fakeNews) {
        System.out.println("Fake News denunciada: " + fakeNews.getTitulo());
    }
}