package ficha_02;

import java.util.Scanner;

public class exercicio_13 {
    public static void main(String[] args) {
        // Importar o scanner
        Scanner input = new Scanner(System.in);

        // Declarar Variaveis
        int horaUtilizador, minUtilizador;

        //Ler Variaveis
        System.out.println("Introduza as horas e os minutos atuais respetivamente");
        horaUtilizador = input.nextInt();
        minUtilizador = input.nextInt();

        // Verificar se as horas sao validas e Transformar em sistema de 12 horas
        if (horaUtilizador > 24 || horaUtilizador == 24 && minUtilizador > 0 || horaUtilizador < 0 || minUtilizador < 0)
        {
            System.out.println("Horas introduzidas invalidas");
        }
        else
        {
            if (horaUtilizador >= 12)
            {
                if (horaUtilizador == 12)
                {
                    if (minUtilizador > 9)
                    {
                        System.out.println("As horas atuais sao : " + horaUtilizador + ":" + minUtilizador + " PM");
                    }
                    else {
                        System.out.println("As horas atuais sao : " + horaUtilizador + ":0" + minUtilizador + " PM" );
                    }
                }
                else
                {
                    if (minUtilizador > 9)
                    {
                        horaUtilizador =  horaUtilizador - 12;
                        System.out.println("As horas atuais sao : " + horaUtilizador + ":" + minUtilizador + " PM");
                    }
                    else {
                        horaUtilizador = horaUtilizador - 12;
                        System.out.println("As horas atuais sao : "+ "0" + horaUtilizador + ":0" + minUtilizador );
                    }
                }
            }
            else
            {
                if (horaUtilizador <= 9)
                {
                    System.out.println("As horas atuais sao : " + horaUtilizador + ":" +  minUtilizador + " AM");
                }
                else
                {
                    System.out.println("As horas atuais sao : " + horaUtilizador + ":" + minUtilizador + " AM");
                }

            }
        }


    }
}
