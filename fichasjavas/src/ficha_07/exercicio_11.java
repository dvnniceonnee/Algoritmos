package ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import static ficha_07.BibliotecaFiles.*;

public class exercicio_11 {



    public static String[] menuMeses() throws IndexOutOfBoundsException{
        String[] meses = new String[12];
        meses[0] = "Janeiro";
        meses[1] = "Fevereiro";
        meses[2] = "Março";
        meses[3] = "Abril";
        meses[4] = "Maio";
        meses[5] = "Junho";
        meses[6] = "Julho";
        meses[7] = "Agosto";
        meses[8] = "Setembro";
        meses[9] = "Outubro";
        meses[10] = "Novembro";
        meses[11] = "Dezembro";

        for (int i = 0; i < meses.length; i++){
            System.out.println((i+1) + ". " + meses[i]);
        }
        System.out.println("13. Sair");

        return meses;
    }

    public static void searchEvents(String[][] dados, String mes){
        for (int i = 0; i < dados.length; i++){
            if (dados[i][2].equals(mes)){
                System.out.println("Evento :" + dados[i][0] + "\t| Dia : " + dados[i][1] + "\t| Ano : " + dados[i][3] + "\t| Lotação : " + dados[i][4]);
            }
        }
    }
    public static String[][] matrizEventos;

    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);

        File ficheiroEventos = new File("fichasjavas/files/ficha_07/exercicio_11.csv");
        int[] quantidadeLinhas = new int[0];
        try{
            quantidadeLinhas = numeroLinhasColunas(ficheiroEventos);
        }catch (FileNotFoundException ex1){
            System.out.println("Ficheiro inválido!");
        }
        if(quantidadeLinhas.length > 0){
            int opcao = 0;
            matrizEventos = matrizDados(ficheiroEventos, quantidadeLinhas[0],quantidadeLinhas[1],true );
            do{
                String[] meses = menuMeses();
                System.out.print("\nIntroduza o mês que deseja pesquisar : ");
                try{
                    opcao =  input.nextInt();
                    int index = opcao-1;
                    if (opcao != 13)
                        searchEvents(matrizEventos, meses[index]);
                }
                catch (Exception ex1){
                    System.out.println("Mês introduzido invalido!");
                    input.next();
                }

            }while (opcao != 13);
        }

    }
}
