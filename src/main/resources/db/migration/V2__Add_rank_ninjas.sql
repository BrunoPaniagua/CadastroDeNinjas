-- V2: Migrations para adicionar a coluna de RANK na tabela de ninjas

ALTER TABLE ninjas
ADD COLUMN rank VARCHAR(255);