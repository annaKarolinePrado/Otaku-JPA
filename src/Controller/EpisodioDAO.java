
package Controller;

import Model.Episodio;
import java.util.List;

public class EpisodioDAO extends DAO<Episodio>{
    public List<Episodio> getAll(){
        return super.getAll(
        "select e from Episodio e order by e.nome");
    }
    public List<Episodio> getAll(String filtro){
        return super.getAll(
        "select e from Episodio e where e.nome like ?1 "
      + "order by e.nome",
        "%"+filtro.toUpperCase()+"%");
        
    }
}
