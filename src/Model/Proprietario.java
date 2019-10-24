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
@Table(name = "PROPRIETARIOS")

public class Proprietario implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    //
    @Column(name = "NOME", length = 100, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    //
    @Column(name = "TELEFONE", length = 15)
    private String telefone;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @SwingColumn(description = "Cidade")
    @JoinColumn(name = "ID_CIDADE", nullable = false,referencedColumnName = "id")
    private Cidade cidade;
    //
    public Proprietario(){
        
    }
    //
    public Proprietario(int id,String nome,String telefone,Cidade cidade){
        this.setId(id);
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setCidade(cidade);
    }
    //
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty()?"PADRÃO":nome.toUpperCase();
    }
    public void setTelefone(String telefone){
        this.telefone=telefone;
    }
    public void setCidade(Cidade cidade){
        this.cidade = cidade;
    }
    //
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public Cidade getCidade(){
        return this.cidade;
    }
    //
    public String toString(){
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
        final Proprietario other = (Proprietario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
