
package Controller;

import Manager.Dados;
import java.util.List;
import javax.persistence.Query;

abstract public class DAO<T> {
    public void add(T object){
        Dados.getEntity().getTransaction().begin();
        Dados.getEntity().persist(object);
        Dados.getEntity().getTransaction().commit();
    }
    public void update(T object){
        Dados.getEntity().getTransaction().begin();
        Dados.getEntity().merge(object);
        Dados.getEntity().getTransaction().commit();
    }
    public void remove(T object){
        Dados.getEntity().getTransaction().begin();
        Dados.getEntity().remove(object);
        Dados.getEntity().getTransaction().commit();
    }
    public T get(Class<T> classType,int id){
        return (Dados.getEntity().find(classType, id));
    } 
    public List<T> getAll(String HQL){
        Query query = Dados.getEntity().createQuery(HQL);
        return query.getResultList();
    }
    public List<T> getAll(String HQL,Object... args){
        Query query = Dados.getEntity().createQuery(HQL);
        for (int i=0; i < args.length; i++){
            query.setParameter((i+1), args[i]);
        }
        return query.getResultList();
    }
    
}
