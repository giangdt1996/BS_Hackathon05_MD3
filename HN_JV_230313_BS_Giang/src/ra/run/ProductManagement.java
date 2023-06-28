package ra.run;

import ra.config.InputMethod;
import ra.model.Catalog;
import ra.model.Product;
import ra.service.CatalogService;
import ra.service.ProductService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductManagement {


    private static CatalogService catalogService = new CatalogService();
    private static ProductService productService = new ProductService();
    static List<Catalog> catalogs = catalogService.getAllCatalogs();
    static List<Product> products = productService.getAllProducts();
    public static void main(String[] args) {
        while(true){
        System.out.println("**************************BASIC-MENU**************************\n" +
                "1. Quản lý danh mục \n" +
                "2. Quản lý sản phẩm\n" +
                "3. Thoát");
            System.out.println("Nhap vao lua chon cua ban");
            int choice = InputMethod.getInteger();
            switch (choice) {
                case 1:
    boolean back = true;
                    while(back){
                        System.out.println("********************CATALOG-MANAGEMENT********************\n"+
                                "1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục \n" +
                                "2. Hiển thị thông tin tất cả các danh mục\n" +
                                "3. Sửa tên danh mục theo mã danh mục\n" +
                                "4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm)\n"+
                                "5. Quay lại");
                        int choice2 = InputMethod.getInteger();
                        switch (choice2){
                            case 1:
                                addNewCatalog();
                                System.out.println("Them moi thanh cong");
                                break;
                                case 2:
                                    System.out.println("Cac danh muc da co la:");
                                    showListCatalog();
                                break;
                                case 3:
                                    editCatalogInfo();
                                break;
                                case 4:
                                    deleteCatalog();
                                break;
                                case 5:
                                    back = false;
                                break;
                        }
                        break;
                    }
                    break;
                case 2:
                boolean back2 =true;
                    while(back2){
                        System.out.println("********************PRODUCT-MANAGEMENT********************\n" +
                                "1. Nhập số sản sản phẩm và nhập thông tin sản phẩm \n"+
                                "2. Hiển thị thông tin các sản phẩm\n" +
                                "3. Sắp xếp sản phẩm theo giá giảm dần\n" +
                                "4. Xóa sản phẩm theo mã\n" +
                                "5. Tìm kiếm sách theo tên sách\n" +
                                "6. Thay đổi thông tin của sách theo mã sách\n" +
                                "7. Quay lại");
                        int choice3 = InputMethod.getInteger();
                        switch (choice3){
                            case 1:
                                addNewProduct();
                                System.out.println("Them moi thanh cong");

                                break;
                            case 2:
                                showListProduct();

                                break;
                            case 3:
                               products.sort(Comparator.comparingDouble(Product::getProductPrice).reversed());;
                                for (Product product : products) {
                                    System.out.println(product);
                                }
                                break;
                            case 4:
                                deleteProduct();
                                break;
                            case 5:
                                searchProduct();
                                break;
                                case 6:
                                    editProduct();
                                break;
                                case 7:
                                    back2=false;
                                break;
                        }
                        break;
                    }

                    break;
                case 3:
                    System.exit(0);
              break;

                default:
                    System.err.println("Không hợp lệ");
            }
        }
    }
    public static void addNewCatalog() {
        System.out.println("Nhập số danh mục cần thêm mới");
        int so = InputMethod.getInteger();
        for (int i = 0; i < so; i++) {
            System.out.println("Nhập thông tun cho danh mục thứ " + (i + 1));
            Catalog catalog = new Catalog();
            catalog.inputData();
            catalogs.add(catalog);
            catalogService.save(catalog);
        }
    }
    public static void addNewProduct() {
        System.out.println("Nhập số san pham cần thêm mới");
        int so = InputMethod.getInteger();
        for (int i = 0; i < so; i++) {
            System.out.println("Nhập thông tin cho san pham thứ " + (i + 1));
            Product product = new Product();
            product.inputData(catalogs);
            products.add(product);


        }
    }
    public static void showListCatalog() {
        if (catalogService.getSize() == 0) {
            System.err.println("Không có danh muc nào ");
            return;
        }

        for (Catalog cata : catalogs
        ) {
            System.out.println(cata.toString());
    }}
    public static void editProduct() {
        System.out.println("Nhập vào id cần sửa");
        String idEdit = InputMethod.getString();
        Product editPro = productService.findById(idEdit);

        if(editPro ==null){
            System.err.println("Không tìm thấy product ");
            return;
        }
        editPro.inputData(catalogs);
        productService.save(editPro);
        System.out.println("Sua thanh cong");
    }
    public static void deleteProduct(){
        System.out.println("nhập vào id cần xóa ");
        String idDel = InputMethod.getString();
        productService.deletePro(idDel);
        System.out.println("Xoa thanh cong");
    }



    public static void showListProduct() {
        if (productService.getSize() == 0) {
            System.err.println("Không có san pham nào ");
            return;
        }

        for (Product pro : products
        ) {
            System.out.println(pro.toString());
        }
    }
    public static void editCatalogInfo() {
        System.out.println("Nhập vào id cần sửa");
        int idEdit = InputMethod.getInteger();
        Catalog editCata = catalogService.findById(idEdit);

        if(editCata ==null){
            System.err.println("Không tìm thấy catalog ");
            return;
        }
        editCata.inputData();
        catalogService.save(editCata);
        System.out.println("Sua thanh cong");
    }
    public static void deleteCatalog(){
        System.out.println("nhập vào id cần xóa ");
        int idDel = InputMethod.getInteger();
        catalogService.deleteCata(idDel);
        System.out.println("Xoa thanh cong");
    }
    public static void searchProduct(){

        boolean check =  false;
        System.out.println("Nhap vao ten san phham can tim");
        String productName = InputMethod.getString();
        for (Product pro: products) {
            if(pro.getProductName().toLowerCase().contains(productName.toLowerCase())){
                System.out.println(pro.toString());;
                check= true;
            }
        }
        if (!check){
            System.err.println("Khong tim thay san pham thoa man");
        }
    }
    }

