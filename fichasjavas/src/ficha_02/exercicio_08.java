package ficha_02;

import java.util.Scanner;

public class exercicio_08 {
    public static void main(String[] args) {

        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        double notaAluno1, notaAluno2, notaAluno3, mediaPond;

        // Ler as 3 notas do aluno
        System.out.println("Vamos ver se és um bom aluno");
        System.out.println("Introduz as 3 notas do aluno : ");
        notaAluno1 = input.nextDouble();
        notaAluno2 = input.nextDouble();
        notaAluno3 = input.nextDouble();

        // Verificar se a nota é valida
        if (notaAluno1 < 0 || notaAluno1 > 20 || notaAluno2 < 0 || notaAluno2 > 20 || notaAluno3 < 0 || notaAluno3 > 20)
        {
            System.out.println("As notas nao sao validas");
        }
        else
        {
            // calcular a media ponderada
            mediaPond = (notaAluno1 * 0.25) + (notaAluno2 * 0.35) + (notaAluno3 * 0.4);

            if (mediaPond > 9.5) // Media maior do que 9.5 = Aprovado
                System.out.println("O aluno teve uma media de " + mediaPond + " e esta aprovado !");
            else // Media menor do que 9.5 = Reprovado
                System.out.println("O aluno teve uma media de " + mediaPond + " e esta reprovado!");
        }
    }
}
