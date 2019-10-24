package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLANO")
public class Plano implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "DESCRICAO", length = 100, nullable = false)
    @SwingColumn(description = "descricao")
    private String descricao;
    
    @Column(name = "VALOR", nullable = false)
    @SwingColumn(description = "valor")
    private double valor; 
    //
    public Plano(){

    }  
    public Plano(int id,String descricao,double valor){
        this.setId(id);
        this.setDescricao(descricao);
        this.setValor(valor);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao.trim().isEmpty()?"":descricao.toUpperCase();
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor <= 0 ? 0.01 : valor;
    }
    //
    @Override
    public String toString() {
        return this.descricao;
    }
    //

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Plano other = (Plano) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
