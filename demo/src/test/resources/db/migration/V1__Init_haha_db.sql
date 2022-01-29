CREATE TABLE wine_lot_codes (
    lot_code CHARACTER VARYING NOT NULL,
    volume REAL,
    description CHARACTER VARYING,
    tank_code CHARACTER VARYING,
    product_state CHARACTER VARYING,
    owner_name CHARACTER VARYING
);

CREATE TABLE wine_component (
    id IDENTITY NOT NULL PRIMARY KEY,
    lotcode CHARACTER VARYING,
    component_percentage integer,
    component_region CHARACTER VARYING,
    component_variety CHARACTER VARYING,
    component_year CHARACTER VARYING
);

ALTER TABLE wine_lot_codes
    ADD PRIMARY KEY (lot_code);

ALTER TABLE wine_component
    ADD FOREIGN KEY (lotcode)
    REFERENCES wine_lot_codes(lot_code);


