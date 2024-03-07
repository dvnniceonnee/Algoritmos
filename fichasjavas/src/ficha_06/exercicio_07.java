package ficha_06;

import java.util.Scanner;

public class exercicio_07 {
    public static void main(String[] args) {
        // Scanner
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Design de Quadrados >>>>>\n");
        System.out.print("Introduza um caracter : "); // caractere a ser apresentado em forma de quadrado
        String caracter = input.next();
        System.out.print("Introduza numeros de linhas:");
        int numeroLinhas = input.nextInt();
        System.out.print("Introduza numero de colunas : ");
        int numeroColunas = input.nextInt();

        String[][] matriz = new String[numeroLinhas][numeroColunas];

        for (int i = 0; i < matriz.length; i++) { // iterar o numero de linhas do array
            for (int j = 0; j < matriz[0].length; j++) { // iterar o numero de colunas de cada linha do array
                if (i == 0 || i == matriz.length - 1) { // caso seja a primeira linha ou a ultima insere graficamente uma linha de caracteres
                    matriz[i][j] = caracter;
                } else {
                    if (j == 0 || j == matriz[0].length - 1) { // caso seja a coluna seja a primera ou a ultima adiciona o caractere so a essa coluna
                        matriz[i][j] = caracter; // para apresentar graficamente as linhas laterais do quadrado
                    }
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) { // iterar as linhas todas do array
            for (int j = 0; j < matriz[0].length; j++) { // iterar as colunas todas do array
                if (matriz[i][j] == null) { // caso a coluna nao tenha nenhum valor apresenta um espaço em vez de null
                    System.out.print(" "); // define basicamente que o conteudo do quadrad está vazio
                } else {
                    System.out.print(matriz[i][j]); // se conter o caractere apresenta
                }

            }
            System.out.println();
        }
        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
