package extraFuncoes;

import java.util.Scanner;

public class exercicio_10 {

    public static String[] listaFormas() {
        String[] formas = new String[5];
        formas[0] = "Quadrangular";
        formas[1] = "Retangular";
        formas[2] = "Circular";
        formas[3] = "Triangular";
        formas[4] = "Losangular";

        return formas;
    }

    public static String[] listaTipologias() {
        String[] formas = new String[3];
        formas[0] = "URBANO";
        formas[1] = "URBANIZAVEL";
        formas[2] = "RUSTICOS";
        return formas;
    }

    public static int menuFormas(Scanner teclado) {
        int escolhaUtilizador = 0;
        System.out.println("*** Escolha a forma do seu terreno ***");
        do {
            for (int i = 0; i < listaFormas().length; i++)
                System.out.println((i + 1) + ". " + listaFormas()[i]);
            System.out.println();
            System.out.print("Qual é a forma do seu terreno : ");
            escolhaUtilizador = teclado.nextInt();
            if (escolhaUtilizador < 1 || escolhaUtilizador > 5) {
                System.out.println("\nOpção Invalida!\n");
                escolhaUtilizador = 0;
            }
        } while (escolhaUtilizador == 0);
        return escolhaUtilizador;
    }

    public static int menuTipologias(Scanner teclado) {

        int tipologiaTerreno = 0;
        System.out.println("*** Escolha a tipologia do seu terreno ***\n");
        while (tipologiaTerreno < 1 || tipologiaTerreno > 3) {
            for (int i = 0; i < listaTipologias().length; i++)
                System.out.println((i + 1) + ". " + listaTipologias()[i]);
            System.out.print("\n Qual é a tipologia do seu terreno (1-3) : ");
            tipologiaTerreno = teclado.nextInt();
            if (tipologiaTerreno < 1 || tipologiaTerreno > 3)
                System.out.println("\nTipologia inválida!");
        }
        return tipologiaTerreno;
    }

    public static double areaForma(int opcaoForma, Scanner teclado) {
        double pi = 3.1415;
        double areaM2 = 0;
        while (areaM2 <= 0) {
            switch (opcaoForma) {
                case 1:
                    System.out.print("Qual é o comprimento de um dos lados do seu terreno quadrangular? : ");
                    double lado = teclado.nextDouble();
                    areaM2 = lado * lado;
                    break;
                case 2:
                    System.out.print("Qual é o comprimento do seu terreno retangular? : ");
                    double compRetangulo = teclado.nextDouble();
                    System.out.print("Qual é a largura do seu terreno retangular? : ");
                    double larg = teclado.nextDouble();
                    areaM2 = compRetangulo * larg;
                    break;
                case 3:
                    System.out.print("Qual é o raio do seu terreno circular? : ");
                    double raio = teclado.nextDouble();
                    areaM2 = pi * (raio * raio);
                    break;
                case 4:
                    System.out.print("Qual é o comprimento da base do seu terreno triangular? : ");
                    double compTriangulo = teclado.nextDouble();
                    System.out.print("Qual é a altura do seu terreno triangular? : ");
                    double alturaTriangulo = teclado.nextDouble();
                    areaM2 = (compTriangulo * alturaTriangulo) / 2;
                    break;
                case 5:
                    System.out.print("Qual é o comprimento de uma das diagonais do seu terreno losangular? : ");
                    double diag1 = teclado.nextDouble();
                    System.out.println("Qual é o comprimento da outra diagonal do seu terreno losangular? : ");
                    double diag2 = teclado.nextDouble();
                    areaM2 = (diag1 * diag2) / 2;
                    break;
            }
            if (areaM2 <= 0) {
                System.out.println("Medidas introduzidas inválidas!");
            }
        }
        return areaM2;
    }

    public static double precoTerreno(Scanner teclado) {
        double preco = 0;
        System.out.print("Qual seria o preço do seu terreno ? :");
        preco = teclado.nextDouble();
        while (preco <= 0) {
            System.out.println("***** Preço invalido! *****\n");
            System.out.print("Qual seria o preço do seu terreno ? :");
            preco = teclado.nextDouble();
        }
        return preco;
    }

    public static void apresentacaoterreno(int escolha, double area, double preco, int tipologia) {
        System.out.println("Forma do terreno : " + listaFormas()[escolha - 1]);
        System.out.println("Area do terreno : " + area + " m2");
        System.out.println("Preço do terreno : " + preco + "€");
        System.out.println("Tipologia do terreno : " + listaTipologias()[tipologia - 1] + "\n");
        double precoM2 = preco/area;
        apresentacaoPrecoMercado(tipologia, precoM2);
    }

    public static void apresentacaoPrecoMercado(int tipologia, double precoM2) {
        switch (tipologia) {
            case 1:
                if (precoM2 >= 450 && precoM2 <= 750) {
                    System.out.println("O seu terreno está dentro dos valores de mercado da tipolodia "
                            + listaTipologias()[tipologia - 1] + " entre os 450€/m2 e 750€/m2");
                } else {
                    if (precoM2 < 450) {
                        double precoExcede = 450 - precoM2;
                        System.out.println("O seu terreno está fora dos valores de mercado, com um valor de "
                                + precoExcede + " abaixo do mercado na tipologia " + listaTipologias()[tipologia - 1] +
                                " entre os 450€/m2 e 750€/m2");
                    } else {
                        double precoExcede = precoM2 - 750;
                        System.out.println("O seu terreno está fora dos valores de mercado, com um valor de "
                                + precoExcede + " acima do mercado na tipologia " + listaTipologias()[tipologia - 1] +
                                " entre os 450€/m2 e 750€/m2");
                    }
                }
                break;
            case 2:
                if (precoM2 >= 150 && precoM2 <= 500) {
                    System.out.println("O seu terreno está dentro dos valores de mercado da tipolodia "
                            + listaTipologias()[tipologia - 1] + " entre os 150€/m2 e 500€/m2");
                } else {
                    if (precoM2 < 150) {
                        double precoExcede = 150 - precoM2;
                        System.out.println("O seu terreno está fora dos valores de mercado, com um valor de "
                                + precoExcede + " abaixo do mercado na tipologia " + listaTipologias()[tipologia - 1] +
                                " entre os 150€/m2 e 500€/m2");
                    } else {
                        double precoExcede = precoM2 - 500;
                        System.out.println("O seu terreno está fora dos valores de mercado, com um valor de "
                                + precoExcede + " acima do mercado na tipologia " + listaTipologias()[tipologia - 1] +
                                " entre os 150€/m2 e 500€/m2");
                    }
                }
                break;
            case 3:
                if (precoM2 >= 30 && precoM2 <= 60) {
                    System.out.println("O seu terreno está dentro dos valores de mercado da tipolodia "
                            + listaTipologias()[tipologia - 1] + " entre os 30€/m2 e 60€/m2");
                } else {
                    if (precoM2 < 150) {
                        double precoExcede = 30 - precoM2;
                        System.out.println("O seu terreno está fora dos valores de mercado, com um valor de "
                                + precoExcede + " abaixo do mercado na tipologia " + listaTipologias()[tipologia - 1] +
                                " entre os 30€/m2 e 60€/m2");
                    } else {
                        double precoExcede = precoM2 - 60;
                        System.out.println("O seu terreno está fora dos valores de mercado, com um valor de "
                                + precoExcede + " acima do mercado na tipologia " + listaTipologias()[tipologia - 1] +
                                " entre os 30€/m2 e 60€/m2");
                    }
                }
                break;
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programa de terrenos >>>>>\n");
        double[] Terreno = new double[4];                         // array com 4 posiçoes onde são : 0 = forma -- 1 = area -- 2 = preço -- 3 = tipologia
        int formaEscolha = 0;
        int tipologia = 0;

        formaEscolha = menuFormas(input);                   // chamar a função menuForms para verificar qual a forma do terreno do utilizar

        Terreno[0] = formaEscolha;                          // armazenamento da escolha para caso se no futuro for preciso

        Terreno[1] = areaForma(formaEscolha, input);        // a aera é atribuida atravês de uma função areaForma

        Terreno[2] = precoTerreno(input);                   // o preço é perdido atravês de uma função

        tipologia = menuTipologias(input);                  // a tipologia é pedido atravês de uma função

        Terreno[3] = tipologia;

        apresentacaoterreno(formaEscolha, Terreno[1],Terreno[2],tipologia );  // Impressao de todas as informações anteriormente ditas

    }
}
