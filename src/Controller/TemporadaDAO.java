package Controller;

import Model.Temporada;

import java.util.List;

public class TemporadaDAO extends DAO<Temporada>{
    public List<Temporada> getAll(){
        return super.getAll(
        "select t from Temporada t order by t.nome");
    }
    public List<Temporada> getAll(String filtro){
        return super.getAll(
        "select t from Temporada t where t.nome like ?1 "
      + "order by t.nome",
        "%"+filtro.toUpperCase()+"%");
        
    }
}
