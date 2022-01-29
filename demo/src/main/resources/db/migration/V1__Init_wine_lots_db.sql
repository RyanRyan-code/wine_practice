


CREATE TABLE public.wine_component (
    id integer NOT NULL,
    lotcode text,
    component_percentage integer,
    component_region text,
    component_variety text,
    component_year text
);


ALTER TABLE public.wine_component OWNER TO postgres;



CREATE SEQUENCE public.wine_component_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.wine_component_id_seq OWNER TO postgres;



ALTER SEQUENCE public.wine_component_id_seq OWNED BY public.wine_component.id;




CREATE TABLE public.wine_lot_codes (
    lot_code text NOT NULL,
    volume real,
    description text,
    tank_code text,
    product_state text,
    owner_name text
);


ALTER TABLE public.wine_lot_codes OWNER TO postgres;



ALTER TABLE ONLY public.wine_component ALTER COLUMN id SET DEFAULT nextval('public.wine_component_id_seq'::regclass);




INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (228, '15MPPN002-VK', 60, 'Mornington', 'Pinot Noir', '2015');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (229, '15MPPN002-VK', 2, 'Yarra Valley', 'Pinot Noir', '2015');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (230, '15MPPN002-VK', 5, 'Yarra Valley', 'Pinot Noir', '2014');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (231, '15MPPN002-VK', 3, 'Yarra Valley', 'Merlot', '2015');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (232, '15MPPN002-VK', 1, 'Mornington', 'Shiraz', '2015');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (233, '15MPPN002-VK', 2, 'Macedon', 'Zinfandel', '2015');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (234, '15MPPN002-VK', 2, 'Port Phillip', 'Malbec', '2014');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (235, '15MPPN002-VK', 10, 'Mornington', 'Pinot Noir', '2014');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (236, '15MPPN002-VK', 10, 'Mornington', 'Pinot Noir', '2015');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (237, '15MPPN002-VK', 5, 'Heathcote', 'Cabernet', '2013');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (238, '11YVCHAR001', 5, 'Mornington', 'Pinot Noir', '2011');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (239, '11YVCHAR001', 80, 'Yarra Valley', 'Chardonnay', '2011');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (240, '11YVCHAR001', 5, 'Macedon', 'Pinot Noir', '2010');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (241, '11YVCHAR001', 10, 'Macedon', 'Chardonnay', '2010');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (242, '11YVCHAR002', 5, 'Mornington', 'Pinot Noir', '2011');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (243, '11YVCHAR002', 80, 'Yarra Valley', 'Chardonnay', '2011');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (244, '11YVCHAR002', 5, 'Macedon', 'Pinot Noir', '2010');
INSERT INTO public.wine_component (id, lotcode, component_percentage, component_region, component_variety, component_year) VALUES (245, '11YVCHAR002', 10, 'Macedon', 'Chardonnay', '2010');




INSERT INTO public.wine_lot_codes (lot_code, volume, description, tank_code, product_state, owner_name) VALUES ('15MPPN002-VK', 100000, '2015 Mornington Peninsula Pinot Noir - Vintage Kerr special batch', 'T100-03', NULL, 'Vintage Kerr');
INSERT INTO public.wine_lot_codes (lot_code, volume, description, tank_code, product_state, owner_name) VALUES ('11YVCHAR001', 1000, '2011 Yarra Valley Chardonnay', 'T25-01', NULL, 'YV Wines Pty Ltd');
INSERT INTO public.wine_lot_codes (lot_code, volume, description, tank_code, product_state, owner_name) VALUES ('11YVCHAR002', 5077, NULL, 'T25-06', NULL, 'YV Wines P/L and Vintage Kerr Joint Venture');




SELECT pg_catalog.setval('public.wine_component_id_seq', 245, true);




ALTER TABLE ONLY public.wine_component
    ADD CONSTRAINT wine_component_pkey PRIMARY KEY (id);




ALTER TABLE ONLY public.wine_lot_codes
    ADD CONSTRAINT wine_lot_codes_pkey PRIMARY KEY (lot_code);




CREATE INDEX fki_fkey ON public.wine_component USING btree (lotcode);




ALTER TABLE ONLY public.wine_component
    ADD CONSTRAINT fkey FOREIGN KEY (lotcode) REFERENCES public.wine_lot_codes(lot_code);






