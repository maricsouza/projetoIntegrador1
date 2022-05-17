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

    public static void cenaTres () {

        try {

            int resposta = 0;
            voltar = 0;
            int voltarTres = 0;
            boolean fragmentoUm = false;
            String textCenaTres = "O jogador chega em uma escada que da direto para uma recepcao de um hospital, ele esta vazio e bem sombrio, somente com uma atendente no balcao. O jogador se dirige ate a atendente e ela simplesmente o entrega um papel escrito:" + VERMELHO + "Quarto 13" + BRANCO + ". O jogador tenta contato, mas e completamente ignorado sempre que tenta conversar com a atendente. ";
            String opAvan [] = {"Avancar"};
            String opVolt [] = {"Voltar"};
            String opc [] = {"Ir ate moldura", opVolt[0]};
            String fichaMerlin [] = {"Nome: Merlin ██████ ██████", "Quarto: 13", "Nacionalidade: Inglaterra/Ingles", "Altura: 1,78", "Genero: Masculino", "Nascimento: 04/10/1980", "Obito: 05/02/2017", "Idade: 37", "Tipo sanguineo: O –", "Esposa: ██████ █████ ██████","Nacionalidade da esposa: França/Francesa", "Filha: Olivia ██████ ██████", "Nacionalidade da filha: Inglaterra/Inglesa", " Pai: ███████ ██████", "Nacionalidade do Pai: Inglaterra/Inglês","Mãe: █████ ██████ ", "Nacionalidade da Mãe: Itália/Italiana", "-Causa da morte: ████████"};
            String merlinTexto = "Algumas coisas estavam riscadas nao podendo identificar, mas ele guarda a ficha consigo. O jogador abre a porta e entra, era um quarto bem arrumado, as decoracoes pareciam muito com o estilo da mesa do lado de fora, a cama era grande e, ao que parece ser Merlin deitado nela, seu rosto esta coberto por uma nevoa preta. Ao lado da cama tem uma moldura de espelho na parede. \nO que voce deseja fazer?";
            String opTres[] = {"Ir ate a moldura","Olhar o corpo"};
            String moldOp = "Ele encaixa um dos pedacos que ele pegou da mao de Merlin e a nevoa de seu rosto comeca a ficar mais fraca, mas ainda nao sendo possivel de identificar o seu rosto.";
            String corpOp = "O jogador decide analisar o corpo, ele esta completamente normal, sem nenhuma sequela ou algo do tipo e em umas de suas maos ele segura um pedaco de espelho quebrado." + VERDE + "Voce obteve fragmento de espelho 1!!" + BRANCO;


            do {

                voltar++;

                resposta = perguntaResposta(textCenaTres, opAvan);

                if (validator(resposta) || resposta > opAvan.length) {
                    limparTela();
                    System.out.println(VERMELHO + "Resposta invalida");
                    voltar = 0;

                } else {
                    limparTela();
                    System.out.println();
                    System.out.println("Seguindo o corredor dos quartos ele acha o número indicado do papel, a porta era a única diferente, bem elegante e bonita, de madeira escura e envernizada, do lado da porta tem uma mesa tambem muito elegante, no mesmo estilo da porta, cheia de entalhes bonitos e adornos dourados, em cima tem um copo com agua e ao lado tem uma cartela de comprimidos vazia e a ficha do paciente. O jogador pega a ficha para analisar: \n || FICHA DE OBITO ||");
                    for (int i = 0; i < fichaMerlin.length; i++) {
                        System.out.println(fichaMerlin[i]);
                    }

                    System.out.println("||||||||||||||||||||||||||||||||||||");

                    System.out.println("1. " + opAvan[0]);
                    System.out.print("Selecione uma opcao 1/1: ");
                    resposta = scanner.nextInt();

                    if (validator(resposta) || resposta > opAvan.length) {
                        System.out.println(VERMELHO + "Resposta invalida");
                        voltar = 0;
                        return;
                    }

                    limparTela();

                } 
                
                do {

                    resposta = perguntaResposta(merlinTexto, opTres);

                    if (validator(resposta) || resposta > opTres.length) {
                        limparTela();
                        System.out.println(VERMELHO + "Resposta invalida");
                        voltar = 1;
                    } 

                    switch (resposta) {
                        case 1:
                            limparTela();
                            if (fragmentoUm == true) {
                                limparTela();
                                resposta = perguntaResposta(moldOp, opAvan);
                                voltar = 0;
                            } else {
                                limparTela();
                                perguntaResposta("Apenas uma moldura de espelho.", opVolt);
                                if (resposta == 1) {
                                    limparTela();
                                    voltar = 1;
                                }
                            }

                            break;
                            

                        case 2:
                            limparTela();
                            resposta = perguntaResposta(corpOp, opc);
                            fragmentoUm = true;

                            switch (resposta) {
                                case 1: 
                                limparTela();
                                if (fragmentoUm == true) {
                                    resposta = perguntaResposta(moldOp, opAvan);
                                    voltar = 0;

                                } 
                                else {
                                    limparTela();
                                    voltar = 1;
                                }

                                break;

                                case 2: 
                                    limparTela();
                                    voltar = 1;

                                    break;
                            }


                        default: 
                    }


                } while (voltar == 1);
                
                voltar++;

            } while (voltar == 0);





        } catch(Exception ex) {

        }

    }

    public static void cenaQuatro() {
        try {

            int resposta = 0;
            voltar = 0;
            String senha = "";
            boolean senhaCorr = false;
            String textCenaQuatro = "A porta que antes Merlin havia entrado no quarto estava diferente, a porta agora e mal-acabada e parece velha, o jogador decide abrir e entrar. Ao entrar ele se depara com o que parece ser o lado de dentro de uma cabana de ferramentas cheia de tralhas e a porta que estava atras dele nao esta mais ali, o deixando sem saida. Nesse comodo tem uma mesa bem elegante no mesmo estilo do quarto de Merlin, com adornos dourados e entalhes bonitos, em cima dela tem uma caixa que possui uma fechadura, ao lado um bilhete na mesa escrito: " + AMARELO + "Lembrete: Nao esqueca do dia dela" + BRANCO + ". Ao olhar mais em volta ele ve um calendario. \nO que voce deseja fazer?";
            String opcoesCenaT[] = {"Ir ate a caixa", "Ir ate o calendario"};
            String opVolt[] = {"Voltar"};
            String opcCaixa[] = {"Digitar senha", opVolt[0]};
            String opAvan[] = {"Avancar"};

            limparTela();

            do {

                voltar++;

                resposta = perguntaResposta(textCenaQuatro, opcoesCenaT);

                if (validator(resposta) || resposta > opcoesCenaT.length) {
                    limparTela();
                    System.out.println(VERMELHO + "Resposta invalida");
                    voltar = 0;
                } 

                switch (resposta) {
                    case 1:
                        limparTela();
                        while (senhaCorr == false || voltar == 1) {

                            resposta = perguntaResposta("A fechadura possui uma senha de 4 digitos. \nQual a a senha?", opcCaixa);

                            if (resposta == 1) {
                                System.out.print("Digite a senha: ");
                                senha = console.readLine();
    
                                    if (senha.equals("1406")) {
                                        limparTela();
                                        senhaCorr = true;
                                        resposta = perguntaResposta("O jogador coloca os numeros da data marcada no calendario (1402) na senha e a fechadura se abre. Dentro da caixa tinha mais um pedaço de espelho, no qual ele pega" + VERDE + "(Voce obteve o fragmento de espelho 2!)" + BRANCO + " e algo escrito no fundo da caixa:" + VERMELHO + " Mais uma vez o papai nao veio. " + BRANCO + " Uma porta aparece, a mesma porta do quarto de Merlin, ele entra e coloca mais um pedaco no espelho. A nevoa fica cada vez mais fraca, mas ainda tem dificuldade de ver o rosto.", opAvan);

                                        if (resposta == 1) {
                                            voltar++;
                                        }
                                    
                                    } else {
                                        limparTela();
                                        System.out.println(VERMELHO + "Resposta incorreta. Tente novamente.");
                                        voltar = 1;
                                    }
    
                            } else if (resposta == 2) {
                                limparTela();
                                voltar = 0;
                                break;

                            } else {
                                limparTela();
                                System.out.println(VERMELHO + "Resposta invalida.");
                                voltar = 1;
                            }

                        }

                        break;
                        
                    case 2:
                        limparTela();
                        resposta = perguntaResposta("Calendario do ano de 2006, no dia 14 de fevereiro" + VERMELHO + "(14/02)" + BRANCO + " tem um nome escrito: " + AMARELO +  "Olivia." + BRANCO, opVolt);

                        if (resposta == 1) {
                            limparTela();
                            voltar = 0;
                        }

                        break;

                }


            } while (voltar == 0);


        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void cenaCinco() {
        try {

            String textCinco = "A porta muda outra vez, e uma porta branca simples, o jogador entra e se depara com um quarto e a porta some novamente, parece ser um quarto infantil, uma cama pequena, guarda-roupa e uma mesa baixa com alguns papeis e lapis de cor espalhados. \nO que voce deseja fazer?";
            int resposta = 0;
            voltar = 0;
            boolean chave = false;
            String opcCinco[] = {"Ir ate a cama", "Ir ate a mesa", "Ir ao guarda-roupa"};
            String opVolt[] = {"Voltar"};
            String opAvan [] = {"Avancar"};
            String opCama[] = {"Pegar e abrir a caixa", opVolt[0]};

            limparTela();
            do {

                voltar++;

                resposta = perguntaResposta(textCinco, opcCinco);

                if (validator(resposta) || resposta > opcCinco.length){
                    limparTela();
                    System.out.println(AMARELO + "Resposta nao permitida. ");
                    voltar = 0;
                }

               switch(resposta) {
                   case 1:
                        limparTela();
                        while (voltar == 1) {
                            resposta = perguntaResposta("Na cama em si nao ha nada demais, bem arrumada e organizada com algumas pelucias em cima, olhando em baixo, o jogador se depara com uma caixa de madeira muito elegante. ", opCama);

                            if (validator(resposta) || resposta > opCama.length){
                                limparTela();
                                System.out.println(AMARELO + "Resposta nao permitida. ");
                                voltar = 1;
                            }

                            switch(resposta) {
                                case 1:
                                    limparTela();

                                    if (chave == true) {
                                        resposta = perguntaResposta("Abrindo a caixa com a chave" + VERDE + " (Chave da caixa foi usada!)" + BRANCO + ", tinha mais um fragmento de espelho dentro, a porta do quarto de Merlin reaparece.", opAvan);

                                        if(resposta == 1) {
                                            limparTela();
                                            voltar++;
                                        }

                                    } else {
                                        resposta = perguntaResposta("A caixa precisa de uma chave.", opVolt);

                                        if(resposta == 1) {
                                            limparTela();
                                            voltar = 1;
                                        }

                                    }

                                    break; 

                                case 2:
                                    limparTela();
                                    voltar = 0;
                                    break;
                            }

                        }

                        break;

                   case 2:
                        limparTela();
                        resposta = perguntaResposta("Olhando a mesa, ele ve um desenho em uma das folhas, ao que parece ser uma familia, uma figura feminina alta segurando a mao de uma outra figura feminina so que mais baixa e com um rosto triste desenhado e uma figura masculina ao lado das duas com o rosto rabiscado, no outro desenho tem um armario e a mesma figura feminina menor dentro dele e com o rosto triste, do lado uma janela e parece estar chovendo pelos riscos nela. ", opVolt);

                        if (resposta == 1) {
                            limparTela();
                            voltar = 0;
                        }

                        break;

                   case 3:
                        limparTela();
                        resposta = perguntaResposta("Ele abre a porta do guarda-roupa, esta vazio, mas tem algo escrito na madeira, como se tivesse sido raspado:" + VERMELHO + " to com medo" + BRANCO + ", instantaneamente comeca uma chuva forte, seguido de um trovao, algo cai de cima do guarda-roupa, ao olhar mais de perto, ele se depara com uma chave," + VERDE + " (obteve: Chave da caixa). " + BRANCO, opVolt);
                        chave = true;

                        if (resposta == 1) {
                            limparTela();
                            voltar = 0;
                        }

                        break;

               }



            } while (voltar == 0);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    

}
