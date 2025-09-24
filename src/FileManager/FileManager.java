package FileManager;

import java.io.*;
import java.util.Map;

public class FileManager {

    public static String lerArquivo(String caminho){
        String frase = "";

        try(BufferedReader reader = new BufferedReader(new FileReader(caminho));){
            String linha;
            while((linha = reader.readLine()) != null){
                frase += linha + "\n";
            }
        }catch (FileNotFoundException e ){
            System.out.println("Não foi possível encontrar o arquivo de texto para leitura...");
        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo");
        }
        return frase;
    }


    public static void escreverArquivo(StringBuilder resultado){
        try(BufferedWriter write = new BufferedWriter(new FileWriter("src/data/decodificado.txt"));){
            write.write(resultado.toString());
        }catch (FileNotFoundException e ){
            System.out.println("Não foi possível encontrar o arquivo de texto para escrita...");
        }catch(IOException e){
            System.out.println("Erro ao escrever o arquivo");
        }
    }

    public static void escreverBin(Map<Character,Integer> freq, String codificado) {
        int n = freq.size();
        int tamanhoStringCodificada = codificado.length();

        try(DataOutputStream os = new DataOutputStream(new FileOutputStream("src/data/conteudo.bin"))) {

            os.writeShort(n);

            for (Map.Entry<Character,Integer> entry : freq.entrySet()) {
                os.writeChar(entry.getKey());
                os.writeInt(entry.getValue());
            }
            os.writeInt(tamanhoStringCodificada);

            for (int i = 0; i< codificado.length(); i += 8) {
                int fim = Math.min(i + 8, codificado.length());
                String byteSubString = codificado.substring(i, fim);

                if (byteSubString.length() < 8) {
                    byteSubString = byteSubString + "0".repeat(8 - byteSubString.length());
                }

                int byteValue = Integer.parseInt(byteSubString, 2);
                os.writeByte(byteValue);
            }

        }catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado para escrita binaria...");
        }catch(IOException e) {
            System.out.println("Erro ao escrever o arquivo binario...");
        }

    }

}
