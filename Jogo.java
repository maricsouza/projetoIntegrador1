import java.util.Scanner;

class Jogo {

    public static Scanner scanner = new Scanner(System.in);
    public static void main (String [] args ) {
    	
    	Funcoes.abrirCmd();
    	
        Funcoes.limparTela();

        Funcoes.cenaUm();

        Funcoes.cenaDois();

        Funcoes.cenaTres();

        Funcoes.cenaQuatro();

        Funcoes.cenaCinco();

        Funcoes.cenaSeis();

        Funcoes.cenaFinal();
    }
}
