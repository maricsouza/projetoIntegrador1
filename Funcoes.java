import java.io.Console;
import java.util.Scanner;

public class Funcoes {

    Scanner scanner = new Scanner(System.in);
    public static Console console = System.console();


    public static void limparTela () {
        try {

            new ProcessBuilder("cmd", "/c" , "cls" ).inheritIO().start().waitFor();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void cenaUm () {

        boolean chave = false;

        System.out.println("O jogador acorda em um quarto escuro, onde a unica fonte de luz e uma lamparina que esta ao lado dele, ele a pega para iluminar mais o local, junto a ela havia uma chave. Em um dos cantos desse quarto, ele observa algo escondido por um pano o cobrindo e ao norte há uma porta fechada. /n O que voce deseja fazer?");
        System.out.println("1 - Pegar chave \n2 - Ir para o canto do quarto \n3 - Ir ate a porta e abrir");
        String resp = console.readLine();

        if (resp.equals("1")) {
            System.out.println("Voce pegou a chave. (Objeto obtido: chave da porta).");
            chave = true;
        } else if (resp.equals("2") ) {
            System.out.println("Ele vai ate o canto onde ele viu algo e tira o pano de cima, revelando uma caixa pequena de madeira. O que deseja fazer? \n1- Abrir a caixa \n2 - Voltar");
                resp = console.readLine();
                    if(resp.equals("1")) {
                        System.out.println("Ele abre a caixa, dentro ele encontra um papel com direcoes escritas em uma ordem: esquerda-direita-direita-esquerda-direita e logo em seguida esta escrito: Nao se perca. Voce obteve um papel com direcoes! ");
                    } else {
                        System.out.println("O jogador acorda em um quarto escuro, onde a unica fonte de luz e uma lamparina que esta ao lado dele, ele a pega para iluminar mais o local, junto a ela havia uma chave. Em um dos cantos desse quarto, ele observa algo escondido por um pano o cobrindo e ao norte ha uma porta fechada. /n O que voce deseja fazer?");
                    }
        } else {
            if (chave == true) {
                System.out.println("Ele abre a porta e da direto com um corredor sem qualquer iluminação somente com a pouca luz de sua lamparina. Quando o jogador ultrapassa a porta, ela se fecha com força não o deixando voltar, ele se encontra sem escolhas a não ser continuar seguindo. Mais à frente o jogador se depara com dois caminhos com algo escrito na parede entre eles, Não se perca. \nPara que lado você quer ir?");
            } else {
                System.out.println("A porta está trancada.");
            }
        }


    }
}
