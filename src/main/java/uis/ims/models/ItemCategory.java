package uis.ims.models;

public class ItemCategory {

    public int CategoryID;

    public String CategoryDescription;

    public ItemCategory(int categoryID, String categoryDescription){
        this.CategoryID = categoryID;
        this.CategoryDescription = categoryDescription;
    }

    public ItemCategory(String categoryDescription){
        this.CategoryDescription = categoryDescription;
    }

}
