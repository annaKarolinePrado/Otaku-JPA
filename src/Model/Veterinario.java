
package Model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VETERINARIOS")

public class Veterinario implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    //
    @Column(name = "NOME", length = 100, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    //
    @Column(name = "TELEFONE",length = 15, nullable = false)
    private String telefone;
    //
    @Column(name = "NASCIMENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    //
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CIDADE", nullable = false,referencedColumnName = "ID")
    @SwingColumn(description = "Cidade")
    private Cidade cidade;
    //
    public Veterinario(){
        
    }
    public Veterinario(int id,String nome,String telefone,
                       Date nascimento, Cidade cidade){
        this.setId(id);
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setNascimento(nascimento);
        this.setCidade(cidade);        
    }
    //
    public void setId(int id){
        this.id=id;
    }
    public void setNome(String nome){
        this.nome=nome.trim().isEmpty()?"PADRÃO":nome.toUpperCase();
    }
    public void setTelefone(String telefone){
        this.telefone = telefone.trim().isEmpty()?"(00)00000-0000":telefone;
    }
    public void setNascimento(Date nascimento){
        this.nascimento = nascimento==null?new Date():nascimento;
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
    public Date getNascimento(){
        return this.nascimento;
    }
    public Cidade getCidade(){
        return cidade;
    }
    //
    @Override
    public String toString(){
        return this.nome;
    }
    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Veterinario other = (Veterinario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
