
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
@Table(name = "CONTA")
public class Conta implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "NOME", length = 100, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PLANO", nullable = false,referencedColumnName = "ID")
    //@SwingColumn(description = "Plano")
    private  Plano plano ;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USUARIO", nullable = false,referencedColumnName = "ID")
    //@SwingColumn(description = "Usuario")
    private Usuario usuario;
    //
    public Conta(){
        
    }  
    public Conta(int id,String nome,Plano plano,Usuario usuario){
        this.setId(id);
        this.setNome(nome);
        this.setPlano(plano);
        this.setUsuario(usuario);
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
    
    public Plano getPlano() {
        return this.plano;
    }
    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   
    //

    @Override
    public String toString() {
        return this.nome;
    }
    //
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
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
        final Conta other = (Conta) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
