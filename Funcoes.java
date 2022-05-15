import java.io.Console;
import java.util.Scanner;

public class Funcoes {

    private static Scanner scanner = new Scanner(System.in);
    private static Console console = System.console();
    private static int voltar = 0;


    public static void limparTela () {
        try {

            new ProcessBuilder("cmd", "/c" , "cls" ).inheritIO().start().waitFor();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // public static void cenasPerguntas (String texto, String opcoes[], String posRespostas[][]) {
    //     System.out.println(texto);
    //     System.out.println("O que voce deseja fazer?");

    //     int tamanho = opcoes.length;
    //     for (int i = 0; i < tamanho; i++) {
    //         System.out.println((i + 1) + " " + opcoes[i]);
    //     }

    //     if (tamanho == 1) 
    //         System.out.print("Selecione uma opção: ");
    //     else 
    //         System.out.print ("Digite um número de 1/" + tamanho + ": ");

    //     String resposta = console.readLine();

    //     if (tamanho == 3) {

    //         if (resposta.equalsIgnoreCase(posRespostas[1][1]) ) {
    //             System.out.println(posRespostas[1][2]);
    //         } else if (resposta.equalsIgnoreCase(posRespostas[2][1])) {
    //             System.out.println(posRespostas[2][2]);
    //         } else {
    //             System.out.println(posRespostas[3][2]);
    //         }

    //     } else if (tamanho == 2) {

    //         if (resposta.equalsIgnoreCase(posRespostas[1][1]) ) {
    //             System.out.println(posRespostas[1][2]);
    //         } else 
    //             System.out.println(posRespostas[2][2]);

    //     } else if (tamanho == 1) {

    //         if (resposta.equalsIgnoreCase(posRespostas[1][1]) )
    //             System.out.println(posRespostas[1][2]);

    //     } else {
    //         System.out.println("Não há essa opção de resposta");
    //     }
    // }

    public static int perguntaResposta (String texto, String opcoes []) {

        System.out.println(texto);
        int tam = opcoes.length;

        for (int i = 0; i < tam;  i++) {
            System.out.println((i + 1) + opcoes[i]);
        }

        System.out.print("Selecione uma opção entre 1/" + tam);
        int resposta = scanner.nextInt();


        return resposta;
    }

    public static boolean validator (int valor) {
        return valor < 0 || valor == 0;
    }

    public static void cenaUm () {
        try {
            
            int resposta = 0;
            String textoInicial = "O jogador acorda em um quarto escuro, onde a unica fonte de luz e uma lamparina que esta ao lado dele, ele a pega para iluminar mais o local, junto a ela havia uma chave. Em um dos cantos desse quarto, ele observa algo escondido por um pano o cobrindo e ao norte ha uma porta fechada. \nO que voce deseja fazer?";
            String opUm [] = {"Pegar chave", "Ir ate o canto do quarto", "Ir ate e abrir a porta"};
            String caixaM = "Ele vai ate o canto onde ele viu algo e tira o pano de cima, revelando uma caixa pequena de madeira."; 
            String caixM[] = {"Abrir caixa", "Voltar"};

            do {
                voltar = 0;
                voltar++;

               resposta = perguntaResposta(textoInicial, opUm);

               if (validator(resposta) || resposta > opUm.length){
                    System.out.println("Resposta nao permitida. ");
                    voltar = 0;
               } 

               switch (resposta) {
                   case 1:
                        System.out.println("Você pegou a chave.");
                        voltar = 0;
                        break;
                   case 2:

                        resposta = perguntaResposta(caixaM, caixM);
                        if (validator(resposta) || resposta > opUm.length){
                            System.out.println("Resposta nao permitida. ");
                            voltar = 0;
                        } 

                        switch (resposta) {
                            case 1:
                            case 2:
                            default:
                        }


                   case 3:
                   default:
               }
                
               
               limparTela();

            } while (voltar != 0);

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
