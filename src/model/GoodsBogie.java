package model;

/**
 * Model class representing a Goods Bogie.
 * Contains type and cargo to enforce safety rules.
 */
public class GoodsBogie {

    private String type;   // e.g., "Cylindrical", "Box", "Flat"
    private String cargo;  // e.g., "Petroleum", "Coal"

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return type + " bogie carrying " + cargo;
    }
}