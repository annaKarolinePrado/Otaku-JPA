
package Controller;

import Model.Raca;
import java.util.List;

public class RacaDAO extends DAO<Raca>{
    public List<Raca> getRacaList(){
        return super.getAll("select r from Raca r order by r.nome");
    }
    public List<Raca> getRacaList(String filtro){
        return super.getAll(
        "select r from Raca r where r.nome like ?1 order by r.nome", 
        "%"+filtro.toUpperCase()+"%");
    }
}
