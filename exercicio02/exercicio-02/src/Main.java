public class Main {
    public static void main(String[] args) {
        Personagem[] inimigos = {
                new Personagem("Orc", 100, 10),
                new Personagem("Goblin", 50, 5),
                new Personagem("Lobo", 75, 15),
                new Personagem("Cavaleiro", 200, 20),
                new Personagem("Dragão", 500, 50)
        };

        Personagem jogador = new Personagem("Steve", 100, 20);

        jogador.atacar(inimigos[2]);

        for (Personagem inimigo : inimigos) {
            inimigo.atacar(jogador);
        }
    }
}