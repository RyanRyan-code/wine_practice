--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.0

-- Started on 2022-01-21 18:55:37

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 33563)
-- Name: wine_component; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.wine_component (
    id integer NOT NULL,
    lotcode text,
    percentage integer,
    region text,
    variety text,
    year text
);


ALTER TABLE public.wine_component OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 33562)
-- Name: wine_component_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.wine_component_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.wine_component_id_seq OWNER TO postgres;

--
-- TOC entry 3322 (class 0 OID 0)
-- Dependencies: 210
-- Name: wine_component_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.wine_component_id_seq OWNED BY public.wine_component.id;


--
-- TOC entry 209 (class 1259 OID 33555)
-- Name: wine_lot_codes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.wine_lot_codes (
    lot_code text NOT NULL,
    volume real,
    description text,
    tank_code text,
    product_state text,
    owner_name text
);


ALTER TABLE public.wine_lot_codes OWNER TO postgres;

--
-- TOC entry 3168 (class 2604 OID 33566)
-- Name: wine_component id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wine_component ALTER COLUMN id SET DEFAULT nextval('public.wine_component_id_seq'::regclass);


--
-- TOC entry 3316 (class 0 OID 33563)
-- Dependencies: 211
-- Data for Name: wine_component; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (228, '15MPPN002-VK', 60, 'Mornington', 'Pinot Noir', '2015');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (229, '15MPPN002-VK', 2, 'Yarra Valley', 'Pinot Noir', '2015');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (230, '15MPPN002-VK', 5, 'Yarra Valley', 'Pinot Noir', '2014');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (231, '15MPPN002-VK', 3, 'Yarra Valley', 'Merlot', '2015');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (232, '15MPPN002-VK', 1, 'Mornington', 'Shiraz', '2015');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (233, '15MPPN002-VK', 2, 'Macedon', 'Zinfandel', '2015');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (234, '15MPPN002-VK', 2, 'Port Phillip', 'Malbec', '2014');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (235, '15MPPN002-VK', 10, 'Mornington', 'Pinot Noir', '2014');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (236, '15MPPN002-VK', 10, 'Mornington', 'Pinot Noir', '2015');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (237, '15MPPN002-VK', 5, 'Heathcote', 'Cabernet', '2013');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (238, '11YVCHAR001', 5, 'Mornington', 'Pinot Noir', '2011');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (239, '11YVCHAR001', 80, 'Yarra Valley', 'Chardonnay', '2011');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (240, '11YVCHAR001', 5, 'Macedon', 'Pinot Noir', '2010');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (241, '11YVCHAR001', 10, 'Macedon', 'Chardonnay', '2010');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (242, '11YVCHAR002', 5, 'Mornington', 'Pinot Noir', '2011');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (243, '11YVCHAR002', 80, 'Yarra Valley', 'Chardonnay', '2011');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (244, '11YVCHAR002', 5, 'Macedon', 'Pinot Noir', '2010');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (245, '11YVCHAR002', 10, 'Macedon', 'Chardonnay', '2010');


--
-- TOC entry 3314 (class 0 OID 33555)
-- Dependencies: 209
-- Data for Name: wine_lot_codes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.wine_lot_codes (lot_code, volume, description, tank_code, product_state, owner_name) VALUES ('15MPPN002-VK', 100000, '2015 Mornington Peninsula Pinot Noir - Vintage Kerr special batch', 'T100-03', NULL, 'Vintage Kerr');
INSERT INTO public.wine_lot_codes (lot_code, volume, description, tank_code, product_state, owner_name) VALUES ('11YVCHAR001', 1000, '2011 Yarra Valley Chardonnay', 'T25-01', NULL, 'YV Wines Pty Ltd');
INSERT INTO public.wine_lot_codes (lot_code, volume, description, tank_code, product_state, owner_name) VALUES ('11YVCHAR002', 5077, NULL, 'T25-06', NULL, 'YV Wines P/L and Vintage Kerr Joint Venture');


--
-- TOC entry 3323 (class 0 OID 0)
-- Dependencies: 210
-- Name: wine_component_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.wine_component_id_seq', 245, true);


--
-- TOC entry 3173 (class 2606 OID 33570)
-- Name: wine_component wine_component_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wine_component
    ADD CONSTRAINT wine_component_pkey PRIMARY KEY (id);


--
-- TOC entry 3170 (class 2606 OID 33561)
-- Name: wine_lot_codes wine_lot_codes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wine_lot_codes
    ADD CONSTRAINT wine_lot_codes_pkey PRIMARY KEY (lot_code);


--
-- TOC entry 3171 (class 1259 OID 33576)
-- Name: fki_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_fkey ON public.wine_component USING btree (lotcode);


--
-- TOC entry 3174 (class 2606 OID 33577)
-- Name: wine_component fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wine_component
    ADD CONSTRAINT fkey FOREIGN KEY (lotcode) REFERENCES public.wine_lot_codes(lot_code);


-- Completed on 2022-01-21 18:55:38

--
-- PostgreSQL database dump complete
--

