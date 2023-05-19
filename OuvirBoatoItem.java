class OuvirBoatoItem extends Item {
    public OuvirBoatoItem() {
        super("Ouvir Boato");
    }

    public void usarItem(Boato boato) {
        System.out.println("Boato ouvido: " + boato.getDescricao());
    }
}