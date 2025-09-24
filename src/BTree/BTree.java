package BTree;

import java.util.*;

public class BTree {
    private BNode no;

    public BTree () {
        no = null;
    }


    public Map<Character,Integer> freq (String frase) {
        Map<Character, Integer> minHeap = new HashMap<>();
        char[] chars = new char[frase.length()];
        chars = frase.toCharArray();

        for(char i : chars) {
            minHeap.put(i, minHeap.getOrDefault(i, 0) + 1);
        }

        return minHeap;
    }

    public void huffmanTree(Map<Character,Integer> freq) {
        PriorityQueue<BNode> listaNos = new PriorityQueue<>(Comparator.comparingInt(BNode::getValor));

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            BNode no = new BNode(entry.getValue(), entry.getKey());
            listaNos.add(no);
        }

        while(listaNos.size() > 1) {

            BNode menor1 = listaNos.poll();
            BNode menor2 = listaNos.poll();

            BNode pai = new BNode(menor1.getValor() + menor2.getValor());
            pai.setEsq(menor1);
            pai.setDir(menor2);

            listaNos.add(pai);
        }
        this.no = listaNos.poll();
    }

    public Map<Character, String> codeMap() {
        Map<Character, String> cod = new HashMap<>();
        codeTree(this.no,"",cod);
        return cod;
    }


    public void codeTree(BNode no, String codAtual, Map<Character,String> codigos) {
        if (no == null) return ;

        if(no.getLetra() != null) {
            codigos.put(no.getLetra(), codAtual);
            return;
        }
        codeTree(no.getEsq(),codAtual + "0", codigos);
        codeTree(no.getDir(),codAtual + "1", codigos);
    }

    public BNode getNo() {
        return no;
    }

    public void setNo(BNode no) {
        this.no = no;
    }
}
