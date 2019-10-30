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
@Table(name = "CARTAO")
public class Cartao implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "TITULAR", length = 100, nullable = false)
    @SwingColumn(description = "Titular")
    private String titular;
    
    private int numero;
    private int chaveSeguranca;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USUARIO", nullable = false,referencedColumnName = "ID")
    //@SwingColumn(description = "Usuario")
    private Usuario usuario;
    //CONSTRUTOR
    public Cartao(){
        
    }
    public Cartao(int id, String titular, int numero, int chaveSeguranca, Usuario usuario){
        this.setId(id);
        this.setTitular(titular);
        this.setChaveSeguranca(chaveSeguranca);
        this.setUsuario(usuario);
    }
    //GET E SET
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitular() {
        return this.titular;
    }
    public void setTitular(String titular) {
        this.titular = titular.trim().isEmpty() ? "" : titular.toUpperCase();
    }

    public int getNumero() {
        return this.numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getChaveSeguranca() {
        return this.chaveSeguranca;
    }
    public void setChaveSeguranca(int chaveSeguranca) {
        this.chaveSeguranca = chaveSeguranca;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    //TO STRING
    @Override
    public String toString() {
        return this.titular;
    }
    //EQUALS E HASHCODE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
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
        final Cartao other = (Cartao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }    
}
