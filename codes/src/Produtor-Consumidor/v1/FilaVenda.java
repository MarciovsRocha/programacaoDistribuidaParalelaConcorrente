class FilaVenda {

    private static ArrayList<Venda> fila = new ArrayList<Venda>();


    // implementa uma fila que contém instâncias da classe Venda
    public static void insereVendaNaFila(Venda venda) {
        fila.add(venda);
    }

    public static void retiraVendaDaFila() {
        fila.remove(0);
    }
    
}