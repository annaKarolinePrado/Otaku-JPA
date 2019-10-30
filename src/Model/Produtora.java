package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTORA")
public class Produtora implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "NOME", length = 100, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    // 
    public Produtora(){
        
    }
    public Produtora(int id, String nome){
        this.setId(id);
        this.setNome(nome);
    }
    //
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "" : nome.toUpperCase();
    }
    //
    @Override
    public String toString() {
        return this.nome;
    }
    //
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produtora other = (Produtora) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }   
}
