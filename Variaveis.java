public class Variaveis {

    public static String opcoesTextoCenaUm [][] = {
        {"O jogador acorda em um quarto escuro, onde a única fonte de luz é uma lamparina que está ao lado dele, ele a pega para iluminar mais o local, junto a ela havia uma chave. Em um dos cantos desse quarto, ele observa algo escondido por um pano o cobrindo e ao norte há uma porta fechada. /n O que você deseja fazer?"},
        {"Chave", "Você pegou a chave. (Objeto obtido: chave da porta)."},
        {"Canto", "Ele vai até o canto onde ele viu algo e tira o pano de cima, revelando uma caixa pequena de madeira."},
        {"ACaixa", "Ele abre a caixa, dentro ele encontra um papel com direções escritas em uma ordem: “esquerda-direita-direita-esquerda-direita” e logo em seguida está escrito: “Não se perca.”. /n Você obteve um papel com direções! "},
        {"Porta", "Ele abre a porta e da direto com um corredor sem qualquer iluminação somente com a pouca luz de sua lamparina. Quando o jogador ultrapassa a porta, ela se fecha com força não o deixando voltar, ele se encontra sem escolhas a não ser continuar seguindo. Mais à frente o jogador se depara com dois caminhos com algo escrito na parede entre eles, “Não se perca.” /n Para que lado você quer ir?"}
    };

    public static String opçõesRespostaCenaUm[][] = {
        {"Voltar"},
        {"Pegar chave", "Ir até canto do quarto", "Ir até e abrir a porta"},
        {"Abrir caixa"},
        {"Esquerda", "Direita"}
    };
}
