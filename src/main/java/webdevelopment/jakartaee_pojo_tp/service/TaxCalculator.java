package webdevelopment.jakartaee_pojo_tp.service;

import webdevelopment.jakartaee_pojo_tp.persistance.ITaxBracketDAO;

public class TaxCalculator {

    // el tax calculator debe tener una funcion que permita
    // que entre la autoridad de tax (provincia) y el ingreso
    // de la persona.
    // debe sacar el tax que se debe para esa autoridad

    // DAO call
    private ITaxBracketDAO daoTax;

    // dependency injection
    public TaxCalculator(ITaxBracketDAO dao){this.daoTax =dao;}


}
