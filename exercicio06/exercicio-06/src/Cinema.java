import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Filme> filmesDisponiveis = new ArrayList<>();
    private List<Ingresso> ingressosVendidos = new ArrayList<>();
    private List<String> assentosDisponiveis = new ArrayList<>();

    public Cinema() {
        for (char fila = 'A'; fila <= 'F'; fila++) {
            for (int numero = 1; numero <= 5; numero++) {
                assentosDisponiveis.add(fila + String.valueOf(numero));
            }
        }
    }

    public List<Filme> getFilmesDisponiveis() {
        return filmesDisponiveis;
    }

    public void setFilme(Filme filme) {
        this.filmesDisponiveis.add(filme);
    }

    public List<String> getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void venderIngresso(Ingresso ingresso) throws Exception {
        if (!assentosDisponiveis.contains(ingresso.getAssento())) {
            throw new Exception("\nAssento não disponível");
        }

        if (ingresso.getCliente().getIdade() < ingresso.getFilme().getIdadeMinima()) {
            throw new Exception("\nIdade mínima incompatível");
        }

        assentosDisponiveis.remove(ingresso.getAssento());
        ingressosVendidos.add(ingresso);
    }
}
