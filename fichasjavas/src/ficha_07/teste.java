package ficha_07;

import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;

public class teste {
    public static void main(String[] args) {
        int[] numeros = {5, 1, 2, 3, 4, 5, 17, 19};
        int[] divisores = {6, 0, 6 , 0, 9, 10};

        for (int i = 0; i < numeros.length; i++) {
            try {
                System.out.println("Divisão " + i);
                System.out.println("Divisao :" + numeros[i] / divisores[i]);

            } catch (ArithmeticException ex1) {
                System.out.println("Divisão impossivel!");
            }
            catch (IndexOutOfBoundsException ex2)
            {
                System.out.println("Elemento nao encontado!");
            }
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Divisão " + i);
            System.out.println("Divisao :" + numeros[i] / divisores[i]);
            System.out.println("Elemento nao encontado!");
        }

    }

}

class MinhaExcepcao extends Exception{
    MinhaExcepcao(String letra){
        try{
            String novaString = letra;
        }
        catch (StringIndexOutOfBoundsException ex2)
        {
            System.out.println("String invalida!");
        }
    }
}
