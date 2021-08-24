package PJBL1;

public class Chave {
    private int[] meuArray;
    private int index;

    public Chave(){
        this.meuArray = new int[100];
        this.index = 0;
        // cria o array e preenche todos os espacos com 0
        for(byte i=0;i<this.meuArray.length;i++){
            this.meuArray[i] = 0;
        }
    }

    public void addElement(byte e){
        this.meuArray[index] = e;
    }

    public int[] getArray(){
        return this.meuArray;
    }

}
