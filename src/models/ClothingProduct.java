package models;

public class ClothingProduct extends Product {
    private String size;
    private String colour;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        String output = super.toString() +
                "Size: " + size + "\n" +
                "Colour: " + colour + "\n\n";
        return output;
    }
}
