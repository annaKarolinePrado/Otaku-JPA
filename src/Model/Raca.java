
package Model;

import Enums.Especie;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RACAS")

public class Raca implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    //
    @SwingColumn(description = "Nome")
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;
    //
    @Enumerated(EnumType.STRING)
    @Column(name = "ESPECIE", length = 8, nullable = false)
    @SwingColumn(description = "Espécie")
    private Especie especie;
    //
    public Raca(){
        
    }
    public Raca(int id, String nome, Especie especie){
        this.setId(id);
        this.setNome(nome);
        this.setEspecie(especie);
    }
    //
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome=nome.trim().isEmpty()?"PADRÃO":nome.toUpperCase();
    }
    public void setEspecie(Especie especie){
        this.especie = especie == null ? Especie.CAO : especie;
    }
    //
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public Especie getEspecie(){
        return this.especie;
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
        hash = 43 * hash + this.id;
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
        final Raca other = (Raca) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
