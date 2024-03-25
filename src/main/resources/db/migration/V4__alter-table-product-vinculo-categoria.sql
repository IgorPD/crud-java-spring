ALTER TABLE product ADD COLUMN id_category TEXT;

ALTER TABLE product ADD CONSTRAINT fk_product_category FOREIGN KEY(id_category) REFERENCES category(id);

INSERT INTO category (id, name) VALUES ('ABCDE-ABCDE', 'Genérico');


UPDATE product SET id_category = 'ABCDE-ABCDE';