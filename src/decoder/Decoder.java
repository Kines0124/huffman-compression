package decoder;

import BTree.*;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Decoder {
    private String binPath;
    private BTree b = new BTree();

    public Decoder(String binPath){
        this.binPath = binPath;
    }


    public StringBuilder decodificador(String binPath) {

        StringBuilder resultado = new StringBuilder();

        try(DataInputStream dis = new DataInputStream(new FileInputStream(binPath))){

            Map<Character, Integer> headerFreq = new HashMap<>();
            int tamMap = dis.readShort();

            for(int i = 0; i < tamMap; i++) {
                Character key = dis.readChar();
                Integer value = dis.readInt();
                headerFreq.put(key, value);
            }

            int tamanhoConteudo = dis.readInt();

            BTree arvoreDecod = new BTree();
            arvoreDecod.huffmanTree(headerFreq);

            StringBuilder codificado = new StringBuilder();

            while (dis.available() > 0) {
                byte b = dis.readByte();
                String bin = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
                codificado.append(bin);
            }


            if (codificado.length() > tamanhoConteudo) {
                codificado.setLength(tamanhoConteudo);
            }

            BNode noAtual = arvoreDecod.getNo();

            Map<Character,String> lCod = arvoreDecod.codeMap();

            
            StringBuilder seqAtual = new StringBuilder();
            
            for (int i = 0; i < tamanhoConteudo; i ++){
            	seqAtual.append(codificado.charAt(i));

                for (Map.Entry<Character,String> entry : lCod.entrySet() ){
                    if (seqAtual.toString().equals(entry.getValue())){
                    	resultado.append(entry.getKey());
                    	seqAtual.setLength(0);
                    	break;
                    }
                }
            }



        }catch(FileNotFoundException e) {
            System.out.println("Arquivo binario não encontrado para leitura...");
        }catch(IOException e) {
            System.out.println("Erro ao ler o arquivo binario...");
        }
        return resultado;
    }

    public void decodificado(String binPath){
        StringBuilder decod = this.decodificador(binPath);
        FileManager.FileManager.escreverArquivo(decod);
    }



}
