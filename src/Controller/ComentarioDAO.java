
package Controller;

import Model.Comentario;

import java.util.List;
import java.util.List;

public class ComentarioDAO extends DAO<Comentario>{
    public List<Comentario> getAll(){
        return super.getAll(
        "select c from Comentario c order by c.nome");
    }
    public List<Comentario> getAll(String filtro){
        return super.getAll(
        "select c from Comentario c where c.nome like ?1 "
      + "order by c.nome",
        "%"+filtro.toUpperCase()+"%");
        
    }
}
