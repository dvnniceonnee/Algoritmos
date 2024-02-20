package ficha_01;

import java.util.Scanner;

public class exercicio_08 {
    public static void main(String[] args) {

        // Importar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int minMusica, segMusica;
        int minutosTotais_musica, segundosTotais_musica, horasTotais_musica;

        // Output na consola de uma mensagem
        System.out.println("Ola, vamos divertir-nos com musica e tempo :)");

        // Ler imput de dados
        System.out.print("Introduza os minutos da musica 1 : ");
        minMusica = input.nextInt();
        System.out.print("Introduza os segundos da musica 1 : ");
        // Variavel que vai acrescentando os segundos conforme os dados do utilizar
        segMusica = input.nextInt() + (minMusica * 60);

        System.out.print("Introduza os minutos da musica 2 : ");
        minMusica = input.nextInt();
        System.out.print("Introduza os segundos da musica 2 : ");
        segMusica = input.nextInt() + segMusica + (minMusica * 60);

        System.out.print("Introduza os minutos da musica 3 : ");
        minMusica = input.nextInt();
        System.out.print("Introduza os segundos da musica 3 : ");
        segMusica = input.nextInt() + segMusica + (minMusica * 60);

        System.out.print("Introduza os minutos da musica 4 : ");
        minMusica = input.nextInt();
        System.out.print("Introduza os segundos da musica 4 : ");
        segMusica = input.nextInt() + segMusica + (minMusica * 60);

        System.out.print("Introduza os minutos da musica 5 : ");
        minMusica = input.nextInt();
        System.out.print("Introduza os segundos da musica 5 : ");
        segMusica = input.nextInt() + segMusica + (minMusica * 60);

        // segundosTotais_musica = segMusica1 + segMusica2 + segMusica3 + segMusica4 + segMusica5;
        // minutosTotais_musica = minMusica1 + minMusica2 + minMusica3 + minMusica4 + minMusica5 + (segundosTotais_musica / 60);
        // segundosTotais_musica = (segundosTotais_musica % 60);
        // horasTotais_musica = minutosTotais_musica / 60;
        // minutosTotais_musica = (minutosTotais_musica % 60);


        // Calcular as horas & minutos & segundos totais das musicas todas
        // Racicionio do vitor formador e suposta solução
        // horasTotais_musica = segMusica /3600;
        // minutosTotais_musica = (segMusica/60) - (horasTotais_musica * 60);
        // segundosTotais_musica = segMusica - (minutosTotais_musica * 60) - (horasTotais_musica *  3600);

        // Racicionio meu
        horasTotais_musica = segMusica /3600;
        minutosTotais_musica = (segMusica % 3600) / 60;
        segundosTotais_musica = segMusica - (minutosTotais_musica * 60) - (horasTotais_musica *  3600);


        System.out.println("O tempo de duração da musica é " + horasTotais_musica + "h " + minutosTotais_musica + "m " + segundosTotais_musica + "s");




    }
}
