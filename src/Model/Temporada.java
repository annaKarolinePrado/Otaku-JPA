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
@Table(name = "TEMPORADA")
public class Temporada implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "NOME", length = 100, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_SERIE", nullable = false,referencedColumnName = "ID")
    //@SwingColumn(description = "Serie")
    private Serie serie;
    
    private int sequencial;
    //CONSTRUTOR
    public Temporada(){
        
    }
    public Temporada(int id, String nome, Serie serie, int sequencial){
        this.setId(id);
        this.setNome(nome);
        this.setSerie(serie);
        this.setSequencial(sequencial);
    }
    //GET AND SET
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome(){
        return this.nome;
    };
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty()?"PADRÃO":nome.toUpperCase();
    }

    public Serie getSerie() {
        return serie;
    }
    public void setSerie(Serie serie) {
        this.serie = serie ==  null ? new Serie() : serie;
    }

    public int getSequencial() {
        return sequencial;
    }
    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }
    //TO STRING
    @Override
    public String toString() {
        return this.nome;
    }
    //
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
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
        final Temporada other = (Temporada) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }    
}
