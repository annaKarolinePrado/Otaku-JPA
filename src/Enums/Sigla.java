
package Enums;

public enum Sigla {
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    PR("Paraná"),
    SP("São Paulo");
    //
    private String descricao;
    //
    private Sigla(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString() {
        return this.descricao;
    }
}
