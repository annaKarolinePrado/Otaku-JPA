
package Manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


abstract public class Dados {
    //criar objeto EntityManager
    private static EntityManager entity = null;
    
    public static EntityManager getEntity(){
        //localização do arquivo de configuração
        if (entity == null){
            EntityManagerFactory factory =  
            Persistence.createEntityManagerFactory("OtakuPU");
            entity = factory.createEntityManager();
        }
        //criar sessão para persistir objetos
        return entity;
    }
    
    
}
