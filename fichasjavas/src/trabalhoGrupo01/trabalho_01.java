package trabalhoGrupo01;

public class trabalho_01 {



    public static String[] pesquisarInfo (String[][] matrizFuncionario, int idFuncionario){

        //encontrar a linha correspondente ao id do funcionário;

        String[] infos = new String[4];

        for (int i = 0; i < infos.length; i++){
            infos[i] = matrizFuncionario[idFuncionario][i];

        }
        return infos;
    }
    public static void imprimirInfo(String[] infos ) {

        String linhaDados = "";
        String[] cabecalho = new String[4];
        cabecalho[0] = "ID:";
        cabecalho[1] = "Nome:";
        cabecalho[2] = "Telefone:";
        cabecalho[3] = "Email:";

        for (int i = 0; i < infos.length; i++)
            linhaDados = linhaDados + cabecalho[i] + " : " + infos[i] + " | ";

        String asteriscos = "";
        for (int i = 0; i < linhaDados.length() + 4; i++) {
            asteriscos = asteriscos + "*";
        }

        System.out.println(asteriscos);
        System.out.println("* " + linhaDados + " *");
        System.out.println(asteriscos);

    }

    public static void main(String[] args) {
        String[] infos = {"0", "Vítor", "225474756", "email@mail.com"};

        imprimirInfo(infos);
    }
}

