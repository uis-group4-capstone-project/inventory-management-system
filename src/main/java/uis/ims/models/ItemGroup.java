package uis.ims.models;

public class ItemGroup {
    private int ItemGroupID;

    public String GroupName;

    public String GroupDescription;

    public ItemGroup(int itemGroupID, String groupName, String groupDescription){
        this.ItemGroupID = itemGroupID;
        this.GroupName = groupName;
        this.GroupDescription = groupDescription;

    }

    public ItemGroup(String groupName, String groupDescription){
        this.GroupName = groupName;
        this.GroupDescription = groupDescription;
    }
}
