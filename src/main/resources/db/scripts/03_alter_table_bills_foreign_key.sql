ALTER TABLE bills
ADD FOREIGN KEY (client_id) REFERENCES clients(dni);
