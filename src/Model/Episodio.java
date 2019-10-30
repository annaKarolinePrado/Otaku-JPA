package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EPISODIO")
public class Episodio implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "NOME", length = 100, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TEMPORADA", nullable = false,referencedColumnName = "ID")
    private Temporada temporada;
    //CONSTRUTOR
    public Episodio(){
        
    }
    public Episodio(int id, String nome, Temporada temporada){
        this.setId(id);
        this.setNome(nome);
        this.setTemporada(temporada);
    }
    //GET AND SET

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
        this.nome = nome;
    }

    public Temporada getTemporada() {
        return this.temporada;
    }
    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }
    //TO STRING
    @Override
    public String toString() {
        return this.nome;
    }
    //
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
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
        final Episodio other = (Episodio) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    } 
}
