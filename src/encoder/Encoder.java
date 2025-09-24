package encoder;

import BTree.*;
import java.util.HashMap;
import java.util.Map;

public class Encoder {
    private String filePath;
    private BTree b;

    public Encoder(String path){
        b = new BTree();
        filePath = path;
    }


    public String codString (String palavra, Map<Character, String> code) {
        String fullCod = "";


        for (char c : palavra.toCharArray()) {
            String valor = code.get(c);
            fullCod += valor;
        }
        return fullCod;
    }

    public void escreverBinCodificado(){
        // 1. Ler o conteúdo do arquivo texto
        String conteudoArquivo = FileManager.FileManager.lerArquivo(filePath);

        //Cria a arvore e os maps de freq e codigo para cada char
        Map<Character, Integer> freq = b.freq(conteudoArquivo);
        b.huffmanTree(freq);
        Map<Character, String> codigos = b.codeMap();

        //Codifica
        String codificado = this.codString(conteudoArquivo, codigos);

        
        FileManager.FileManager.escreverBin(freq, codificado);
    }

}
