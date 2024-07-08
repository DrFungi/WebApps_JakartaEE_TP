package webdevelopment.jakartaee_pojo_tp.persistance;

import java.sql.Connection;

public class TaxBracketDAO implements ITaxBracketDAO {
    Connection connection;

    public TaxBracketDAO(){
        // call the singleton
        this.connection = SQL_Connector.getInstance().getConnection();
    }

    //@Override

}
