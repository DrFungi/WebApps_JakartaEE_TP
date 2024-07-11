package webdevelopment.jakartaee_pojo_tp.service;

import webdevelopment.jakartaee_pojo_tp.model.TaxAuthority;
import webdevelopment.jakartaee_pojo_tp.model.TaxBracket;
import webdevelopment.jakartaee_pojo_tp.persistance.ITaxBracketDAO;

import java.util.List;

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
        if (taxFreeThreshold >= income){
            return 0.0;
        }
        List<TaxBracket> taxBracketList = this.daoTax.getTaxBracketsByAuthorityId(authority.getId());
        double taxableIncome = income - taxFreeThreshold;
        double taxOwed = 0.0;
        for (TaxBracket item : taxBracketList){
            if (taxableIncome > item.getMinIncome()) {
                double maxTaxedincome = taxableIncome;
                double taxedIncome = 0;
                if (item.getMaxIncome() != 0.0 && taxableIncome > item.getMaxIncome()) {
                    maxTaxedincome = item.getMaxIncome() - item.getMinIncome();
                } else {
                    taxedIncome = maxTaxedincome - item.getMinIncome();
                }
                taxOwed += taxedIncome * (item.getTaxRate() / 100);
            }
        }
        return taxOwed;
    }
}
