import java.util.ArrayList;

public class PortoGrande extends BasePorto {

    public PortoGrande(String nome) {
        super(nome);
    }

    public boolean atracarBarco(Barco barco) {
        if (barco.tamanho < 10) {
            System.out.println("Barco muito pequeno para atracar nesse porto!\n");
            return false;
        }

        super.atracarBarco(barco);
        System.out.println("Barco atracado no porto grande!\n");
        System.out.println("Lista de barcos atracados: " + this.barcosAtracados + ". \n");
        return true;
    }
}
