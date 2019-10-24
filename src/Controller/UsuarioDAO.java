package Controller;

import Model.Cidade;
import Model.Usuario;
import java.util.List;

public class UsuarioDAO extends DAO<Usuario>{
    public List<Usuario> getAll(){
        return super.getAll(
        "select u from Usuario u order by u.nome");
    }
    public List<Usuario> getAll(String filtro){
        return super.getAll(
        "select u from Usuario u where u.nome like ?1 "
      + "order by u.nome",
        "%"+filtro.toUpperCase()+"%");
        
    }
    public List<Usuario> getAll(Cidade cidade){
        return super.getAll(
        "select u from Usuario u where u.cidade = ?1 " +
        "order by u.nome",cidade);
    }
}
