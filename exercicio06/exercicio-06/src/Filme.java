public class Filme {
    private String nome;
    private int idadeMinima;
    private double preco;

    public Filme() {}

    public Filme(String nome, int idadeMinima, double preco) {
        this.nome = nome;
        this.idadeMinima = idadeMinima;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }

    public double getPreco() {
        return preco;
    }
}
