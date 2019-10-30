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
@Table(name = "COMENTARIO")
public class Comentario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "DESCRICAO", length = 100, nullable = false)
    @SwingColumn(description = "Descricao")
    private String descricao;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USUARIO", nullable = false,referencedColumnName = "ID")
    private Usuario usuario;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_FILME", nullable = false,referencedColumnName = "ID")
    private Filme filme;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_SERIE", nullable = false,referencedColumnName = "ID")
    private Serie serie;
    //CONSTRUTOR
    public Comentario(){
        
    }
    public Comentario(int id, String descricao, Usuario usuario, Filme filme, Serie serie){
        this.setId(id);
        this.setDescricao(descricao);
        this.setUsuario(usuario);
        this.setFilme(filme);
        this.setSerie(serie);
    }
    //GET AND SET

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Filme getFilme() {
        return this.filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Serie getSerie() {
        return this.serie;
    }
    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    //TO STRING
    @Override
    public String toString() {
        return this.descricao;
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
        final Comentario other = (Comentario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    } 
}
