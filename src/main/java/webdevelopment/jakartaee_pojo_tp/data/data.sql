-- Insert into TaxAuthority table
INSERT INTO TaxAuthority (label, taxFreeThreshold) VALUES
                                                       ('Canada', 13229),
                                                       ('Quebec', 15728);

-- Insert into TaxBracket table for Canada
INSERT INTO TaxBracket (minIncome, maxIncome, taxRate, taxAuthorityId) VALUES
                                                                           (13229.01, 55867, 15.0, (SELECT id FROM TaxAuthority WHERE label = 'Canada')),
                                                                           (55867.01, 111733, 20.5, (SELECT id FROM TaxAuthority WHERE label = 'Canada')),
                                                                           (111733.01, 173205, 26.0, (SELECT id FROM TaxAuthority WHERE label = 'Canada')),
                                                                           (173205.01, 246752, 29.0, (SELECT id FROM TaxAuthority WHERE label = 'Canada')),
                                                                           (246752.01, 0.0, 33.0, (SELECT id FROM TaxAuthority WHERE label = 'Canada'));

-- Insert into TaxBracket table for Quebec
INSERT INTO TaxBracket (minIncome, maxIncome, taxRate, taxAuthorityId) VALUES
                                                                           (15728.01, 51780, 14.0, (SELECT id FROM TaxAuthority WHERE label = 'Quebec')),
                                                                           (51780.01, 103545, 19.0, (SELECT id FROM TaxAuthority WHERE label = 'Quebec')),
                                                                           (103545.01, 126000, 24.0, (SELECT id FROM TaxAuthority WHERE label = 'Quebec')),
                                                                           (126000.01, 0.0, 25.75, (SELECT id FROM TaxAuthority WHERE label = 'Quebec'));
