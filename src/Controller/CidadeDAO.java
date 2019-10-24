
package Controller;

import Model.Cidade;
import java.util.List;

public class CidadeDAO extends DAO<Cidade>{
    public List<Cidade> getAll(){
        return super.getAll("select c from Cidade c order by c.nome");
    }
    public List<Cidade> getAll(String filtro){
        return super.getAll(
                "select c from Cidade c where c.nome like ?1 order by c.nome",
                "%"+filtro.toUpperCase()+"%");
    }
}
