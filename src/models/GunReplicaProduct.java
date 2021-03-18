package models;

public class GunReplicaProduct extends Product {
    private double calibre;
    private String material;

    public double getCalibre() {
        return calibre;
    }

    public void setCalibre(double calibre) {
        this.calibre = calibre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        String output = super.toString() +
                "Calibre: " + calibre + "\n" +
                "Material: " + material + "\n\n";
        return output;
    }
}
