package Controller;

import Model.Cartao;

import java.util.List;

public class CartaoDAO extends DAO<Cartao>{
    public List<Cartao> getAll(){
        return super.getAll(
        "select c from Cartao c order by c.titular");
    }
    public List<Cartao> getAll(String filtro){
        return super.getAll(
        "select c from Cartao c where c.titular like ?1 "
      + "order by c.titular",
        "%"+filtro.toUpperCase()+"%");
        
    }
}
