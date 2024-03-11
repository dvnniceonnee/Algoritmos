package extraFuncoes;

import java.util.Scanner;

public class exercicio_05 {
    public static String piadaRandom(int num)
    {
        String[] piadas = new String[20];
        piadas[0] = "Como deixar alguem curioso? Eu conto amanha";
        piadas[1] = "Porque os fantasmas são pessimos para contar mentiras? Porque são transparentes!";
        piadas[2] = "Eu perdi peso no mês passado. Mas este mês já me encontrou de novo :)";
        piadas[3] = "Sabe qual é a melhor forma de consumir o tempo? Comer relógios!";
        piadas[4] = "- Dói, né?\n" +
                "- O quê?\n" +
                "- Deitar no sofá e lembrar que esqueceu o controle.";
        piadas[5] = "Você sabe por que a água foi presa?\n" +
                "\n" +
                "- Porque ela matou a sede.";
        piadas[6] = "Qual a cidade brasileira que não tem táxi?\n" +
                "\n" +
                "Uberlândia.";
        piadas[7] = "Fui no café e perguntei se o salgado era de hoje.\n" +
                "– Não, é de ontem.\n" +
                "– E como faço pra comer o de hoje?\n" +
                "– Volte amanhã!";
        piadas[8] = "Qual a fórmula da água benta?\n" +
                "\n" +
                "H Deus O.";
        piadas[9] = "Qual o contrário de papelada?\n" +
                "\n" +
                "Pá vestida.";
        piadas[10] = "Contei uma piada química... não teve reação.";
        piadas[11] = "O que o tijolo falou para o outro?\n" +
                "\n" +
                "Há um ciumento entre nós.";
        piadas[12] = "O que o cadarço falou para o tênis?\n" +
                "\n" +
                "Eu me amarro em você.";
        piadas[13] = "Por que o jacaré tirou o filho da escola?\n" +
                "\n" +
                "Porque ele réptil de ano.";
        piadas[14] = "Como o Batman conheceu o Robin?\n" +
                "\n" +
                "Pelo bat-papo.";
        piadas[15] = "Você sabe quem é o rei dos queijos?\n" +
                "\n" +
                "É o reiqueijão.";
        piadas[16] = "Por que o porco está sempre feliz?\n" +
                "\n" +
                "Porque está de bacon a vida.";
        piadas[17] = "Qual a diferença entre o gato e coca-cola?\n" +
                "\n" +
                "O gato mia e a coca light.";
        piadas[18] = "Qual é o cúmulo da solidão?\n" +
                "\n" +
                "Morar sozinho e fugir de casa.";
        piadas[19] = "Qual é o alimento mais sagrado que existe?\n" +
                "\n" +
                "O amém doim.";
        if (num < 0 || num > 19)
        {
            String naoExiste = "Nao existe piada para esse numero!";
            return naoExiste;
        }
        else
        {
            return piadas[num];
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("<<<<< Programas de Piadas >>>>>\n");
        System.out.print("Introduza um numero : ");
        System.out.println("\n" + piadaRandom(input.nextInt()));
    }
}
