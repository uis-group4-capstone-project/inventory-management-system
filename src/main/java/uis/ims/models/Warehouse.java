package uis.ims.models;

public class Warehouse {
    private int WarehouseID;

    public String Name;
    public String StreetAddress;

    public String State;

    public Warehouse(int ID, String name, String streetAddress, String state){
        this.WarehouseID = ID;
        this.Name = name;
        this.StreetAddress = streetAddress;
        this.State = state;
    }

    public Warehouse(String name, String streetAddress, String state){
        this.Name = name;
        this.StreetAddress = streetAddress;
        this.State = state;
    }

}
