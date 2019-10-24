
package Enums;

public enum Sigla {
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    PR("Paraná"),
    MG("Minas Gerais"),
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
