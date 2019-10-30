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
@Table(name = "FILME")
public class Filme implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "NOME", length = 100, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    
    @Column(name = "DURACAO", length = 100, nullable = false)
    @SwingColumn(description = "Duração")
    private String duracao;
    
    @Column(name = "NASCIMENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PRODUTORA", nullable = false,referencedColumnName = "ID")
    //@SwingColumn(description = "Produtora")
    private Produtora produtora;
   
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CATEGORIA", nullable = false,referencedColumnName = "ID")
    
    //@SwingColumn(description = "Categoria")
    private Categoria categoria;
    //CONSTRUTOR
    public Filme(){
        
    }
    public Filme(int id, String nome, String duracao, Date dataLancamento, Produtora produtora, Categoria categoria){
        this.setId(id);
        this.setNome(nome);
        this.setDuracao(duracao);
        this.setDataLancamento(dataLancamento);
        this.setProdutora(produtora);
        this.setCategoria(categoria);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Produtora getProdutora() {
        return produtora;
    }

    public void setProdutora(Produtora produtora) {
        this.produtora = produtora;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id;
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
        final Filme other = (Filme) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
