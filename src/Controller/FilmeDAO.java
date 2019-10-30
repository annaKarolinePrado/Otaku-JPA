package Controller;

import Model.Filme;

import java.util.List;

public class FilmeDAO extends DAO<Filme>{
    public List<Filme> getAll(){
        return super.getAll(
        "select c from Filme c order by c.nome");
    }
    public List<Filme> getAll(String filtro){
        return super.getAll(
        "select c from Filme c where c.nome like ?1 "
      + "order by c.nome",
        "%"+filtro.toUpperCase()+"%");
        
    }
}
