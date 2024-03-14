package ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class exercicio_02 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("fichasjavas/files/exercicio_02.txt");

        PrintWriter writeFich = new PrintWriter(file);

        String novaLinha = "Vamos escrever algo no ficheiro de texto!";

        writeFich.println(novaLinha);

        writeFich.close();
    }
}
