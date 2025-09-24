import java.io.File;

import decoder.Decoder;
import encoder.Encoder;

public class Main {
    public static void main(String[] args) {


        String pathTxt = "src/data/conteudo.txt";
        String pathBin = "src/data/conteudo.bin";

        Encoder enc = new Encoder(pathTxt);
        Decoder dec = new Decoder(pathBin);

        enc.escreverBinCodificado();
        dec.decodificado(pathBin);
        
        //Exibe o tamanho dos arquivos originais e bin
        File sizeTxt = new File ("src/data/conteudo.txt");
        File sizeBin = new File ("src/data/conteudo.bin");
        System.out.println("Tamanho arquivo descomprimido: " + sizeTxt.length());
        System.out.println("Tamanho arquivo comprimido: " + sizeBin.length());
        

    }
}