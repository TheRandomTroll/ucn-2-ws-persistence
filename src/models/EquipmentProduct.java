package models;

public class EquipmentProduct extends Product {
    private String type;
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        String output = super.toString() +
                "Type: " + type + "\n" +
                "Description: " + description + "\n\n";
        return output;
    }
}
