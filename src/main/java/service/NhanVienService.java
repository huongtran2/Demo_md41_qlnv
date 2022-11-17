package service;

import model.NhanVienModel;

import java.util.ArrayList;
import java.util.List;

public class NhanVienService {
    public static List<NhanVienModel> nhanVienModels = new ArrayList<>();

    static {
        nhanVienModels.add(new NhanVienModel(1,"huong",17,"ha noi","0933686363"));
        nhanVienModels.add(new NhanVienModel(2,"huong",18,"ha noi","0933686363"));
    }
    public static int findIndexById(int id){
        for (int i = 0; i < nhanVienModels.size(); i++) {
            if(nhanVienModels.get(i).getId()==id){
                return i;
            }
        }return -1;
    }
    public static void add(NhanVienModel nhanVienModel){
        nhanVienModels.add(nhanVienModel);
    }
    public static  void  edit(int id, NhanVienModel nhanVienModel){
        int index = findIndexById(id);
        if(index !=-1){
            nhanVienModels.set(index,nhanVienModel);
        }
    }
    public static  void  delete(int id){
            nhanVienModels.remove(id);
    }
    public static NhanVienModel getNhanVienModel(int id){
        return nhanVienModels.get(findIndexById(id));
    }
}
