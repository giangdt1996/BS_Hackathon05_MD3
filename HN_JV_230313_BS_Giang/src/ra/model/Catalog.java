package ra.model;

import ra.config.InputMethod;

public class Catalog {
   private int catalogId;
   private String catalogName;

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }


    public String toString() {
        return "Catalog{" +
                "catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                '}';
    }
    public void inputData(){
        System.out.println("Nhap ID cho catalog");
        this.catalogId = InputMethod.getInteger();
        System.out.println("Nhap ten cho catalog");
        this.catalogName = InputMethod.getString();
    }
}
