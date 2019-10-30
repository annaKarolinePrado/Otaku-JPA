
package Controller;

import Model.Produtora;

import java.util.List;
import java.util.List;

public class ProdutoraDAO extends DAO<Produtora>{
    public List<Produtora> getAll(){
        return super.getAll(
        "select p from Produtora p order by p.nome");
    }
    public List<Produtora> getAll(String filtro){
        return super.getAll(
        "select p from Produtora p where p.nome like ?1 "
      + "order by p.nome",
        "%"+filtro.toUpperCase()+"%");
        
    }
}
