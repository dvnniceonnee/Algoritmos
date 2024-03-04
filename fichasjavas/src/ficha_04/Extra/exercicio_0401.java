package ficha_04.Extra;

public class exercicio_0401 {
    public static void main(String[] args) {

        // Declarar variaveis
        int numero, numeroAsteriscos;
        System.out.println("<<<<<<< Desenhos >>>>>>\n");

        for (numero = 1; numero <= 4; numero++)
        {
            numeroAsteriscos = 10;
            while (numeroAsteriscos > 0)
            {
                System.out.print("*");
                --numeroAsteriscos;
            }
            System.out.println();
        }
    }
}
