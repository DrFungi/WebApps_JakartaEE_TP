package webdevelopment.jakartaee_pojo_tp.persistance;

import webdevelopment.jakartaee_pojo_tp.model.TaxAuthority;
import webdevelopment.jakartaee_pojo_tp.model.TaxBracket;

import java.util.List;

public interface ITaxBracketDAO {
    TaxAuthority getTaxAuthorityByLabel(String taxAuthority);

    List<TaxBracket> getTaxBracketsByAuthorityId(int authorityId);
}
