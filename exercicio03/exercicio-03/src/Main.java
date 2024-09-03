public class Main {
    public static void main(String[] args) {
        Barco[] barcosList = {
                new Barco("Barco 1", 2),
                new Barco("Barco 2", 5),
                new Barco("Barco 3", 7),
                new Barco("Barco 4", 12),
                new Barco("Barco 5", 20),
        };

        PortoGrande portoGrande = new PortoGrande("Grande");
        PortoPequeno portoPequeno = new PortoPequeno("Pequeno");

        for (Barco idx : barcosList) {
            if (!portoPequeno.atracarBarco(idx)) {
                portoGrande.atracarBarco(idx);
            }
        }
    }
}