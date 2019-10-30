package Controller;

import Model.Serie;

import java.util.List;

public class SerieDAO extends DAO<Serie>{
    public List<Serie> getAll(){
        return super.getAll(
        "select s from Serie s order by s.nome");
    }
    public List<Serie> getAll(String filtro){
        return super.getAll(
        "select s from Serie s where s.nome like ?1 "
      + "order by s.nome",
        "%"+filtro.toUpperCase()+"%");
        
    }
}
