CREATE TABLE deliverer
(
    id            INT PRIMARY KEY,
    company_name  VARCHAR(255),
    iban          VARCHAR(400),

    creation_date DATE
);

CREATE TABLE invoice
(
    id             INT PRIMARY KEY NOT NULL,
    deliverer_id   INT,
    invoice_type   VARCHAR(68),
    invoice_number VARCHAR(255),
    invoice_date   DATE,
    expiry_date    DATE,
    cash_amount    DECIMAL,
    is_payed       boolean,
    payment_date   DATE,

    creation_date  DATE,

    FOREIGN KEY (deliverer_id) REFERENCES deliverer
);
