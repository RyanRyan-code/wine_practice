--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1 (Debian 14.1-1.pgdg110+1)
-- Dumped by pg_dump version 14.0

-- Started on 2022-01-16 14:48:16

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


--
-- TOC entry 3328 (class 1262 OID 16384)
-- Name: wine_lots; Type: DATABASE; Schema: -; Owner: postgres
--




ALTER DATABASE wine_lots OWNER TO postgres;



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
-- TOC entry 210 (class 1259 OID 16386)
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
-- TOC entry 209 (class 1259 OID 16385)
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
-- TOC entry 3329 (class 0 OID 0)
-- Dependencies: 209
-- Name: wine_component_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.wine_component_id_seq OWNED BY public.wine_component.id;


--
-- TOC entry 212 (class 1259 OID 16395)
-- Name: wine_lot_codes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.wine_lot_codes (
    id integer NOT NULL,
    volume real,
    lot_code text,
    description text,
    tank_code text,
    product_state text,
    owner_name text
);


ALTER TABLE public.wine_lot_codes OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16394)
-- Name: wine_lot_codes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.wine_lot_codes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.wine_lot_codes_id_seq OWNER TO postgres;

--
-- TOC entry 3330 (class 0 OID 0)
-- Dependencies: 211
-- Name: wine_lot_codes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.wine_lot_codes_id_seq OWNED BY public.wine_lot_codes.id;


--
-- TOC entry 3172 (class 2604 OID 16389)
-- Name: wine_component id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wine_component ALTER COLUMN id SET DEFAULT nextval('public.wine_component_id_seq'::regclass);


--
-- TOC entry 3173 (class 2604 OID 16398)
-- Name: wine_lot_codes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wine_lot_codes ALTER COLUMN id SET DEFAULT nextval('public.wine_lot_codes_id_seq'::regclass);


--
-- TOC entry 3320 (class 0 OID 16386)
-- Dependencies: 210
-- Data for Name: wine_component; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (1, '11YVCHAR001', 5, 'Mornington', 'Pinot Noir', '2011');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (2, '11YVCHAR001', 80, 'Yarra Valley', 'Chardonnay', '2011');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (3, '11YVCHAR001', 5, 'Macedon', 'Pinot Noir', '2010');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (4, '11YVCHAR001', 10, 'Macedon', 'Chardonnay', '2010');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (5, '11YVCHAR002', 5, 'Mornington', 'Pinot Noir', '2011');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (6, '11YVCHAR002', 80, 'Yarra Valley', 'Chardonnay', '2011');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (7, '11YVCHAR002', 5, 'Macedon', 'Pinot Noir', '2010');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (8, '11YVCHAR002', 10, 'Macedon', 'Chardonnay', '2010');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (9, '15MPPN002-VK', 60, 'Mornington', 'Pinot Noir', '2015');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (10, '15MPPN002-VK', 2, 'Yarra Valley', 'Pinot Noir', '2015');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (11, '15MPPN002-VK', 5, 'Yarra Valley', 'Pinot Noir', '2014');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (12, '15MPPN002-VK', 3, 'Yarra Valley', 'Merlot', '2015');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (13, '15MPPN002-VK', 1, 'Mornington', 'Shiraz', '2015');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (14, '15MPPN002-VK', 2, 'Macedon', 'Zinfandel', '2015');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (15, '15MPPN002-VK', 2, 'Port Phillip', 'Malbec', '2014');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (16, '15MPPN002-VK', 10, 'Mornington', 'Pinot Noir', '2014');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (17, '15MPPN002-VK', 10, 'Mornington', 'Pinot Noir', '2015');
INSERT INTO public.wine_component (id, lotcode, percentage, region, variety, year) VALUES (18, '15MPPN002-VK', 5, 'Heathcote', 'Cabernet', '2013');


--
-- TOC entry 3322 (class 0 OID 16395)
-- Dependencies: 212
-- Data for Name: wine_lot_codes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.wine_lot_codes (id, volume, lot_code, description, tank_code, product_state, owner_name) VALUES (1, 1000, '11YVCHAR001', '2011 Yarra Valley Chardonnay', 'T25-01', 'Ready for bottling', 'YV Wines Pty Ltd');
INSERT INTO public.wine_lot_codes (id, volume, lot_code, description, tank_code, product_state, owner_name) VALUES (2, 5077, '11YVCHAR002', NULL, 'T25-06', NULL, 'YV Wines P/L and Vintage Kerr Joint Venture');
INSERT INTO public.wine_lot_codes (id, volume, lot_code, description, tank_code, product_state, owner_name) VALUES (3, 100000, '15MPPN002-VK', '2015 Mornington Peninsula Pinot Noir - Vintage Kerr special batch', 'T100-03', 'Filtered', 'Vintage Kerr');


--
-- TOC entry 3331 (class 0 OID 0)
-- Dependencies: 209
-- Name: wine_component_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.wine_component_id_seq', 33, true);


--
-- TOC entry 3332 (class 0 OID 0)
-- Dependencies: 211
-- Name: wine_lot_codes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.wine_lot_codes_id_seq', 33, true);


--
-- TOC entry 3175 (class 2606 OID 16393)
-- Name: wine_component wine_component_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wine_component
    ADD CONSTRAINT wine_component_pkey PRIMARY KEY (id);


--
-- TOC entry 3177 (class 2606 OID 16404)
-- Name: wine_lot_codes wine_lot_codes_lot_code_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wine_lot_codes
    ADD CONSTRAINT wine_lot_codes_lot_code_key UNIQUE (lot_code);


--
-- TOC entry 3179 (class 2606 OID 16402)
-- Name: wine_lot_codes wine_lot_codes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wine_lot_codes
    ADD CONSTRAINT wine_lot_codes_pkey PRIMARY KEY (id);


-- Completed on 2022-01-16 14:48:16

--
-- PostgreSQL database dump complete
--

