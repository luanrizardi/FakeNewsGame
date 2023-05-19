class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador;
    private FakeNews[] fakeNewsList;
    private NoticiaReal[] noticiaRealList;
    private Boato[] boatoList;
    private Item[] itemLista;

    public Jogo() {
        tabuleiro = new Tabuleiro(10);
        jogador = new Jogador("Jogador 1", tabuleiro);

        fakeNewsList = new FakeNews[3];
        fakeNewsList[0] = new FakeNews("Fake News 1");
        fakeNewsList[1] = new FakeNews("Fake News 2");
        fakeNewsList[2] = new FakeNews("Fake News 3");

        noticiaRealList = new NoticiaReal[3];
        noticiaRealList[0] = new NoticiaReal("Notícia Real 1");
        noticiaRealList[1] = new NoticiaReal("Notícia Real 2");
        noticiaRealList[2] = new NoticiaReal("Notícia Real 3");

        boatoList = new Boato[3];
        boatoList[0] = new Boato("Boato 1");
        boatoList[1] = new Boato("Boato 2");
        boatoList[2] = new Boato("Boato 3");

        itemLista = new Item[4];
        itemLista[0] = new DenunciarFakeNewsItem();
        itemLista[1] = new FugirItem();
        itemLista[2] = new LerNoticiaRealItem();
        itemLista[3] = new OuvirBoatoItem();
    }

    public void usarItem(int indiceItem) {
        Item item = itemLista[indiceItem];

        if (item instanceof DenunciarFakeNewsItem) {
            DenunciarFakeNewsItem denunciarFakeNewsItem = (DenunciarFakeNewsItem) item;
            int x = denunciarFakeNewsItem.getPosicaoX();
            int y = denunciarFakeNewsItem.getPosicaoY();
            FakeNews fakeNews = getFakeNewsByPosition(x, y);
            if (fakeNews != null) {
                denunciarFakeNewsItem.usarItem(fakeNews);
            } else {
                System.out.println("Não há Fake News nesta posição.");
            }
        } else if (item instanceof FugirItem) {
            FugirItem fugirItem = (FugirItem) item;
            fugirItem.usarItem(jogador);
        } else if (item instanceof LerNoticiaRealItem) {
            LerNoticiaRealItem lerNoticiaRealItem = (LerNoticiaRealItem) item;
            int x = lerNoticiaRealItem.getPosicaoX();
            int y = lerNoticiaRealItem.getPosicaoY();
            NoticiaReal noticiaReal = getNoticiaRealByPosition(x, y);
            if (noticiaReal != null) {
                lerNoticiaRealItem.usarItem(noticiaReal);
            } else {
                System.out.println("Não há Notícia Real nesta posição.");
            }
        } else if (item instanceof OuvirBoatoItem) {
            OuvirBoatoItem ouvirBoatoItem = (OuvirBoatoItem) item;
            int x = ouvirBoatoItem.getPosicaoX();
            int y = ouvirBoatoItem.getPosicaoY();
            Boato boato = getBoatoByPosition(x, y);
            if (boato != null) {
                ouvirBoatoItem.usarItem(boato);
            } else {
                System.out.println("Não há Boato nesta posição.");
            }
        }
    }

    private FakeNews getFakeNewsByPosition(int x, int y) {
        for (FakeNews fakeNews : fakeNewsList) {
            if (fakeNews.getPosicaoX() == x && fakeNews.getPosicaoY() == y) {
                return fakeNews;
            }
        }
        return null;
    }

    private NoticiaReal getNoticiaRealByPosition(int x, int y) {
        for (NoticiaReal noticiaReal : noticiaRealList) {
            if (noticiaReal.getPosicaoX() == x && noticiaReal.getPosicaoY() == y) {
                return noticiaReal;
            }
        }
        return null;
    }

    private Boato getBoatoByPosition(int x, int y) {
        for (Boato boato : boatoList) {
            if (boato.getPosicaoX() == x && boato.getPosicaoY() == y) {
                return boato;
            }
        }
        return null;
    }
}