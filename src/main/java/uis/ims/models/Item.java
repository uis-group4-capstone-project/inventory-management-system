package uis.ims.models;

import java.util.Currency;

public class Item {
    private int ItemID;

    public String Name;

    public String Description;

    public String upcSerialNumber;

    public double Cost;

    public int Quantity;

    public int minQuantity;

    public int LocationID;

    public int ItemGroupID;

    public Item(int id, String name, String description, String upcSerialNumber, double cost, int quantity, int minQuantity, int location, int itemGroup ){
        this.ItemID = id;
        this.Name = name;
        this.Description = description;
        this.upcSerialNumber = upcSerialNumber;
        this.Cost = cost;
        this.Quantity = quantity;
        this.minQuantity = minQuantity;
        this.LocationID = location;
        this.ItemGroupID = itemGroup;
    }

    public int getItemID(){
        return this.ItemID;
    }
}
