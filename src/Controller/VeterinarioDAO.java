
package Controller;

import Model.Cidade;
import Model.Veterinario;
import java.util.List;
import javax.persistence.Query;

public class VeterinarioDAO extends DAO<Veterinario>{
    public List<Veterinario> getVeterinarioList(){
        return super.getAll("select v from Veterinario v order by v.nome");
    }
    public List<Veterinario> getVeterinarioList(String filtro){
        return super.getAll(
        "select v from Veterinario v where v.nome like ?1 order by v.nome",
        "%"+filtro.toUpperCase()+"%"
        );
    }
    public List<Veterinario> getVeterinarioList(Cidade cidade){
        return super.getAll(
        "select v from Veterinario v where v.cidade=?1 order by v.cidade.nome",
        cidade);
    }
}
