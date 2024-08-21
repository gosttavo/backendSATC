public class Personagem {
    public String nome;
    public int vida;
    public int ataque;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public void atacar(Personagem alvo) {
        System.out.println(this.nome + " atacou " + alvo.nome + "!\n");

        if (alvo.vida == 0) {
            System.out.println("Ataque falhou!\n");
            return;
        }

        alvo.receberDano(this.ataque);
    }

    public void receberDano(int dano) {
        this.vida = this.vida - dano;

        if (this.vida <= 0) {
            this.vida = 0;
            System.out.println(this.nome + " foi derrotado!\n");
        }
    }
}
