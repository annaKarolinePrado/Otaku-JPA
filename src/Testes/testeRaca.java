
package Testes;

import Controller.RacaDAO;
import Enums.Especie;
import Model.Raca;

public class testeRaca {
    public static void main(String[] args) {
        RacaDAO dao = new RacaDAO();
        
        Raca r1 = new Raca(0, "Tartaruga", Especie.REPTIL);
        Raca r2 = new Raca(0, "pastor alemão", Especie.CAO);
        Raca r3 = new Raca(0, "persa", Especie.GATO);
        
        dao.add(r1);
        dao.add(r2);
        dao.add(r3);
        
    }
    
}
