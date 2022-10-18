create table bills(
    bill_id int PRIMARY KEY,
    day date NOT NULL,
    concept varchar(100) NOT NULL,
    total decimal(9,2) NOT NULL,
    client_id varchar(9) NOT NULL
);