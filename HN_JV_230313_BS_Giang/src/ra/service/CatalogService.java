package ra.service;

import ra.model.Catalog;

import java.util.ArrayList;
import java.util.List;



public class CatalogService implements IService{
    static List<Catalog> catalogs;
    public CatalogService() {
        catalogs= new ArrayList<>();
    }
    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public Object findById(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }
    public Catalog findById(int id){
        for (Catalog cata: catalogs) {
            if(cata.getCatalogId() == id){
                // tìm thấy
                return cata;
            }
        }
        // không tìm thấy
        return null;
    }
    public List<Catalog> getAllCatalogs() {
        return catalogs;
    }
    public int getSize() {
        return catalogs.size();
    }
    public void save(Catalog catalog){
        if(findById(catalog.getCatalogId())==null){
            // chức năng thêm mới
            catalogs.add(catalog);
        }else {
            // update
            catalogs.set(catalogs.indexOf(findById(catalog.getCatalogId())),catalog);
        }
    }
    public  void deleteCata(int idDel){
        if(findById(idDel) == null){
            // không ton tại
            System.err.println("ID không tồn tại");
            return;
        }
        // cho phép xóa
        catalogs.remove(findById(idDel));
    }
}
