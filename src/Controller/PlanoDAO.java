package Controller;

import Model.Plano;

import java.util.List;

public class PlanoDAO extends DAO<Plano>{
    public List<Plano> getAll(){
        return super.getAll(
        "select p from Plano p order by p.descricao");
    }
    public List<Plano> getAll(String filtro){
        return super.getAll(
        "select p from Plano p where p.descricao like ?1 "
      + "order by p.descricao",
        "%"+filtro.toUpperCase()+"%");
        
    }
}
