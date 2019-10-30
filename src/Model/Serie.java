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
@Table(name = "SERIE")
public class Serie implements java.io.Serializable{
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
    //
    public Serie(){
        
    }
    public Serie(int id,String nome,String duracao, Date dataLancamento,  Produtora produtora, Categoria categoria){
        this.setId(id);
        this.setNome(nome);
        this.setDuracao(duracao);
        this.setDataLancamento(dataLancamento);
        this.setProdutora(produtora);
        this.setCategoria(categoria);
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

    public Produtora getProdutora() {
        return this.produtora;
    }
    public void setProdutora(Produtora produtora) {
        this.produtora = produtora == null ? new Produtora() : produtora;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria == null ? new Categoria() : categoria;
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

    @Override
    public String toString() {
        return this.nome;
    }
    
    //
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Serie other = (Serie) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
