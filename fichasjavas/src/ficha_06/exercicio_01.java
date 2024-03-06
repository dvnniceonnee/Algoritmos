package ficha_06;

import java.util.Scanner;

public class exercicio_01 {
    public static String fazerBarulho (String a)
    {
        String som;
        if (a.equalsIgnoreCase("cao"))
            som = "Au au au";
        else if (a.equalsIgnoreCase("gato"))
            som = "Miau";
        else if (a.equalsIgnoreCase("peixe"))
            som = "Glub";
        else if (a.equalsIgnoreCase("vaca"))
            som = "Muuuu";
        else if (a.equalsIgnoreCase("porco"))
            som = "Oinc oinc";
        else {
            som = "Animal invalido!";
        }
        return som;
    }
    public static void main(String[] args) {
        //Scanner
        Scanner input = new Scanner(System.in);

        String animal;

        System.out.print("Introduza um animal : ");
        animal = input.next();
        System.out.println(fazerBarulho(animal));


    }
}
