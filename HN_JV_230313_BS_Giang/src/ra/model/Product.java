package ra.model;

import ra.config.InputMethod;

import java.util.List;

public class Product {
    private String productId;
    private String productName;
    double productPrice;
    private String description;
    private int stock;
    private Catalog catalog;
   private boolean status;

    public Product() {
    }

    public Product(String productId, String producName, double productPrice, String description, int stock, Catalog catalog, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.stock = stock;
        this.catalog = catalog;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String producName) {
        this.productName = producName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", producName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", catalog=" + catalog +
                ", status=" + (status?"Bán":"Không bán") +
                '}';
    }
    public void inputData(List<Catalog> catalogs){
        boolean check = true;

        while (check) {
            System.out.println("Nhap Id (ex: P0001)");
            this.productId = InputMethod.getString();

            if (this.productId.length() != 5 || this.productId.charAt(0) != 'P' || getProductId().contains(this.productId)) {
                System.out.println("Id ban nhap da trung hoac khong dung cu phap. Vui long nhap lai.");
            } else {
                check = false;
            }
        }
        System.out.println("Nhap Name");
        this.productName = InputMethod.getString();
        System.out.println("Nhap gia");
        this.productPrice = InputMethod.getDouble();
        System.out.println("Nhap description");

        this.description = InputMethod.getString();
        System.out.println("Nhap stock");
        this.stock = InputMethod.getInteger();

        for (Catalog cata: catalogs) {
            cata.toString();
        }

        while (true){
            boolean flag = false;
            System.out.println("Nhap catalog theo id");
            int catalogId = InputMethod.getInteger();
            for (Catalog cata: catalogs) {
                if(cata.getCatalogId()==catalogId){
                    this.catalog=cata;
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
            System.err.println("Id not found");
        }
        System.out.println("Nhap trang thai (true: Ban / false:Khong ban");
        this.status = InputMethod.getBoolean();

    }
}
