package Enums;

public enum Perfil {
    A("Admin"),
    C("Cliente");
    
    private String descricao;

    private Perfil(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
