
package Controller;

import Model.Categoria;

import java.util.List;
import java.util.List;

public class CategoriaDAO extends DAO<Categoria>{
    public List<Categoria> getAll(){
        return super.getAll(
        "select p from Categoria p order by p.nome");
    }
    public List<Categoria> getAll(String filtro){
        return super.getAll(
        "select p from Categoria p where p.nome like ?1 "
      + "order by p.nome",
        "%"+filtro.toUpperCase()+"%");
        
    }
}
