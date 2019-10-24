
package Abstratas;

abstract public class Principal implements java.io.Serializable{
    private int id;
    private String nome;
    //
    public Principal(){
        this.setId(0);
        this.setNome("padrão");
    }
    public Principal(int id,String nome){
        this.setId(id);
        this.setNome(nome);
    }
    //
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty() ? "PADRÃO" : nome.toUpperCase();
    }
    //
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
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
        final Principal other = (Principal) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
