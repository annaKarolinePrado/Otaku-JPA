package Enums;

public enum Sexo {
    M("Masculino"),
    F("Feminino");
    
    private String descricao;

    private Sexo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
