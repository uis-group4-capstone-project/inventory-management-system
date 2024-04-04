package uis.ims.dbschema;

public class DBTables {
    public static final String[] TABLE_NAMES = {"WAREHOUSE","STORAGE_LOCATION", "CATEGORY", "ITEM","ITEM_GROUP" };



    private static final String CREATE_ITEM_TABLE = """
            CREATE TABLE Item
            (
                ItemID INT PRIMARY KEY IDENTITY(1,1),
                Name VARCHAR(100),
                Description VARCHAR(MAX),
                CategoryID VARCHAR(15) FOREIGN KEY REFERENCES CATEGORY(CategoryID),
                upsSerialNumber VARCHAR(12),
                MinQuantity INT,
                MaxQuantity INT,
                Cost MONEY
            )
            """;
    private static final String CREATE_CATEGORY_TABLE = """
            CREATE TABLE Category
            (
                CategoryID INT PRIMARY KEY IDENTITY(1,1),
                Description VARCHAR(100)
            )
            """;

    private static final String CREATE_STORAGE_LOCATION_TABLE = """
            CREATE TABLE Storage_Location
            (
                StorageLocationID INT PRIMARY KEY IDENTITY(1,1),
                WarehouseID INT FOREIGN KEY REFERENCES Warehouse(WarehouseID),
                LocationDescription VARCHAR(100)
            )
            """;

    private static final String CREATE_WAREHOUSE_TABLE = """
            CREATE TABLE Warehouse
            (
                WarehouseID INT PRIMARY KEY IDENTITY(1,1),
                Name VARCHAR(25),
                StreetAddress VARCHAR(50),
                State VARCHAR(2)
            )
            """;

    public static String getCreateCategoryTableQuery() {
        return CREATE_CATEGORY_TABLE;
    }

    public static String getCreateItemTableQuery() {
        return CREATE_ITEM_TABLE;
    }

    public static String getCreateStorageLocationTableQuery() {
        return CREATE_STORAGE_LOCATION_TABLE;
    }

    public static String getCreateWarehouseTableQuery() {
        return CREATE_WAREHOUSE_TABLE;
    }
}
