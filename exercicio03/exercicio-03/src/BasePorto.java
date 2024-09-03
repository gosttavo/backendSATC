import java.util.ArrayList;

public class BasePorto {
    public String nome;
    public ArrayList<Barco> barcosAtracados;

    public BasePorto(String nome) {
        this.nome = nome;
        this.barcosAtracados = new ArrayList<>();
    }

    public boolean atracarBarco (Barco barco) {
        this.barcosAtracados.add(barco);
        return true;
    }

    public boolean desatracarBarco (Barco barco) {
        if (this.barcosAtracados.contains(barco)) {
            this.barcosAtracados.remove(barco);
            return true;
        }

        System.out.println("Barco não encontrado!\n");
        return false;
    }
}
