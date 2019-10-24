
package Enums;

public enum Especie {
    SUINO("Suínos"),
    CAO("Cachorros"),
    GATO("Gatos"),
    PASSARO("Pássaros"),
    REPTIL("Repteis");
    //
    private String descricao;
    //
    private Especie(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString() {
        return this.descricao;
    }
    
    
}
