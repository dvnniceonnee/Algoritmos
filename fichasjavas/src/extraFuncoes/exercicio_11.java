package extraFuncoes;

import java.util.Scanner;

public class exercicio_11 {
    /*
    matrizOriginal = matriz original sem quaisqueres alteraçoes que vai ser um conjunto de numeros de 1 a 9
     */
    public static String[][] matrizOriginal() {
        String[][] matrizOriginal = new String[3][3];
        int contador = 1;
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int k = 0; k < matrizOriginal[0].length; k++) {
                matrizOriginal[i][k] = String.valueOf(contador);
                contador++;
            }
        }
        return matrizOriginal;
    }

    /*
    pedirJogada método para pedir ao jogador que faça uma jogada e verifica se o numero da jogada é valido
    Scanner teclado = parametro que pede o input
    String jogador = pede o nome do jogador que vai jogar
     */
    public static int pedirJogada(Scanner teclado, String jogador, String[][] matriz) {
        int posicao = 0;
        System.out.print(jogador + " faça a sua próxima jogada (1-9) : ");
        posicao = teclado.nextInt();
        boolean validaounao = false;
        do{
            while (posicao < 1 || posicao > 9) {
                System.out.println(jogador + " Jogada inválida!");
                System.out.print(jogador +" faça novamente a sua próxima jogada (1-9) : ");
                posicao = teclado.nextInt();
            }
            if (validacaoJogada(matriz, posicao)) {
                validaounao = true;
            }
            else {
                posicao = 0;
            }

        }while (!validaounao);
        return posicao;
    }

    /*
    ValidaçãoJogada metodo para validar se a jogada é valida consoante as jogas já feitas
    String[][] matrizJogoAtual = parametro que pede a matrizAtual
    int num = poiçao pretendida para jogar (1-9)
     */
    public static boolean validacaoJogada(String[][] matrizJogoAtual, int num) {
        String[][] matrizAtual = matrizJogoAtual;
        int contador = 1;
        boolean valida = false;
        for (int i = 0; i < matrizAtual.length; i++) {
            for (int k = 0; k < matrizAtual[0].length; k++) {
                if (num == contador) {
                    if (matrizAtual[i][k].equals(String.valueOf(contador))) {
                        valida = true;
                    }
                    k = matrizAtual[0].length;
                    i = matrizAtual.length;
                } else
                    contador++;
            }
        }
        return valida;
    }

    /*
    Atualização do jogo com a jogada inseridade depois de validada
    atualizacaoJogo() necessita de 3 parametros,
    String[][] matrizJogoAtual = a matriz atual antes de ser atualizada
    int num = o numero da jogada de 1 a 9
    int jogador = o ID do jogador para identificar a letra do jogador
     */
    public static String[][] atualizacaoJogo(String[][] matrizJogoAtual, int num, int jogador) {
        String[][] matrizAtual = matrizJogoAtual;
        int contador = 1;
        for (int i = 0; i < matrizAtual.length; i++) {              // leitura da matriz dada
            for (int k = 0; k < matrizAtual[0].length; k++) {
                if (num == contador) {                              // caso seja a posiçao da jogada pretendida adiciona a letra a essa posiçao
                    if (jogador == 1) {
                        matrizAtual[i][k] = "X";                    // se for o jogador1 adiciona o X
                    } else if (jogador == 2)
                        matrizAtual[i][k] = "O";                    // se for o jogador2 adiciona o Y
                    k = matrizAtual[0].length;
                    i = matrizAtual.length;
                } else
                    contador++;
            }
        }
        return matrizAtual;
    }

    public static int verificacaoColunas(String[][] matrizJogoAtual, int jogador) { // 0 - ainda pode ganhar/ perder  1 - jogador ganhou, 2 - jogador nao pode ganhar nas colunas
        int ganhou = 0;
        String letraJogador = "";
        String letraAdversario = "";
        if (jogador == 1) {
            letraJogador = "X";
            letraAdversario = "O";
        } else {
            letraJogador = "O";
            letraAdversario = "X";
        }
        int contadorPerderColunas = 0;
        for (int i = 0; i < matrizJogoAtual[0].length; i++) {
            int contadorGanhar = 0, contadorPerder = 0;
            for (int k = 0; k < matrizJogoAtual.length; k++) {
                if (matrizJogoAtual[k][i].equals(letraJogador)) {
                    contadorGanhar++;
                } else if (matrizJogoAtual[k][i].equals(letraAdversario)) {
                    contadorPerder++;
                    k = matrizJogoAtual.length;
                }
            }
            if (contadorGanhar == 3) {
                return ganhou = 1;
            } else if (contadorPerder > 0)
                contadorPerderColunas++;
        }
        if (contadorPerderColunas == 3)
            return ganhou = 2;
        return ganhou;
    }

    public static int verificacaoLinhas(String[][] matrizJogoAtual, int jogador) { // 0 - ainda pode ganhar/ perder   1 - jogador ganhou, 2 - jogador nao pode ganhar nas linhas
        int ganhou = 0;
        String letraJogador = "";
        String letraAdversario = "";
        if (jogador == 1) {
            letraJogador = "X";
            letraAdversario = "O";
        } else {
            letraJogador = "O";
            letraAdversario = "X";
        }
        int contadorPerderColunas = 0;
        for (int i = 0; i < matrizJogoAtual.length; i++) {
            int contadorGanhar = 0, contadorPerder = 0;
            for (int k = 0; k < matrizJogoAtual[0].length; k++) {
                if (matrizJogoAtual[i][k].equals(letraJogador)) {
                    contadorGanhar++;
                } else if (matrizJogoAtual[i][k].equals(letraAdversario)) {
                    contadorPerder++;
                    k = matrizJogoAtual.length;
                }
            }
            if (contadorGanhar == 3) {
                return ganhou = 1;
            } else if (contadorPerder > 0)
                contadorPerderColunas++;
        }
        if (contadorPerderColunas == 3)
            return ganhou = 2;
        return ganhou;
    }

    public static int verificacaoDiagonais(String[][] matrizJogoAtual, int jogador) { // 0 - ainda pode ganhar/ perder   1 - jogador ganhou, 2 - jogador nao pode ganhar nas diagonais
        int ganhou = 0;

        String letraJogador = "";
        String letraAdversario = "";
        if (jogador == 1) {
            letraJogador = "X";
            letraAdversario = "O";
        } else {
            letraJogador = "O";
            letraAdversario = "X";
        }

        if (matrizJogoAtual[1][1].equals(letraAdversario)) {
            return ganhou = 2;
        } else {
            int contadorGanhar = 0;
            int contadorPerder = 0;
            for (int i = 0; i < matrizJogoAtual.length; i++) {
                if (matrizJogoAtual[i][i].equals(letraJogador)) {
                    contadorGanhar++;
                } else if (matrizJogoAtual[i][i].equals(letraAdversario)) {
                    contadorPerder++;
                    i = matrizJogoAtual.length;
                }
            }
            if (contadorGanhar == 3) {
                return ganhou = 1;
            }
            contadorGanhar = 0;
            for (int i = 0; i < matrizJogoAtual.length; i++) {
                for (int k = matrizJogoAtual.length - 1; k > 0; k--)
                    if (matrizJogoAtual[i][k].equals(letraJogador)) {
                        contadorGanhar++;
                    } else if (matrizJogoAtual[i][k].equals(letraAdversario)) {
                        contadorPerder++;
                        k = 0;
                        i = matrizJogoAtual.length;
                    }
            }
            if (contadorGanhar == 3) {
                return ganhou = 1;
            }
            if (contadorPerder > 1) {
                return ganhou = 2;
            }
        }
        return ganhou;
    }

    public static boolean verificacaoEmpate(String[][] matrizJogoAtual) {
        boolean jogoEmpatado = true;
        for (int i = 0; i < matrizJogoAtual.length; i++) {
            for (int k = 0; k < matrizJogoAtual[0].length; k++) {
                if (!matrizJogoAtual[i][k].equals("X") || !matrizJogoAtual[i][k].equals("O")) {
                    jogoEmpatado = false;
                    k = matrizJogoAtual[0].length;
                    i = matrizJogoAtual.length;
                }
            }
        }
        return jogoEmpatado;
    }

    /*
    jogoterminou() - metodo retorna um numero inteiro consoante o estado do jogo abaixo descrito
    0 = jogo nao terminou
    1 = jogador1 ganhou
    2 = jogador2 ganhou
    3 = empate
    4 = jogador 1 nao ganha (jogo continua mas jogador 1 já nao consegue ganhar)
    5 = jogador 2 nao ganha (jogo continua mas jogador 2 já nao consegue ganhar)
    necessita de 2 parametros : matriz do jogo com as jogadas todas ja feitas e o jogador que joga (id numero inteiro a identificar o jogador)
     */
    public static int jogoterminou(String[][] matrizJogoAtual, int jogador) {
        int checkGame = 0;

        if (jogador == 1) {
            // verficação das colunas
            int ganhouLinhas = verificacaoColunas(matrizJogoAtual, jogador);
            if (ganhouLinhas == 1)
                return checkGame = 1;
            // verficação das linhas
            int ganhouColunas = verificacaoLinhas(matrizJogoAtual, jogador);
            if (ganhouColunas == 1)
                return checkGame = 1;
            // verifaçao das diagonais
            int ganhouDiagonais = verificacaoDiagonais(matrizJogoAtual, jogador);
            if (ganhouDiagonais ==  1) {
                return checkGame = 1;
            }
            else if (ganhouLinhas == 2 && ganhouColunas == 2 && ganhouDiagonais == 2)
                return checkGame = 4;
        } else {
            // verficação das colunas
            int ganhouLinhas = verificacaoColunas(matrizJogoAtual, jogador);
            if (ganhouLinhas == 1)
                return checkGame = 2;
            // verficação das linhas
            int ganhouColunas = verificacaoLinhas(matrizJogoAtual, jogador);
            if (ganhouColunas == 1)
                return checkGame = 2;
            // verifaçao das diagonais
            int ganhouDiagonais = verificacaoDiagonais(matrizJogoAtual, jogador);
            if (ganhouDiagonais ==  1) {
                return checkGame = 2;
            }
            else if (ganhouLinhas == 2 && ganhouColunas == 2 && ganhouDiagonais == 2)
                return checkGame = 5;
        }
        if (verificacaoEmpate(matrizJogoAtual))
            return checkGame = 3;

        return checkGame;
    }

    public static void jogoApresentado(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[0].length; k++) {
                if (k == 2) {
                    System.out.print(" " + matriz[i][k]);
                } else {
                    System.out.print(" " + matriz[i][k] + " |");
                }
            }
            if (i != 2)
                System.out.println("\n------------");
        }
        System.out.println("\n");
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] matrizJogo = new String[3][3];
        matrizJogo = matrizOriginal();
        boolean jogoterminou = false, vezJogador = true;


        System.out.println("***** JOGO DA VELHA *****");
        System.out.println("\n");
        System.out.print("Jogador 1 (X) introduza um nick : ");
        String nickJogador1 = input.next() + input.nextLine();
        int jogador1id = 1;
        System.out.print("Jogador 2 (O) introduza um nick : ");
        String nickJogador2 = input.next() + input.nextLine();
        int jogador2id = 2;
        System.out.println("\n");
        jogoApresentado(matrizJogo);

        while (!jogoterminou) {
            int estadoJogo = 0;
            if (vezJogador)
            {
                int jogada = pedirJogada(input,nickJogador1,matrizJogo);
                matrizJogo = atualizacaoJogo(matrizJogo, jogada, jogador1id);
                estadoJogo = jogoterminou(matrizJogo, jogador1id);
                vezJogador = false;
            }
            else
            {
                int jogada = pedirJogada(input,nickJogador2,matrizJogo);
                matrizJogo = atualizacaoJogo(matrizJogo, jogada, jogador2id);
                estadoJogo = jogoterminou(matrizJogo, jogador2id);
                vezJogador = true;
            }
            switch (estadoJogo){
                case 0 : {
                    break;
                }
                case 1 : {
                    System.out.println("****** Jogador " + nickJogador1 + " Ganhou!!! ******");
                    jogoterminou = true;
                    break;
                }
                case 2 : {
                    System.out.println("****** Jogador " + nickJogador2 + " Ganhou!!! ******");
                    jogoterminou = true;
                    break;
                }
                case 3 :{
                    System.out.println("****** EMPATE ******");
                    jogoterminou = true;
                    break;
                }
                case 4 : {
                    System.out.println("****** Jogador " + nickJogador1 + " já nao consegue ganhar !!! ******");
                    break;
                }
                case 5 : {
                    System.out.println("****** Jogador " + nickJogador2 + " já nao consegue ganhar !!! ******");
                    break;
                }
            }
            System.out.println();
            jogoApresentado(matrizJogo);
        }

        System.out.println("<<<<< Fim de jogo >>>>>");

    }
}
