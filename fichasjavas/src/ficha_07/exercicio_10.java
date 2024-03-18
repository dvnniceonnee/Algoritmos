package ficha_07;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ficha_07.BibliotecaFiles.*;

public class exercicio_10 {
    public static String menuPrincipal() {
        String menuMain = "***** Menu Principal *****\n" +
                "\n1. Pesquisar \n" +
                "2. Criar Formando\n" +
                "3. Editar Formando\n" +
                "4. Eliminar Formando\n" +
                "5. Guardar Dados no ficheiro\n" +
                "6. Sair\n";
        return menuMain;
    }

    public static String menuPesquisas() {
        String menuSearch = "a. Imprimir todos os formandos\n" +
                "b. Pesquisar formando por matricula\n" +
                "c. Pesquisar formandos e total de formandos por curso\n" +
                "d. Pesquisar o formando mais velho\n" +
                "e. Pesquisar formandos incritos em mais do que um curso\n" +
                "f. Pesquisar o total de formandos\n" +
                "g. Voltar ao Menu anterior\n";
        return menuSearch;
    }

    /**
     * Função que imprime as informações de um especifo formando
     *
     * @param matriz    Recebe uma matriz com os dados todos do ficheiro
     * @param matricula Recebe uma matricula para pesquisar o formandd
     * @return booelano a referir se existe a matricula ou nao (true = existe; false = nao existe)
     */
    public static boolean informacoesFormando(String[][] matriz, String matricula) {
        String[][] formando = new String[0][0];
        int contadorLinhas = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][1].equals(matricula)) {
                if (contadorLinhas == 0) {
                    String[][] temp = new String[contadorLinhas + 1][matriz[0].length];
                    for (int k = 0; k < matriz[0].length; k++) {
                        temp[contadorLinhas][k] = matriz[i][k];
                    }
                    contadorLinhas++;
                    formando = temp;
                } else {
                    String[][] temp = new String[contadorLinhas + 1][matriz[0].length];
                    for (int k = 0; k < formando.length; k++) {
                        for (int j = 0; j < formando[0].length; j++) {
                            temp[k][j] = formando[k][j];
                        }
                        temp[formando.length][formando[0].length] = matriz[i][2];
                    }
                    contadorLinhas++;
                    formando = temp;
                }
            }
        }
        if (contadorLinhas > 0) {
            String nome = formando[0][0];
            String idMatricula = formando[0][1];
            String cursos = formando[0][2];
            String email = formando[0][3];
            String idade = formando[0][4];
            if (contadorLinhas > 1) {
                for (int i = 1; i < formando.length; i++)
                    cursos += "\t|\t" + formando[i][2];
            }
            System.out.println("Nome : " + nome);
            System.out.println("Matricula : " + idMatricula);
            System.out.println("Curso(s) : " + cursos);
            System.out.println("Email : " + email);
            System.out.println("Idade : " + idade);
            return true;
        } else {
            System.out.println("\n !! Matricula Invalida! Nenhum formando encontrado !!");
            return false;
        }
    }

    /**
     * Recebe uma matriz e imprime os dados filtrados por um curso
     *
     * @param matriz        Recebe uma matriz com os dados gerais de todos os formandos
     * @param cursoPesquisa Recebe uma String com o nome do curso a filtrar
     */
    public static void formandosCurso(String[][] matriz, String cursoPesquisa) {
        String[][] formandosDoCurso = new String[0][2];
        int contadorFormandos = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][2].equals(cursoPesquisa)) {
                if (contadorFormandos == 0) {
                    String[][] temp = new String[formandosDoCurso.length + 1][2];
                    temp[0][0] = matriz[i][0];
                    temp[0][1] = matriz[i][1];
                    formandosDoCurso = temp;
                    contadorFormandos++;
                } else {
                    String[][] temp = new String[formandosDoCurso.length + 1][2];
                    for (int k = 0; k < formandosDoCurso.length; k++) {
                        for (int e = 0; e < formandosDoCurso[0].length; e++) {
                            temp[k][e] = formandosDoCurso[k][e];
                        }
                    }
                    temp[formandosDoCurso.length][0] = matriz[i][0];
                    temp[formandosDoCurso.length][1] = matriz[i][1];
                    formandosDoCurso = temp;
                    contadorFormandos++;
                }
            }
        }
        if (contadorFormandos > 0) {
            System.out.println();
            for (int i = 0; i < formandosDoCurso.length; i++) {
                System.out.println("Nome : " + formandosDoCurso[i][0] + "\t Matricula : " + formandosDoCurso[i][1]);

            }
            System.out.println("\nExistem " + formandosDoCurso.length + " alunos no curso de " + cursoPesquisa + "\n");
        }
    }

    /**
     * Funçáo que imprime o formando mais velho dando uma matriz de dados de formandos
     *
     * @param dados Recebe uma matriz com os dados todos dos formandos
     */
    public static void formandoVelho(String[][] dados) {
        int idadeMaior = 0;
        int indexFormandoVelho = 1;
        for (int i = 1; i < matrizDados.length; i++) {
            int idadeFormando = Integer.parseInt(matrizDados[i][4]);
            if (idadeFormando > idadeMaior) {
                idadeMaior = idadeFormando;
                indexFormandoVelho = i;
            }
        }
        System.out.println("\nO formando mais velho é " + matrizDados[indexFormandoVelho][0] + " com a idade de " + idadeMaior);
    }

    /**
     * Imprime os formandos que se encontram em mais de um curso
     *
     * @param dados Recebe uma matriz com todas as informaçoes de todos os formandos
     */
    public static void formandosEmMaisDeUmCurso(String[][] dados) {
        String[][] formandos = new String[0][0];
        int contadorFormandos = 0;
        for (int i = 1; i < dados.length; i++) {
            for (int k = i + 1; k < dados.length; k++) {
                if (dados[i][0].equals(dados[k][0])) {
                    if (contadorFormandos == 0) {
                        String[][] temp = new String[formandos.length + 1][2];
                        temp[0][0] = dados[i][0];
                        temp[0][1] = dados[i][1];
                        formandos = temp;
                        contadorFormandos++;
                    } else {
                        boolean repetido = false;
                        for (int h = 0; h < formandos.length; h++) {
                            if (formandos[h][1].equals(dados[i][1]))
                                repetido = true;
                        }
                        if (!repetido) {
                            String[][] temp = new String[formandos.length + 1][2];
                            for (int h = 0; h < formandos.length; h++) {
                                temp[h][0] = formandos[h][0];
                                temp[h][1] = formandos[h][1];
                            }
                            temp[formandos.length][0] = dados[i][0];
                            temp[formandos.length][1] = dados[i][1];
                            formandos = temp;
                            contadorFormandos++;
                        }
                    }
                }
            }
        }
        if (contadorFormandos > 0) {
            for (int i = 0; i < formandos.length; i++) {
                System.out.println("Nome : " + formandos[i][0] + "| Matricula : " + formandos[i][1]);
            }
            System.out.println("\nExistem " + contadorFormandos + " formandos em mais de 1 curso! :)\n");

        } else {
            System.out.println("\nNao existem alunos incritos em mais de um curso!");
        }
    }

    /**
     * Função que desempenha um switch para a opção de escolha no menu de pesquisa
     *
     * @param opcaoEscolhida recebe a opcao em String (a,b,c,d,e,f) e retorna o pretendido pela escolha
     */
    public static void opcaoPesquisa(String opcaoEscolhida) {
        Scanner input = new Scanner(System.in);
        switch (opcaoEscolhida) {
            case "a":
                ImprimirDados(matrizDados, true);
                break;
            case "b":
                System.out.print("Insira o numero da matricula : ");
                String matricula = input.next() + input.nextLine();
                informacoesFormando(matrizDados, matricula);
                break;
            case "c":
                String[] cursos = listaDadosColuna(matrizDados, 2);
                int i = 0;
                for (i = 1; i < cursos.length; i++) {
                    System.out.println((i) + ". " + cursos[i]);
                }
                System.out.print("\nEscolha o curso a pesquisar : ");
                try {
                    i = input.nextInt();
                    formandosCurso(matrizDados, cursos[i]);

                } catch (InputMismatchException ex1) {
                    System.out.println("Curso inválido!");
                }
                break;
            case "d":
                formandoVelho(matrizDados);
                break;
            case "e":
                formandosEmMaisDeUmCurso(matrizDados);
                break;
            case "f":
                String[] alunos = listaDadosColuna(matrizDados, 0);
                System.out.println("\nExistem " + (matrizDados.length - 1) + " formandos incritos!");
                System.out.println("Existem " + (alunos.length - 1) + " formandos sem repetiçoes!\n");
                break;
            case "g":
                break;
            default:
                System.out.println("\nOpção inválida!\n");
        }
    }

    /**
     * Função que adiciona uma linha nova à matriz atual e posteriormente adiciona ao ficheiro caso o utilizar o desejar
     *
     * @param dados matriz que ainda nao tem a linha do novo formando adicionada
     * @throws FileNotFoundException caso nao exista ficheiro a função lança uma exceção
     */
    public static void criarFormando(String[][] dados) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("\nIndique o nome do formando que deseja criar : ");
        String nome = input.next() + input.nextLine();
        System.out.print("\nIndique qual o curso que ele está a frequentar : ");
        String curso = input.nextLine();
        System.out.print("\nIndique o email do " + nome + " :");
        String email = input.nextLine();
        boolean idadeValida = false;
        String idade = "";
        do {
            System.out.print("\nIndique qual a idade do " + nome + " : ");
            idade = input.nextLine();
            try {
                Integer.parseInt(idade);
                idadeValida = true;
            } catch (Exception ex1) {
                System.out.println(ex1.getMessage() + " " + ex1.getCause() + " " + ex1.getLocalizedMessage());
            }
        } while ((!idadeValida));

        String[][] matrizTemp = new String[dados.length + 1][dados[0].length];
        for (int i = 0; i < dados.length; i++) {
            for (int k = 0; k < dados[0].length; k++) {
                matrizTemp[i][k] = dados[i][k];
            }
        }
        matrizTemp[dados.length][0] = nome;
        matrizTemp[dados.length][1] = String.valueOf(Integer.parseInt(dados[dados.length - 1][1]) + 1);
        matrizTemp[dados.length][2] = curso;
        matrizTemp[dados.length][3] = email;
        matrizTemp[dados.length][4] = idade;
        System.out.println(nome + "\n" + curso + "\n" + email + "\n" + idade);
        matrizDados = matrizTemp;
        /*
        PrintWriter writer = new PrintWriter(ficheiro);
        for (int i = 0; i < dados.length; i++) {
            writer.println(dados[i][0] + "," + dados[i][1] + "," + dados[i][2] + "," + dados[i][3] + "," + dados[i][4]);
        }
        writer.println(nome + "," + (Integer.parseInt(dados[dados.length - 1][1]) + 1) + "," + curso + "," + email + "," + idade);
        writer.close();*/
    }

    /**
     * Função que permite editar os dados de um especifico formando na matriz principal o que posteriormente pode ser guardado no ficheiro
     * @param dados recebe uma matriz com os dados todos dos formandos para editar um especifico
     * @param teclado recebe um scanner
     * @throws FileNotFoundException
     */
    public static void editarFormando(String[][] dados, Scanner teclado) throws FileNotFoundException {
        Scanner input1 = teclado;
        System.out.print("Introduza a matricula do formando para editar : ");
        String matricula = input1.next() + input1.nextLine();
        boolean matriculaExiste = informacoesFormando(matrizDados, matricula);
        if (matriculaExiste) {
            int opcao = 0;
            do {
                System.out.println("\n1. Nome\n2. Email \n3. Idade \n4. Sair");
                System.out.print("\nIntroduza o que deseja editar :  ");
                try {
                    opcao = input1.nextInt();
                } catch (InputMismatchException ex1) {
                    input1.next();
                }
                String nome = "", email = "", idade = "";
                switch (opcao) {
                    case 1:
                        System.out.print("\nIntroduza o novo nome : ");
                        nome = input1.next() + input1.nextLine();
                        break;
                    case 2:
                        System.out.print("\nIntroduza o novo email : ");
                        email = input1.next() + input1.nextLine();
                        break;
                    case 3:
                        System.out.print("\nIntroduza a nova idade : ");
                        boolean idadeValida = false;
                        do {
                            try {
                                idade = input1.next() + input1.nextLine();
                                Integer.parseInt(idade);
                                idadeValida = true;
                            } catch (Exception ex1) {
                                System.out.println("Idade invalida!");
                            }
                        } while (!idadeValida);
                    case 4:
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                }
                for (int i = 0; i < dados.length; i++) {
                    if (dados[i][1].equals(matricula)) {
                        switch (opcao) {
                            case 1:
                                dados[i][0] = nome;
                                break;
                            case 2:
                                dados[i][3] = nome;
                                break;
                            case 3:
                                dados[i][4] = idade;
                                break;
                        }
                    }
                }
            } while (opcao != 4);
        }
    }

    /**
     * Função que permite remover um formando dando uma especifica matricula
     * @param dados matriz de dados
     * @param matricula String com a matricula do formando a ser apagada
     * @return booleano verdadeiro caso o formando exista e tenha sido apagado
     */
    public static boolean deleteFormando(String[][] dados, String matricula){
        String[][] newData = new String[0][0];
        boolean deleted = false;
        for (int i = 0; i < dados.length; i++){
            if (!dados[i][1].equals(matricula)){
                if (newData.length == 0){
                    String[][] temp =  new String[newData.length + 1][5];
                    for (int k = 0; k < dados[0].length; k++){
                        temp[newData.length][k] = dados[i][k];
                    }
                    newData = temp;
                }
                else {
                    String[][] temp =  new String[newData.length + 1][5];
                    for (int j = 0; j < newData.length; j++){
                        for (int y = 0; y < newData[0].length; y++){
                            temp[j][y] = newData[j][y];
                        }
                    }
                    for (int k = 0; k < dados[0].length; k++){
                        temp[newData.length][k] = dados[i][k];
                    }
                    newData = temp;
                }
            }
            else {
                deleted = true;
            }
        }
        matrizDados = newData;
        return deleted;
    }

    /**
     * Função que edita o ficheiro com os dados todos atuais da matriz dada
     * @param ficheiro onde vai ser guardados os dados
     * @throws FileNotFoundException
     */
    public static void saveDataFile(File ficheiro) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(ficheiro);
        for (int i = 0; i < matrizDados.length; i++) {
            writer.println(matrizDados[i][0] + "," + matrizDados[i][1] + "," + matrizDados[i][2] + "," + matrizDados[i][3] + "," + matrizDados[i][4]);
        }
        writer.close();
    }

    public static String[][] matrizDados;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        File ficheiro = new File("fichasjavas/files/ficha_07/exercicio_10.csv");
        boolean fileValido = true;
        int[] quantidadeLinesCol = new int[0];
        try {
            quantidadeLinesCol = numeroLinhasColunas(ficheiro, ",");
        } catch (FileNotFoundException ex1) {
            System.out.println("Ficheiro Inválido!");
            fileValido = false;
        }
        if (fileValido) {
            int opcao = 0;
            matrizDados = matrizDados(ficheiro, quantidadeLinesCol[0], quantidadeLinesCol[1], false,",");
            do {
                System.out.println(menuPrincipal());
                System.out.print("Introduza a opção desejada : ");
                try {
                    opcao = input.nextInt();
                } catch (InputMismatchException ex1) {
                    input.next();
                    opcao = 0;
                }
                switch (opcao) {
                    case 1:
                        String opcaoMenu1 = "";
                        do {
                            System.out.println(menuPesquisas());
                            System.out.print("Escolha o que pretende efetuar : ");
                            opcaoMenu1 = input.next().toLowerCase();
                            opcaoPesquisa(opcaoMenu1);
                        }
                        while (!opcaoMenu1.equals("g"));
                        break;
                    case 2:
                        criarFormando(matrizDados);
                        break;
                    case 3:
                        editarFormando(matrizDados, input);
                        break;
                    case 4:
                        System.out.print("Introduza a matricula que deseja eliminar : ");
                        String matriculaFormando = input.next() + input.nextLine();
                        try{
                            Integer.parseInt(matriculaFormando);
                            boolean formandoDeleted = deleteFormando(matrizDados, matriculaFormando);
                            if (formandoDeleted){
                                System.out.println("\nFormando com a matricula " + matriculaFormando + " foi apagada!");
                            }
                            else
                                System.out.println("\nMatricula não encontrada! Formando nao existente!");
                        }
                        catch (Exception ex1){
                            System.out.println("Matricula invalida!");
                        }
                        break;
                    case 5 :
                        saveDataFile(ficheiro);
                        System.out.println("## Ficheiro atualizado ##");
                        break;
                    case 6:
                        System.out.println("Deseja guardar os dados no ficheiro (s/n) ? ");
                        String saveFile = input.next();
                        if (saveFile.equalsIgnoreCase("s")) {
                            saveDataFile(ficheiro);
                        }
                        break;
                    default:
                        System.out.println("Opção Invalida!");
                }
            } while (opcao != 6);
        }
    }


}
