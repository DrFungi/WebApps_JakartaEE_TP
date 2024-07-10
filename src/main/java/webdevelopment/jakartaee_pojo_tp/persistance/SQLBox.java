package webdevelopment.jakartaee_pojo_tp.persistance;

public class SQLBox {
    public static final String FIND_ALL_AUTHORITIES = "SELECT id, label, taxFreeThreshold FROM TaxAuthority WHERE label = ?";
    public static final String FIND_TAX_BRACKETS_BY_AUTHORITY_ID = "SELECT minIncome, maxIncome, taxRate, taxAuthorityId FROM TaxBracket WHERE taxAuthorityId = ?";
}
