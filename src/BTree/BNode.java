package BTree;

public class BNode {

    private int valor;
    private Character letra;
    private BNode esq,dir;


    public BNode(int valor,Character letra){
        this.valor = valor;
        this.letra = letra;
        esq = dir = null;
    }

    public BNode(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }


    public void setValor(int valor) {
        this.valor = valor;
    }


    public BNode getEsq() {
        return esq;
    }


    public void setEsq(BNode esq) {
        this.esq = esq;
    }


    public BNode getDir() {
        return dir;
    }


    public void setDir(BNode dir) {
        this.dir = dir;
    }


    public Character getLetra() {
        return letra;
    }


    public void setLetra(char letra) {
        this.letra = letra;
    }

}
