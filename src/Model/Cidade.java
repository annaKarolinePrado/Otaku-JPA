
package Model;

import Enums.Sigla;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CIDADES")

public class Cidade implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private int id;
    //
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;
    //
    @Enumerated(EnumType.STRING)
    @Column(name = "SIGLA", length = 2, nullable = false)
    private Sigla sigla;
    //
    public Cidade(){        
    }
    public Cidade(int id,String nome,Sigla sigla){
        this.setId(id);
        this.setNome(nome);
        this.setSigla(sigla);
    }
    //
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty()?"PADRÃO":nome.toUpperCase();
    }
    public void setSigla(Sigla sigla){
        this.sigla = sigla == null ? Sigla.SC : sigla;
    }    
    //
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    };
    public Sigla getSigla(){
        return this.sigla;
    }
    //
    @Override
    public String toString(){
        return this.nome;
    }
    //
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
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
        final Cidade other = (Cidade) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
