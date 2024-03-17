package ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ficha_07.BibliotecaFiles.*;


public class exercicio_09 {

    public static String menu() {
        String menuOpcoes = "";
        menuOpcoes = "1. Pesquisar musicas por genero\n" +
                "2. Pesquisar por um artista\n" +
                "3. Pesquisar a musica com maior duração\n" +
                "4. Pesquisar musicas com maior duração de um valor (minutos)\n" +
                "5. Numero total de musicas no ficheiro : \n" +
                "6. Sair\n";
        return menuOpcoes;
    }
    /**
     * Função para retornar uma lista de dados consoante a pesquisa indica pelo utilizar
     * @param matriz     recebe uma matriz com os dados que queremos pesquisar das musicas
     * @param dado       a informação do genero ou do artista que pretendemos procurar
     * @param colunaDado a coluna onde vai estar a informação do dado
     * @return um array com os dados todos filtrados pelos parametros
     */
    public static String[] listaDadosEspecifico(String[][] matriz, String dado, int colunaDado) {
        String[] conjuntoDados = new String[0];

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][colunaDado].equals(dado)) {
                if (conjuntoDados.length == 0) {
                    conjuntoDados = new String[1];
                    conjuntoDados[0] = matriz[i][0];
                } else {
                    String[] temp = new String[conjuntoDados.length + 1];
                    for (int k = 0; k < conjuntoDados.length; k++) {
                        temp[k] = conjuntoDados[k];
                    }
                    temp[conjuntoDados.length] = matriz[i][0];
                    conjuntoDados = temp;
                }
            }
        }
        return conjuntoDados;

    }
    /**
     * Função para vericiar a musica com o maior tempo de duração da lista
     *
     * @param matriz recebe uma matriz de dados com as informações das musicas
     * @return um array com a musica e o tempo caso seja pretendido apresentar os dois
     */
    public static String[] musicaTempoMaior(String[][] matriz) {
        String[] musicaMaiorTempo = new String[2];
        int maiorTempo = 0;
        for (int i = 0; i < matriz.length; i++) {
            String[] tempo = matriz[i][3].split(":");
            int tempoSegundos = (Integer.parseInt(tempo[0]) * 60) + Integer.parseInt(tempo[1]);
            if (tempoSegundos > maiorTempo) {
                maiorTempo = tempoSegundos;
                musicaMaiorTempo[0] = matriz[i][0];
                musicaMaiorTempo[1] = matriz[i][3];
            }
        }
        return musicaMaiorTempo;
    }

    /**
     * Função para retornar uma lista de musicas que tenham uma duração maior de um valor
     *
     * @param matriz     recebe uma matriz com as musicas e as informações
     * @param tempoAcima recebe um tempo total em formato de segundos para ver qual as musicas que sao acima desses segundos
     * @return uma matriz com a musica e o tempo em 2 colunas
     */
    public static String[][] musicasAcimaDuracao(String[][] matriz, int tempoAcima) {
        String[][] musicasLista = new String[0][0];
        for (int i = 0; i < matriz.length; i++) {
            String[] tempo = matriz[i][3].split(":");
            int tempoSegundos = (Integer.parseInt(tempo[0]) * 60) + Integer.parseInt(tempo[1]);
            if (tempoSegundos > tempoAcima) {
                if (musicasLista.length == 0) {
                    musicasLista = new String[1][2];
                    musicasLista[0][0] = matriz[i][0];
                    musicasLista[0][1] = matriz[i][3];
                } else {
                    String[][] matrizTemp = new String[musicasLista.length + 1][musicasLista[0].length];
                    for (int k = 0; k < musicasLista.length; k++) {
                        for (int e = 0; e < musicasLista[0].length; e++) {
                            matrizTemp[k][e] = musicasLista[k][e];
                        }
                    }
                    matrizTemp[musicasLista.length][0] = matriz[i][0];
                    matrizTemp[musicasLista.length][1] = matriz[i][3];
                    musicasLista = matrizTemp;
                }
            }
        }
        return musicasLista;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        File musicas = musicas = new File("fichasjavas/files/exercicio_09.csv");
        boolean valido = false;
        int[] quantLinhasCol = new int[0];
        try{
            quantLinhasCol = numeroLinhasColunas(musicas);
            valido = true;
        }catch (FileNotFoundException ex1){
            System.out.println("Ficheiro Inválido!");
        }
        if (valido) {
            int linhas = quantLinhasCol[0];
            int colunas = quantLinhasCol[1];
            String[][] matrizMusics = matrizDados(musicas, linhas, colunas, true);
            int opcao = 0;
            do {
                System.out.print(menu());
                System.out.println("Introduza a opção pretendida : ");
                try {
                    opcao = input.nextInt();
                } catch (InputMismatchException ex1) {
                    opcao = 0;
                }
                switch (opcao) {
                    case 1:
                        String[] listaGeneros = listaDadosColuna(matrizMusics, 2);
                        int opcaoGenero = 0;
                        for (int i = 0; i < listaGeneros.length; i++) {
                            System.out.println(i + 1 + ". " + listaGeneros[i]);
                            opcaoGenero = i;
                        }

                        System.out.print("\nEscolha o genero :");
                        try {
                            opcaoGenero = input.nextInt();
                        } catch (InputMismatchException ex1) {
                            System.out.println("opção inválida! Genero vai ser o 1.!");
                            opcaoGenero = 1;
                            input.next();
                        }
                        System.out.println();
                        String[] listaMusicas = listaDadosEspecifico(matrizMusics, listaGeneros[opcaoGenero - 1], 2);
                        for (int i = 0; i < listaMusicas.length; i++) {
                            System.out.println("- " + listaMusicas[i]);
                        }
                        System.out.println();
                        break;
                    case 2:
                        String[] listaArtistas = listaDadosColuna(matrizMusics, 1);
                        int opcaoArtista = 0;
                        for (int i = 0; i < listaArtistas.length; i++) {
                            System.out.println(i + 1 + ". " + listaArtistas[i]);
                            opcaoArtista = i;
                        }
                        System.out.print("\nEscolha o artista :");
                        try {
                            opcaoArtista = input.nextInt();
                        } catch (InputMismatchException ex1) {
                            System.out.println("\nOpção inválida! Genero vai ser o 1.!");
                            input.next();
                        }
                        System.out.println();
                        String[] listaMusicas2 = listaDadosEspecifico(matrizMusics, listaArtistas[opcaoArtista - 1], 1);
                        for (int i = 0; i < listaMusicas2.length; i++) {
                            System.out.println("- " + listaMusicas2[i]);
                        }
                        System.out.println();
                        break;
                    case 3:
                        String[] musicaMaior = musicaTempoMaior(matrizMusics);
                        System.out.println("\nA musica com maior tempo é : " + musicaMaior[0]);
                        System.out.println("O seu tempo é : " + musicaMaior[1] + " minutos\n");
                        break;
                    case 4:
                        System.out.print("Introduza quantos minutos as musicas tem de ser maiores: ");
                        int minutosEscolhidos = 0;
                        try {
                            minutosEscolhidos = input.nextInt();
                        } catch (InputMismatchException ex1) {
                            System.out.println("Valor invalido, minutos vão ser 0");
                            input.next();
                        }
                        minutosEscolhidos *= 60;
                        System.out.print("\nIntroduza quantos segundos as musicas tem de ser maiores: ");
                        int segundosEscolhidos = 0;
                        try {
                            segundosEscolhidos = input.nextInt();
                        } catch (Exception ex1) {
                            System.out.println("Valor inválido! Segundos vão ser 30");
                            segundosEscolhidos = 30;
                            input.next();
                        }
                        int segundosTotais = minutosEscolhidos + segundosEscolhidos;
                        String[][] musicasAcimaValor = musicasAcimaDuracao(matrizMusics, segundosTotais);
                        for (int i = 0; i < musicasAcimaValor.length; i++) {
                            System.out.println("Musica : " + musicasAcimaValor[i][0] + "\t - Tempo: " + musicasAcimaValor[i][1]);
                        }
                        System.out.println();
                        break;
                    case 5:
                        System.out.println("\nExiste " + (linhas - 1) + " musicas no ficheiro!\n");
                        break;
                    default:
                        System.out.println("\nOpção inválida!\n");
                }
            } while (opcao != 6);
        }
    }
}
