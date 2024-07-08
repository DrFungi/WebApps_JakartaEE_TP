-- Drop tables if exist
drop table if exists TaxAuthority;
drop table if exists TaxBracket;

-- Create TaxAuthority table
CREATE TABLE TaxAuthority (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              label VARCHAR(255) NOT NULL,
                              taxFreeThreshold DOUBLE NOT NULL
);

-- Create TaxBracket table
CREATE TABLE TaxBracket (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            minIncome DOUBLE NOT NULL,
                            maxIncome DOUBLE,
                            taxRate DOUBLE NOT NULL,
                            taxAuthorityId INT,
                            FOREIGN KEY (taxAuthorityId) REFERENCES TaxAuthority(id)
);
