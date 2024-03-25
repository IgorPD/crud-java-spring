ALTER TABLE category ADD active BOOLEAN;
UPDATE category SET active = true;