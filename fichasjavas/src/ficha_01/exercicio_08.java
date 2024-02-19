package ficha_01;

import java.util.Scanner;

public class exercicio_08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int minMusica1, segMusica1, minMusica2, segMusica2, minMusica3, segMusica3, minMusica4, segMusica4, minMusica5, segMusica5;
        int minutosTotais_musica, segundosTotais_musica, horasTotais_musica;

        System.out.println("Ola, vamos divertir-nos com musica e tempo :)");

        System.out.print("Introduza os minutos da musica 1 : ");
        minMusica1 = input.nextInt();
        System.out.print("Introduza os segundos da musica 1 : ");
        segMusica1 = input.nextInt();

        System.out.print("Introduza os minutos da musica 2 : ");
        minMusica2 = input.nextInt();
        System.out.print("Introduza os segundos da musica 2 : ");
        segMusica2 = input.nextInt();

        System.out.print("Introduza os minutos da musica 3 : ");
        minMusica3 = input.nextInt();
        System.out.print("Introduza os segundos da musica 3 : ");
        segMusica3 = input.nextInt();

        System.out.print("Introduza os minutos da musica 4 : ");
        minMusica4 = input.nextInt();
        System.out.print("Introduza os segundos da musica 4 : ");
        segMusica4 = input.nextInt();

        System.out.print("Introduza os minutos da musica 5 : ");
        minMusica5 = input.nextInt();
        System.out.print("Introduza os segundos da musica 5 : ");
        segMusica5 = input.nextInt();

        segundosTotais_musica = segMusica1 + segMusica2 + segMusica3 + segMusica4 + segMusica5;
        minutosTotais_musica = minMusica1 + minMusica2 + minMusica3 + minMusica4 + minMusica5 + (segundosTotais_musica / 60);
        segundosTotais_musica = (segundosTotais_musica % 60);
        horasTotais_musica = minutosTotais_musica/60;
        minutosTotais_musica = (minutosTotais_musica%60);

        System.out.println("O tempo de duração da musica é " + horasTotais_musica + "h " + minutosTotais_musica + "m " + segundosTotais_musica + "s");




    }
}
