
package Controller;

import Model.Cidade;
import Model.Proprietario;
import java.util.List;
import java.util.List;

public class ProprietarioDAO extends DAO<Proprietario>{
    public List<Proprietario> getAll(){
        return super.getAll(
        "select p from Proprietario p order by p.nome");
    }
    public List<Proprietario> getAll(String filtro){
        return super.getAll(
        "select p from Proprietario p where p.nome like ?1 "
      + "order by p.nome",
        "%"+filtro.toUpperCase()+"%");
        
    }
    public List<Proprietario> getAll(Cidade cidade){
        return super.getAll(
        "select p from Proprietario p where p.cidade = ?1 " +
        "order by p.nome",cidade);
    }
}
