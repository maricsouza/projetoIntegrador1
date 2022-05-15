import java.io.Console;
import java.util.Scanner;

public class Funcoes {

    private static Scanner scanner = new Scanner(System.in);
    private static Console console = System.console();
    private static final String VERMELHO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String BRANCO = "\u001B[37m";
    private static final String AMARELO = "\u001B[33m";
    private static int voltar = 0;
    public static boolean papelDirecoes = false;
    public static int direcoes[] = {1,2,2,1,2};
    public static int certo = 0;
    public static int errado = 0;


    public static void limparTela () {
        try {

            new ProcessBuilder("cmd", "/c" , "cls" ).inheritIO().start().waitFor();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int perguntaResposta (String texto, String opcoes []) {

        System.out.println(BRANCO + texto);
        int tam = opcoes.length;

        for (int i = 0; i < tam;  i++) {
            System.out.println((i + 1) + ". " + opcoes[i]);
        }

        System.out.print(BRANCO + ("Selecione uma opcao entre 1/" + tam + ": "));
        int resposta = scanner.nextInt();


        return resposta;
    }

    public static boolean validator (int valor) {
        return valor < 0 || valor == 0;
    }

    public static boolean direcaoCerta (int usuDirecao, int direcao[], int numDirecao) {
                return usuDirecao == direcao[numDirecao];   
    }

    public static void direcoesConf (int usuDirecao, int direcao[], int numDirecao) {
        
        System.out.println(numDirecao);
        if (direcaoCerta(usuDirecao, direcao, numDirecao)) {
            limparTela();
            certo++;

        } else {
            errado++;
        }

    }

    public static void cenaUm () {
        try {
            
            int resposta = 0;
            boolean chave = false;
            String textoInicial = "O jogador acorda em um quarto escuro, onde a unica fonte de luz e uma lamparina que esta ao lado dele, ele a pega para iluminar mais o local, junto a ela havia uma chave. Em um dos cantos desse quarto, ele observa algo escondido por um pano o cobrindo e ao norte ha uma porta fechada. \nO que voce deseja fazer?";
            String opUm [] = {"Pegar chave", "Ir ate o canto do quarto", "Ir ate e abrir a porta"};
            String caixaM = "Ele vai ate o canto onde ele viu algo e tira o pano de cima, revelando uma caixa pequena de madeira."; 
            String caixM[] = {"Abrir caixa", "Voltar"};

            do {

                voltar = 0;
                voltar++;

               resposta = perguntaResposta(textoInicial, opUm);

               if (validator(resposta) || resposta > opUm.length){
                    limparTela();
                    System.out.println(AMARELO + "Resposta nao permitida. ");
                    voltar = 0;
               } 

               switch (resposta) {
                   case 1:

                        limparTela();

                        if (chave == false) {
                            System.out.println(VERDE + ("Voce pegou a chave."));
                            voltar = 0;
                            chave = true;
                        } else {
                            System.out.println(AMARELO +"Voce ja pegou a chave");
                            voltar = 0;
                        }
                        break;

                   case 2:

                        limparTela();

                        resposta = perguntaResposta(caixaM, caixM);

                        if (validator(resposta) || resposta > opUm.length){
                            limparTela();
                            System.out.println(AMARELO + "Resposta nao permitida. ");
                            voltar = 0;
                        } 

                        switch (resposta) {

                            case 1:
                                limparTela();
                                if (papelDirecoes == false) {
                                    System.out.println(BRANCO + "Ele abre a caixa, dentro ele encontra um papel com direcoes escritas em uma ordem:" + VERMELHO + "esquerda-direita-direita-esquerda-direita" + BRANCO + " e logo em seguida esta escrito:" + VERMELHO + " Nao se perca." + VERDE + "\n" + "Voce obteve um papel com direcoes!");
                                    papelDirecoes = true;
                                    
                                    
                                } else {
                                    System.out.println(AMARELO + "Voce ja abriu a caixa.");
                                }
                                    voltar = 0;
                                    break;

                            case 2:
                                limparTela();
                                voltar = 0;
                                break;

                            default:
                                voltar = 0;
                                break;
                        }

                        break;


                   case 3: 
                        limparTela();
                        if (chave == false){
                             
                            System.out.println(AMARELO + "A porta esta trancada.");
                            voltar = 0;
                        }else
                            voltar++;

                        break;

                   default:
                        voltar = 0;
               }
                

            } while (voltar == 0);

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }



    public static void cenaDois () {
        try {

            int resposta = 0;
            int teste = 0;
            int volta = 0;
            String textoCenaDois = "Ele abre a porta e da direto com um corredor sem qualquer iluminacao somente com a pouca luz de sua lamparina. Quando o jogador ultrapassa a porta, ela se fecha com forca nao o deixando voltar. Ele se encontra sem escolhas a nao ser continuar seguindo. Mais a frente, o jogador se depara com dois caminhos com algo escrito na parede entre eles." + VERMELHO + " Nao se perca." + BRANCO + " \nPara que lado voce quer ir?";
            String ladoCerto = VERDE + "Voce foi para o lado certo." + BRANCO + " \nPara que lado voce quer ir?";
            String opCenaDois [] = {"Esquerda", "Direita"};

            do {
                volta++;

                if ( papelDirecoes == true) {
                    System.out.println(AMARELO + "esquerda-direita-direita-esquerda-direita");
                }  

                if (volta == 1) {
                    resposta = perguntaResposta(textoCenaDois, opCenaDois);
                        direcoesConf(resposta, direcoes, teste);
                }
                
                if (errado >= 1) {
                    limparTela();
                    System.out.println(VERMELHO + "Voce foi para o lado errado e teve que voltar desde o comeco do percurso.");
                    volta = 0;
                    errado = 0;
                    certo = 0;
                    teste = 0;

                }

                if (certo >= 1) {
                    teste++;
                    resposta = perguntaResposta(ladoCerto, opCenaDois);

                    direcoesConf(resposta, direcoes, teste);
                }

 
            } while (volta == 0 || volta < 4);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
