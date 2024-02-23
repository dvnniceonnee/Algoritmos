package ficha_02.ficha_extra;

import java.util.Scanner;

public class exercicio_05 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int numfinal = 49, numUtilizador, calculoEntre_numeros;

        // Ler o numero do utilizador
        System.out.println("Vamos brincar com bruxos!");
        System.out.print("Adivinhe o numero (1 a 100) : ");
        numUtilizador = input.nextInt();

        // Verificar se o numero está entre 0 e 100
        if (numUtilizador < 1 || numUtilizador > 100) {
            System.out.println("O numero introduzido não é valido!");
        } else {
            // Numero está entre e 0 e 100
            // Verificar se o numero é maior ou menor do que o numero final
            // Caso a subtração de um pelo outro = 0, termina o programa e o utilizador ganhou
            if (numUtilizador - numfinal == 0) {
                System.out.println("Boa! Ganhaste o jogo!");
            }
            else {
                // Caso o resultado nao seja 0 é necessario verificar se o numero do utilizador é maior do que o numero final
                // Caso seja maior esta alto
                // Caso seja menor está baixo
                if (numUtilizador > numfinal) {
                    numUtilizador =  numUtilizador - numfinal;
                    if (numUtilizador > 10) {
                        System.out.println("Muito alto e frio!");
                        System.out.println("Adivinhe novamente o numero : ");
                        numUtilizador = input.nextInt();
                        if ((numUtilizador - numfinal) == 0) {
                            // Utilizador acertou no numero pois a subtração do numero to utilizador pelo numero do jogo é "0"
                            System.out.println("Boa! Ganhaste o jogo!");
                        }
                        else {
                            // Utilizador nao acertou pois a subtraçao nao resultava "0"
                            // E vai ficar sem tentativas
                            numUtilizador =  numUtilizador - numfinal;
                            if (numUtilizador > 0) {
                                if (numUtilizador > 10) {
                                    System.out.println("Muito alto e frio!");
                                    System.out.println("Ficaste sem tentativas... ");
                                } else {
                                    System.out.println("Multo alto mas perto!");
                                    System.out.println("Ficaste sem tentativas... ");
                                }
                            }
                            else {
                                if (numUtilizador < -10) {
                                    System.out.println("Muito Baixo e frio!");
                                    System.out.println("Ficaste sem tentativas... ");
                                } else {
                                    System.out.println("Muito baixo mas perto!");
                                    System.out.println("Ficaste sem tentativas... ");
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("Muito alto mas perto!");
                        System.out.println("Adivinhe novamente o numero : ");
                        numUtilizador = input.nextInt();
                        if ((numUtilizador - numfinal) == 0) {
                            System.out.println("Boa! Ganhaste o jogo!");
                        }
                        else {
                            numUtilizador =  numUtilizador - numfinal;
                            if (numUtilizador > 0) {
                                if (numUtilizador > 10) {
                                    System.out.println("Muito alto e frio!");
                                    System.out.println("Ficaste sem tentativas... ");
                                } else {
                                    System.out.println("Multo alto mas perto!");
                                    System.out.println("Ficaste sem tentativas... ");
                                }
                            }
                            else {
                                if (numUtilizador < -10) {
                                    System.out.println("Muito Baixo e frio!");
                                    System.out.println("Ficaste sem tentativas... ");
                                } else {
                                    System.out.println("Muito baixo mas perto!");
                                    System.out.println("Ficaste sem tentativas... ");
                                }
                            }
                        }
                    }
                } else {
                    numUtilizador =  numUtilizador - numfinal;
                    if (numUtilizador < -10) {
                        System.out.println("Muito Baixo e frio!");
                        System.out.println("Adivinhe novamente o numero : ");
                        numUtilizador = input.nextInt();
                        if ((numUtilizador - numfinal) == 0) {
                            System.out.println("Boa! Ganhaste o jogo!");
                        }
                        else {
                            numUtilizador =  numUtilizador - numfinal;
                            if (numUtilizador > 0) {
                                if (numUtilizador > 10) {
                                    System.out.println("Muito alto e frio!");
                                    System.out.println("Ficaste sem tentativas... ");
                                } else {
                                    System.out.println("Multo alto mas perto!");
                                    System.out.println("Ficaste sem tentativas... ");
                                }
                            }
                            else {
                                if (numUtilizador < -10) {
                                    System.out.println("Muito Baixo e frio!");
                                    System.out.println("Ficaste sem tentativas... ");
                                } else {
                                    System.out.println("Muito baixo mas perto!");
                                    System.out.println("Ficaste sem tentativas... ");
                                }
                            }
                        }
                    } else {
                        System.out.println("Muito baixo mas perto!");
                        System.out.println("Adivinhe novamente o numero : ");
                        numUtilizador = input.nextInt();
                        if ((numUtilizador - numfinal) == 0) {
                            System.out.println("Boa! Ganhaste o jogo!");
                        }
                        else {
                            numUtilizador =  numUtilizador - numfinal;
                            if (numUtilizador > 0) {
                                if (numUtilizador > 10) {
                                    System.out.println("Muito alto e frio!");
                                    System.out.println("Ficaste sem tentativas... ");
                                } else {
                                    System.out.println("Multo alto mas perto!");
                                    System.out.println("Ficaste sem tentativas... ");
                                }
                            }
                            else {
                                if (numUtilizador < -10) {
                                    System.out.println("Muito Baixo e frio!");
                                    System.out.println("Ficaste sem tentativas... ");
                                } else {
                                    System.out.println("Muito baixo mas perto!");
                                    System.out.println("Ficaste sem tentativas... ");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
