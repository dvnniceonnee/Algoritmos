package ficha_04.Extra;

public class exercicio_0402 {
    public static void main(String[] args) {
        // declarar variaveis
        int numero = 1, contagem;
        String asterisco = "*";

        while (numero <= 5)
        {
            for (contagem = numero; contagem > 0; --contagem)
            {
                System.out.print(asterisco);
            }
            System.out.println();
            ++numero;
        }
    }
}
