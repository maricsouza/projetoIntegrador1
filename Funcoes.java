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
    
    // public static void abrirCmd () {
    //     try {

    //         new ProcessBuilder("cmd").inheritIO().start().waitFor();

    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //     }
    // }

    public static int perguntaResposta (String texto, String opcoes []) {
        
        int resposta = 0;
        
        try {
            
            
            System.out.println(BRANCO + texto);
            int tam = opcoes.length;

            for (int i = 0; i < tam;  i++) {
                System.out.println((i + 1) + ". " + opcoes[i]);
            }

            System.out.print(BRANCO + ("Selecione uma opcao entre 1/" + tam + ": "));

            resposta = scanner.nextInt();

            return resposta;

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

        
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
            String textoInicial = "Voce acorda em um quarto escuro, onde a unica fonte de luz e uma lamparina que esta ao seu lado, voce a pega para iluminar mais o local, junto a ela havia uma chave. (obteve lamparina e chave) Em um dos cantos desse quarto, voce observa algo escondido por um pano o cobrindo e ao norte ha uma porta fechada.\n O que voce deseja fazer?";
            String opUm [] = {"Pegar chave", "Ir ate o canto do quarto", "Ir ate a porta e tentar abrir"};
            String caixaM = "Voce vai ate o canto onde viu algo e tira o pano de cima, revelando uma caixa pequena de madeira."; 
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
                                    System.out.println(BRANCO + "Voce abre a caixa, dentro se encontra um papel com direcoes escritas em uma ordem:" + VERMELHO + "esquerda-direita-direita-esquerda-direita" + BRANCO + " e logo em seguida esta escrito:" + VERMELHO + " Nao se perca." + VERDE + "\n" + "(Voce obteve um papel com direcoes!)");
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
            int papel = 0;
            String textoCenaDois = "Voce abre a porta e da direto com um corredor sem qualquer iluminacao somente com a pouca luz de sua lamparina. Voce ultrapassa a porta, ela se fecha com forca nao o deixando voltar. Voce se encontra sem escolhas a nao ser continuar seguindo. Mais a frente, voce se depara com dois caminhos com algo escrito na parede entre eles." + VERMELHO + " Nao se perca." + BRANCO + " \nPara que lado voce quer ir?";
            String ladoCerto = VERDE + "Voce foi para o lado certo." + BRANCO + " \nPara que lado voce quer ir?";
            String opCenaDois [] = {"Esquerda", "Direita"};

            do {
                volta++;

                if ( papelDirecoes == true && papel == 0) {
                    papel++;
                    System.out.println(AMARELO + "esquerda-direita-direita-esquerda-direita");
                }
                if (volta == 1) {
                    resposta = perguntaResposta(textoCenaDois, opCenaDois);
                        direcoesConf(resposta, direcoes, teste);
                }

                if ( papelDirecoes == true && papel == 1) {
                    System.out.println(AMARELO + "esquerda-direita-direita-esquerda-direita");
                }
                
                if (errado >= 1) {
                    limparTela();
                    System.out.println(VERMELHO + "Voce errou o caminho e teve que voltar desde o comeco do percurso.");
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

 
            } while (volta == 0 || certo != 5);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void cenaTres () {

        try {

            int resposta = 0;
            voltar = 0;
            boolean fragmentoUm = false;
            String textCenaTres = "Voce chega em uma escada que da direto para uma recepcao de um hospital, ele esta vazio e bem sombrio, somente com uma atendente no balcao. Voce se dirige ate a atendente e ela simplesmente o entrega um papel escrito:" + VERMELHO + " Quarto 13" + BRANCO + ". Voce tenta contato, mas e completamente ignorado sempre que tenta conversar com a atendente. ";
            String opAvan [] = {"Avancar"};
            String opVolt [] = {"Voltar"};
            String opc [] = {"Ir ate moldura", opVolt[0]};
            String fichaMerlin [] = {"\nNome: Merlin _______ _______", "Quarto: 13", "Nacionalidade: Inglaterra/Ingles", "Altura: 1,78", "Genero: Masculino", "Nascimento: 04/10/1980", "Obito: 05/02/2017", "Idade: 37", "Tipo sanguineo: O ", "Esposa: ______ _______ _______","Nacionalidade da esposa: Franca/Francesa", "Filha: Olivia ______ ______", "Nacionalidade da filha: Inglaterra/Inglesa", " Pai: _______ _______", "Nacionalidade do Pai: Inglaterra/Ingles","Mae: _______ ______ ", "Nacionalidade da Mae: Italia/Italiana", "-Causa da morte: O_________"};
            String merlinTexto = "Algumas coisas estavam riscadas nao podendo identificar, mas voce guarda a ficha consigo. Voce abre a porta e entra, era um quarto bem arrumado, as decoracoes pareciam muito com o estilo da mesa do lado de fora, a cama era grande e, ao que parece ser Merlin deitado nela, seu rosto esta coberto por uma nevoa preta. Ao lado da cama tem uma moldura de espelho na parede. \nO que voce deseja fazer?";
            String opTres[] = {"Ir ate a moldura","Olhar o corpo"};
            String moldOp = "Ele encaixa um dos pedacos que ele pegou da mao de Merlin e a nevoa de seu rosto comeca a ficar mais fraca, mas ainda nao sendo possivel de identificar o seu rosto.";
            String corpOp = "Voce decide analisar o corpo, ele esta completamente normal, sem nenhuma sequela ou algo do tipo e em umas de suas maos ele segura um pedaco de espelho quebrado." + VERDE + " (Voce obteve fragmento de espelho 1!)" + BRANCO;


            do {

                resposta = perguntaResposta(textCenaTres, opAvan);

                if (validator(resposta) || resposta > opAvan.length) {
                    limparTela();
                    System.out.println(VERMELHO + "Resposta invalida");
                    voltar = 0;

                } else {

                    voltar++;
                    limparTela();
                    System.out.println();
                    System.out.println("Seguindo o corredor dos quartos voce acha o numero indicado do papel, a porta era a ??nica diferente, bem elegante e bonita, de madeira escura e envernizada, do lado da porta tem uma mesa tambem muito elegante, no mesmo estilo da porta, cheia de entalhes bonitos e adornos dourados, em cima tem um copo com agua e ao lado tem uma cartela de comprimidos vazia e a ficha do paciente. Voce pega a ficha para analisar: \n\n || FICHA DE OBITO ||");
                    for (int i = 0; i < fichaMerlin.length; i++) {
                        System.out.println(fichaMerlin[i]);
                    }

                    System.out.println("\nP||||||||||||||||||||||||||||||||||||\n\n");

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
                
                while (voltar == 1) {
                    
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


                
                }

                if(fragmentoUm == true) {
                    voltar++;
                }


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
            String textCenaQuatro = "A porta por onde voce havia entrado no quarto estava diferente, agora ela esta mal-acabada e parece velha, voce decide abrir e entrar. Ao entrar voce se depara com o que parece ser o lado de dentro de uma cabana de ferramentas cheia de tralhas e a porta que estava atras de voce nao esta mais ali, o deixando sem saida. Nesse comodo tem uma mesa bem elegante no mesmo estilo do quarto de Merlin, com adornos dourados e entalhes bonitos, em cima dela tem uma caixa que possui uma fechadura, ao lado um bilhete na mesa escrito: " + AMARELO + " Lembrete: Nao esqueca do dia dela" + BRANCO + ". Ao olhar mais em volta voce ve um calendario. \nO que voce deseja fazer?";
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
    
                                    if (senha.equals("1402")) {
                                        limparTela();
                                        senhaCorr = true;
                                        resposta = perguntaResposta("Voce coloca os numeros da data marcada no calendario (1402) na senha e a fechadura se abre. Dentro da caixa tinha mais um peda??o de espelho, no qual voce pega" + VERDE + " (Voce obteve o fragmento de espelho 2!)" + BRANCO + " e algo escrito no fundo da caixa:" + VERMELHO + " Mais uma vez o papai nao veio. " + BRANCO + " Uma porta aparece, a mesma porta do quarto de Merlin, voce entra e coloca mais um pedaco no espelho. A nevoa fica cada vez mais fraca, mas ainda tem dificuldade de ver o rosto.", opAvan);

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
                        resposta = perguntaResposta("Calendario do ano de 2006, no dia 14 de fevereiro " + VERMELHO + "(14/02)" + BRANCO + " tem um nome escrito: " + AMARELO +  "Olivia." + BRANCO, opVolt);

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

            String textCinco = "A porta muda outra vez, e uma porta branca simples, voce entra e se depara com um quarto e a porta some novamente, parece ser um quarto infantil, uma cama pequena, guarda-roupa e uma mesa baixa com alguns papeis e lapis de cor espalhados. \nO que voce deseja fazer?";
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
                            resposta = perguntaResposta("Na cama em si nao ha nada demais, bem arrumada e organizada com algumas pelucias em cima, olhando em baixo, voce se depara com uma caixa de madeira muito elegante. ", opCama);

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
                        resposta = perguntaResposta("Olhando a mesa, voce ve um desenho em uma das folhas, ao que parece ser uma familia, uma figura feminina alta segurando a mao de uma outra figura feminina so que mais baixa e com um rosto triste desenhado e uma figura masculina ao lado das duas com o rosto rabiscado, no outro desenho tem um armario e a mesma figura feminina menor dentro dele e com o rosto triste, do lado uma janela e parece estar chovendo forte e trovejando. ", opVolt);

                        if (resposta == 1) {
                            limparTela();
                            voltar = 0;
                        }

                        break;

                   case 3:
                        limparTela();
                        resposta = perguntaResposta("Voce abre a porta do guarda-roupa, esta vazio, mas tem algo escrito na madeira, como se tivesse sido raspado:" + VERMELHO + " to com medo" + BRANCO + ", instantaneamente comeca uma chuva forte, seguido de um trovao, algo cai de cima do guarda-roupa, ao olhar mais de perto, ele se depara com uma chave," + VERDE + " (obteve: Chave da caixa). " + BRANCO, opVolt);
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

    public static void cenaSeis() {
        try {

            int resposta = 0;
            voltar = 0;
            String senha = "";
            String textSeisA = "O espelho esta quase completo, mas ainda parece faltar um ultimo pedaco e o nevoa abaixa mais uma vez, mas ainda nao dando para identificar o rosto. Dessa vez a porta nao mudou, mas ela esta entreaberta, mas e muito escuro para poder enxergar la dentro. De repente um barulho de vidro quebrando vem de dentro do lugar.";
            String textSeisB = "Ao entrar o quarto esta escuro somente com a luz da tela de um notebook que esta em cima de uma mesa de escritorio, a mesa tem duas gavetas. Olhando na primeira gaveta tem muitos remedios e comprimidos, mas nada alem disso, na gaveta de baixo tem alguns papeis com anotacoes de trabalho e um caderno pequeno, ao pegar o caderno e olhar, tem uma unica coisa escrita nele:" + AMARELO + "Usuario: MerlinLM \nSenha: 041053"+ BRANCO + ".";
            String textSeisC = "Em cima, alem do notebook ligado, ao lado tem um porta retrato com uma foto de uma garotinha. Olhando o chao, ha cacos de vidro espalhados, como se algo tivesse sido jogado e quebrado. Ao usar o usuario e a senha no notebook ele e desbloqueado, tendo assim logo de comeco um e-mail aberto:" + AMARELO +  " Devido as circunstancias da empresa e de problemas administrativos, estamos o desligando. Agradecemos o seu servico. suporte@agenciamv.com" + BRANCO +  " e alguns arquivos na ??rea de trabalho:" + AMARELO + " img1.png, img2.png e img3.png." + BRANCO;
            String opAvan [] = {"Avancar"};
            String opVoltar[] = {"Voltar"};
            String opSenha[] = {"Digite a senha", "Voltar"};
            String optxC[] = {"Ver img1.png", "Ver img2.png", "Ver img3.png"};

            do {

                voltar++;

                resposta = perguntaResposta(textSeisA, opAvan);
                if (validator(resposta) || resposta > opAvan.length){
                    limparTela();
                    System.out.println(AMARELO + "Resposta nao permitida. ");
                    voltar = 0;
                } else {
                    limparTela();
                    resposta = perguntaResposta(textSeisB, opAvan);
                }

                if (validator(resposta) || resposta > opAvan.length){
                    limparTela();
                    System.out.println(AMARELO + "Resposta nao permitida. ");
                    voltar = 0;
                } 

                limparTela();

                while (voltar == 1) {

                    resposta = perguntaResposta(textSeisC, optxC);

                    if (validator(resposta) || resposta > optxC.length){
                        limparTela();
                        System.out.println(AMARELO + "Resposta nao permitida. ");
                        voltar = 1;

                        break;
                    } else {
                        switch (resposta) {
                            case 1:
                                limparTela();
                                resposta = perguntaResposta(AMARELO + "img1.png:" + BRANCO + " uma imagem de um porta retrato com uma foto de uma garotinha e tem algo escrito no canto da imagem: " + VERMELHO + "OLIVIA. " + BRANCO, opVoltar);
                                if (resposta == 1) {
                                    limparTela();
                                    voltar = 1;
                                }
                                break;

                            case 2:
                                limparTela();
                                resposta = perguntaResposta("A imagem possui senha.", opSenha);

                                if (validator(resposta) || resposta > opSenha.length){
                                    limparTela();
                                    System.out.println(AMARELO + "Resposta nao permitida. ");
                                    voltar = 1;
                                    break;
                                } 

                                switch (resposta) {
                                    case 1:
                                        System.out.print("Digite a senha: ");
                                        senha = console.readLine();

                                        if(senha.equalsIgnoreCase("Olivia")) {
                                            limparTela();
                                            resposta = perguntaResposta(AMARELO + "img2.png: " + BRANCO + "A parte de tras de um porta-retrato com uma chave colada e tem algo escrito no canto da imagem:" + VERMELHO + " AMELIA." + BRANCO, opVoltar);

                                            if ( resposta == 1 ) {
                                                limparTela();
                                                voltar = 1;
                                                break;
                                            }

                                        } else {
                                            limparTela();
                                            System.out.println(VERMELHO + "Senha incorreta.");
                                            voltar = 1;
                                        }

                                        break;

                                    case 2:
                                        limparTela();
                                        voltar = 1;
                                       
                                        

                                }

                                break;



                            case 3:

                                limparTela();
                                resposta = perguntaResposta("A imagem possui senha.", opSenha);

                                if (validator(resposta) || resposta > opSenha.length){
                                    limparTela();
                                    System.out.println(AMARELO + "Resposta nao permitida. ");
                                    voltar = 1;
                                    break;
                                }

                                switch (resposta) {
                                    case 1:
                                        System.out.print("Digite a senha: ");
                                        senha = console.readLine();

                                        if(senha.equalsIgnoreCase("Amelia")) {
                                            limparTela();
                                            resposta = perguntaResposta(AMARELO + "img3.png: " + VERMELHO + "Uma porta de madeira fechada." + BRANCO , opAvan);
                                            voltar++;

                                            if ( resposta == 1 ) {
                                                limparTela();
                                                break;
                                            }

                                        } else {
                                            limparTela();
                                            System.out.println(VERMELHO + "Senha incorreta.");
                                            voltar = 1;
                                        }

                                        break;

                                    case 2:
                                        limparTela();
                                        voltar = 1;
                                        break;

                                }

                                break;
                        }
                    }

                }


            } while(voltar == 0);


        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void cenaFinal() {
        try {

            voltar = 0;
            int resposta = 0;
            String textFinalA = "Depois de ver a ultima imagem, a porta se fecha com forca. Ao analisar o porta-retrato novamente, tem uma chave logo atras. A porta que estava trancada agora pode ser aberta. Uma sala completamente vazia, apenas com uma mesa no meio e uma luz vinda de cima a iluminando, em cima da mesa tem mais um peda??o do espelho" + VERDE + "(Voce obteve o fragmento de espelho 3!). " + BRANCO;
            String textFinalB = "A luz se apaga o deixando no completo escuro, logo em seguida uma outra luz acende iluminando uma porta ao longe, a porta do quarto de Merlin. Entrando na porta, agora temos a presenca de duas entidades: uma crianca e uma mulher ao lado da cama de Merlin olhando para ele, elas te ignoram mesmo tentando interagir. Colocando o ultimo fragmento a nevoa some...";
            String textFinalC = "Tudo fica escuro, no fundo uma reportagem tocando em um radio:" + AMARELO + "Merlin Lennox Marino foi encontrado desacordado nessa manha de segunda-feira, dia 5 de fevereiro de 2017. Perto dele havia um copo com agua e ao lado uma cartela de comprimidos vazia. Uma carta de desabafo estava junto com a cartela de comprimidos. Apos isso ele foi levado para o hospital mais proximo, mas acabou nao resistindo."+ BRANCO + " \nAgora o silencio toma conta... \n\n\n\n\n\n\n Ler a carta?";
            String respOp [] = {"Sim", "Nao"};
            String cartaMerlinA = AMARELO + "Viver por viver. O que tenho a aproveitar de uma vida assim? Vivi a vida trabalhando dia e noite, evitando folgas e sempre me empolgava quando meu chefe pedia para fazer algo a mais, e no final acabei sendo despedido. Ignorava qualquer coisa que nao fosse trabalho, eu apenas estava afim de ganhar a vida o mais rapido o possivel que virou rotina trabalhar diariamente e viver para o trabalho. Eu achei que estava dando o melhor para os meus. Uma casa, um conforto, tudo que eles precisavam... Mas, e eu? Pe??o perdao, Olivia. O papai nao pode estar em nenhum dos seus aniversarios. O papai mal estava presente em casa. Peco perdao, querida. Voc?? se casou com uma maquina que esqueceu o que a amor. Voce sempre estava ali por mim, quando eu estava chorando, quando eu estava feliz, mas eu nem sequer lembrei a data do seu aniversario quando ele chegou, e voce nao teve nem mesmo um bolo. Agradeco por comemorar os anos da minha filha e nao deixar ela passar pelo que te fiz passar. Querida, voce deve ter sofrido muito por estar com alguem como eu.";
            String cartaMerlinB = AMARELO + "Do que adianta ter um bom trabalho, boas roupas, uma boa casa se eu nao pude aproveitar coisas simples que eu podia ter aproveitado? Pra que eu me casei, afinal? E tive uma filha?! E como se eu nunca tivesse feito isso. As dei conforto e achei que era o suficiente. Eu sei que nunca e o suficiente. E como um copo pronto para transbordar a qualquer momento. Como pude nao estar presente nos momentos mais importantes daqueles que eu chamo de familia todo dia?! Nao vi seu primeiro dente nascer, Olivia. Nao vi seu parto, amor. E eu me arrependo amargamente de tudo isso. Construi uma familia e perdi a honra de poder ser chamado pai. Eu peco perdao, peco desculpas e sei que nao mereco perdao. \nPeco perdao por ir assim, mas nao sintam minha falta. Apenas nao facam o que fiz. \nNao vivam em vao. Voces sao meu tudo.\nEstarei feliz se voces estiverem tambem.\nMas agora, esse mundo nao serve mais para mim. Minha hora chegou.\nApenas continuem vivendo. O senhor Merlin ama voces.";
            String opAvan[] = {"Avancar"};

            limparTela();

            do {

                voltar++;

                resposta = perguntaResposta(textFinalA, opAvan);
                if (resposta == 1) {
                    limparTela();
                    resposta = perguntaResposta(textFinalB, opAvan);
                    
                    if (resposta == 1) {
                        limparTela();
                        resposta = perguntaResposta("E voce. \n\n\n\n\n\n", opAvan);     
                    }
                }

                limparTela();

                if (resposta == 1) {
                    resposta = perguntaResposta(textFinalC, respOp);

                    switch (resposta) {
                        case 1:
                            limparTela();
                            resposta = perguntaResposta(cartaMerlinA + "\n\n\n\n", opAvan);

                            if (resposta == 1) {
                                limparTela();
                                resposta = perguntaResposta(cartaMerlinB + "\n\n\n\n", opAvan);

                                if( resposta == 1) {
                                    limparTela();
                                    System.out.println("E o silencio se formou.");

                                    break;
                                }
                            }

                            break;


                        case 2:
                            limparTela();
                            System.out.println("E o silencio se formou.");
                            break;
                    }


                }


            } while (voltar == 0);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
