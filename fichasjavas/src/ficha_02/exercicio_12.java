package ficha_02;

import java.util.Scanner;

public class exercicio_12 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input =  new Scanner(System.in);

        //Declar variaveis
        String opçaoEscolhida;

        //Ler a opçao do utilizador
        System.out.println("Escolha qual opcao quer realizar");
        System.out.println("1 : Criar");
        System.out.println("2 : Atualizar");
        System.out.println("3 : Eliminar");
        System.out.println("4 : Sair");
        opçaoEscolhida = input.next();

        // Definir a accao consoante a escolha
        switch (opçaoEscolhida){
            case "1" :
                System.out.println("Criar ----------");
                break;
            case "2" :
                System.out.println("Atualizar ------------");
                break;
            case "3" :
                System.out.println("Eliminar -------------");
                break;
            case "4" :
                break;
            default:
                System.out.println("Opcao escohida e invalida!");
        }
    }
}
