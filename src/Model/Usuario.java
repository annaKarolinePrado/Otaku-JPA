
package Model;

import Enums.Perfil;
import Enums.Sexo;
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
@Table(name = "USUARIO")
public class Usuario implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "NOME", length = 100, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CIDADE", nullable = false,referencedColumnName = "ID")
    @SwingColumn(description = "Cidade")
    private Cidade cidade;
    
    @Column(name = "TELEFONE", length = 15)
    private String telefone;
    
    private String endereco;
    private int numero;
    private String bairro;
    private Sexo sexo;
    private Perfil perfil;
    //
    public Usuario(){
        
    }
    public Usuario(int id,String nome,Cidade cidade,String telefone, String endereco,int numero,String bairro,Sexo sexo,Perfil perfil){
        this.setId(id);
        this.setNome(nome);
        this.setCidade(cidade);        
        this.setTelefone(telefone);
        this.setBairro(bairro);
        this.setEndereco(endereco);
        this.setNumero(numero);
        this.setSexo(sexo);
        this.setPerfil(perfil);
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
        this.nome = nome.trim().isEmpty()?"":nome.toUpperCase();;
    }

    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    public void setTelefone(String telefone){
        this.telefone=telefone;
    }
    public String getTelefone(){
        return this.telefone.trim().isEmpty() ? "" : telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return this.numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Sexo getSexo() {
        return this.sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo == null ? Sexo.F : sexo;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
