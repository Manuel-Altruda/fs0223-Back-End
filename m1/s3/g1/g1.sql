CREATE TABLE clienti (
    numeroCliente SERIAL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    cognome VARCHAR NOT NULL,
    dataNascita DATE NOT NULL,
    regioneResidenza VARCHAR NOT NULL
);

CREATE TABLE prodotti (
    idProdotto SERIAL PRIMARY KEY,
    descrizione VARCHAR NOT NULL,
    inProduzione BOOLEAN NOT NULL,
    inCommercio BOOLEAN NOT NULL,
    dataAttivazione DATE,
    dataDisattivazione DATE
);

CREATE TABLE fornitori(
    idFornitore SERIAL PRIMARY KEY,
    denominazione VARCHAR NOT NULL,
    regioneResidenza VARCHAR NOT NULL
);

CREATE TABLE fatture (
    numeroFattura SERIAL PRIMARY KEY,
    tipologia VARCHAR NOT NULL,
    importo FLOAT NOT NULL,
    iva INTEGER NOT NULL,
    idCliente INTEGER NOT NULL,
    dataFattura DATE NOT NULL,
    idFornitore INTEGER NOT NULL,
    CONSTRAINT FK_PersonOrder FOREIGN KEY (idCliente)
    REFERENCES clienti(numeroCliente),
    CONSTRAINT FK_FornitoriOrder FOREIGN KEY (idFornitore)
    REFERENCES fornitori(idFornitore)
);



-- Inserimento dati casuali per la tabella "clienti"
INSERT INTO clienti (nome, cognome, dataNascita, regioneResidenza)
VALUES
    ('Mario', 'Rossi', '1990-05-12', 'Lombardia'),
    ('Laura', 'Bianchi', '1985-09-28', 'Lazio'),
    ('Giovanni', 'Verdi', '1998-03-17', 'Campania'),
    ('Francesca', 'Rizzo', '1993-11-05', 'Sicilia'),
    ('Luca', 'Gallo', '1987-07-21', 'Piemonte'),
    ('Martina', 'Ferrari', '1982-02-09', 'Emilia-Romagna'),
    ('Alessandro', 'Esposito', '1997-08-14', 'Toscana'),
    ('Sara', 'Conti', '1994-06-30', 'Veneto'),
    ('Davide', 'Marini', '1991-01-18', 'Marche'),
    ('Giulia', 'Barbieri', '1989-04-25', 'Friuli Venezia Giulia'),
    ('Simone', 'De Rosa', '1996-09-02', 'Abruzzo'),
    ('Federica', 'Costa', '1993-03-11', 'Calabria'),
    ('Riccardo', 'Lombardi', '1990-07-07', 'Basilicata'),
    ('Valentina', 'Greco', '1988-12-24', 'Molise'),
    ('Fabio', 'Giordano', '1995-10-08', 'Liguria'),
    ('Elisa', 'Caruso', '1980-05-15', 'Sardegna'),
    ('Marco', 'Romano', '1986-08-02', 'Valle d''Aosta'),
    ('Jessica', 'Ferri', '1991-12-11', 'Trentino-Alto Adige'),
    ('Paolo', 'Russo', '1994-04-19', 'Umbria'),
    ('Silvia', 'Santoro', '1987-07-26', 'Campania');

-- Inserimento dati casuali per la tabella "prodotti"
INSERT INTO prodotti (descrizione, inProduzione, inCommercio, dataAttivazione, dataDisattivazione)
VALUES
    ('Prodotto A', true, true, '2022-01-01', null),
    ('Prodotto B', true, false, '2022-03-15', '2023-06-30'),
    ('Prodotto C', false, false, null, null),
    ('Prodotto D', true, true, '2022-06-10', null),
    ('Prodotto E', true, true, '2022-02-20', null),
    ('Prodotto F', true, false, '2022-04-05', '2023-07-01'),
    ('Prodotto G', false, false, null, null);

-- Inserimento dati casuali per la tabella "fornitori"
INSERT INTO fornitori (denominazione, regioneResidenza)
VALUES
    ('Fornitore X', 'Lombardia'),
    ('Fornitore Y', 'Lazio'),
    ('Fornitore Z', 'Piemonte'),
    ('Fornitore W', 'Sicilia'),
    ('Fornitore V', 'Emilia-Romagna'),
    ('Fornitore U', 'Toscana'),
    ('Fornitore T', 'Veneto'),
    ('Fornitore S', 'Friuli Venezia Giulia');

-- Inserimento dati casuali per la tabella "fatture"
INSERT INTO fatture (tipologia, importo, iva, idCliente, dataFattura, idFornitore)
VALUES
    ('Fattura A', 100.50, 22, 1, '2023-01-10', 1),
    ('Fattura B', 250.75, 22, 2, '2023-02-15', 2),
    ('Fattura C', 80.00, 10, 3, '2023-03-20', 3),
    ('Fattura D', 150.20, 22, 4, '2023-04-25', 4),
    ('Fattura E', 180.90, 10, 5, '2023-05-30', 5),
    ('Fattura F', 75.60, 10, 6, '2023-06-05', 6),
    ('Fattura G', 200.35, 22, 7, '2023-07-10', 7),
    ('Fattura H', 90.80, 22, 8, '2023-08-15', 8),
    ('Fattura I', 120.00, 10, 9, '2023-09-20', 1),
    ('Fattura J', 300.25, 22, 10, '1980-10-25', 2),
    ('Fattura K', 65.70, 10, 11, '2023-11-30', 3),
    ('Fattura L', 180.50, 22, 12, '2023-12-05', 4),
    ('Fattura M', 150.80, 10, 13, '2024-01-10', 5),
    ('Fattura N', 80.40, 22, 14, '2024-02-15', 6),
    ('Fattura O', 220.70, 10, 15, '2024-03-20', 7),
    ('Fattura P', 110.30, 10, 16, '2024-04-25', 8),
    ('Fattura Q', 95.60, 22, 17, '2024-05-30', 1),
    ('Fattura R', 180.90, 22, 18, '2024-06-05', 2),
    ('Fattura S', 70.20, 10, 19, '2024-07-10', 3),
    ('Fattura T', 150.40, 10, 20, '2024-08-15', 4),
    ('Fattura U', 210.75, 22, 1, '2024-09-20', 5);
	
-- Continuazione: Inserimento dati casuali per la tabella "fatture"
INSERT INTO fatture (tipologia, importo, iva, idCliente, dataFattura, idFornitore)
VALUES
    ('Fattura V', 80.30, 10, 2, '2024-10-25', 6),
    ('Fattura W', 190.50, 22, 3, '2024-11-30', 7),
    ('Fattura X', 100.80, 10, 4, '2024-12-05', 8),
    ('Fattura Y', 120.20, 10, 5, '2025-01-10', 1),
    ('Fattura Z', 250.40, 22, 6, '2025-02-15', 2),
    ('Fattura A', 70.90, 10, 7, '2023-01-10', 3),
    ('Fattura BB', 180.75, 22, 8, '2025-04-25', 4),
    ('Fattura CC', 85.60, 22, 9, '2025-05-30', 5),
    ('Fattura DD', 200.30, 10, 10, '2025-06-05', 6),
    ('Fattura EE', 95.20, 10, 11, '2025-07-10', 7),
    ('Fattura FF', 180.40, 22, 12, '2025-08-15', 8),
    ('Fattura GG', 150.90, 22, 13, '2025-09-20', 1),
    ('Fattura HH', 75.80, 10, 14, '2025-10-25', 2),
    ('Fattura II', 210.50, 22, 15, '2025-11-30', 3),
    ('Fattura JJ', 110.70, 10, 16, '2025-12-05', 4),
    ('Fattura KK', 95.30, 10, 17, '2026-01-10', 5),
    ('Fattura A', 150.60, 22, 18, '2026-02-15', 6),
    ('Fattura MM', 70.40, 10, 19, '2026-03-20', 7),
    ('Fattura NN', 180.80, 10, 20, '2026-04-25', 8);

-- Estraggo il nome e il cognome dei clienti che sono nati nel 1982
SELECT nome, cognome FROM clienti WHERE EXTRACT (YEAR FROM dataNascita)=1982;

-- Estraggo il numero delle fatture con iva al 20%
SELECT COUNT(*) AS numeroFattureIva20 FROM fatture WHERE iva = 22;

--Riporto il numero di fatture e la somma dei relativi importi divisi per anno di fatturazione
SELECT EXTRACT (YEAR FROM dataFattura) AS anno, COUNT(numeroFattura) AS numeroFatture, SUM(importo) AS sommaImporti
FROM fatture
GROUP BY EXTRACT (YEAR FROM dataFattura);

-- Estraggo il numero delle fatture con iva al 20% per ogni anno
SELECT EXTRACT (YEAR FROM dataFattura) AS anno, COUNT(*) AS numeroFattureIva20 
FROM fatture WHERE iva = 22 GROUP BY anno;

-- Estraggo gli anni in cui sono state registrate più di 2 fatture con tipologia A
SELECT DISTINCT EXTRACT (YEAR FROM dataFattura) AS anno
FROM fatture
WHERE tipologia = 'Fattura A'
GROUP BY anno
HAVING COUNT(numeroFattura) > 2;

-- Riporto l'elenco delle fatture con in aggiunta il nome del fornitore
SELECT fatture.numeroFattura, fatture.importo, fatture.iva, fatture.dataFattura, fornitori.denominazione AS nomeFornitore
FROM fatture, fornitori
WHERE fatture.idFornitore = fornitori.idFornitore;

-- Estraggo il totale degli importi delle fatture divisi per residenza dei clienti
SELECT cliente.regioneResidenza, SUM(fattura.importo) AS totaleImporti
FROM fatture fattura
JOIN clienti cliente ON fattura.idCliente = cliente.numeroCliente
GROUP BY cliente.regioneResidenza;

-- Estraggo il numero dei clienti nati nel 1980 che hanno almeno una fattura superiore a 50 euro
SELECT COUNT (DISTINCT cliente.numeroCliente) AS numeroClienti
FROM clienti cliente
JOIN fatture fattura ON cliente.numeroCliente = fattura.idCliente
WHERE EXTRACT (YEAR FROM cliente.dataNascita) = 1990 AND fattura.importo > 50;

-- Estraggo la colonna Denominazione ...
SELECT CONCAT(nome, '-', cognome) AS Denominazione
FROM clienti
WHERE regioneResidenza = 'Lombardia';
