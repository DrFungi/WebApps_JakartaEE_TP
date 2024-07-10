package webdevelopment.jakartaee_pojo_tp.service;

import webdevelopment.jakartaee_pojo_tp.model.TaxAuthority;
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


    public double calculateTax(String taxAuthority, double income) {
        TaxAuthority authority = this.daoTax.getTaxAuthorityByLabel(taxAuthority);
        double taxFreeThreshold = authority.getTaxFreeThreshold();
        if (taxFreeThreshold > income){
            return 0.0;
        }
        return 5.0;
    }
}
