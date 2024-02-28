package ficha_04.Extra;

public class exercicio_02 {
    public static void main(String[] args) {

        System.out.println("<<<<< Programa de multiplos de 3 >>>>>");
        // Declarar variaveis
        int num;

        for (num = 1; num <= 255; ++num) // Enquanto o numero for menor ou igual a 255 continuar o codigo
        {
            if (num % 3 == 0) // Se for divisivel por 3 apresentar o numero
            {
                System.out.println(num);
            }
        }
        System.out.println("\n<<<<< Fim de programa >>>>>");
    }
}
