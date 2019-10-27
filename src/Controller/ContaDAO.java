package Controller;

import Model.Conta;

import java.util.List;

public class ContaDAO extends DAO<Conta>{
    public List<Conta> getAll(){
        return super.getAll(
        "select c from Conta c order by c.nome");
    }
    public List<Conta> getAll(String filtro){
        return super.getAll(
        "select c from Conta c where c.nome like ?1 "
      + "order by c.nome",
        "%"+filtro.toUpperCase()+"%");
        
    }
}
