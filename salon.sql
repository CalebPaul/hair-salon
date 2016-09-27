--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: calebpaul
--

CREATE TABLE clients (
    id integer NOT NULL,
    name character varying,
    cut character varying,
    stylist_id integer
);


ALTER TABLE clients OWNER TO calebpaul;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: calebpaul
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO calebpaul;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: calebpaul
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: calebpaul
--

CREATE TABLE stylists (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE stylists OWNER TO calebpaul;

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: calebpaul
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO calebpaul;

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: calebpaul
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: calebpaul
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: calebpaul
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: calebpaul
--

COPY clients (id, name, cut, stylist_id) FROM stdin;
9	Joanne	Short Curls	10
10	Kate	Side Pony	11
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: calebpaul
--

SELECT pg_catalog.setval('clients_id_seq', 10, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: calebpaul
--

COPY stylists (id, name) FROM stdin;
10	Philipe
11	Sara
12	Sean
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: calebpaul
--

SELECT pg_catalog.setval('stylists_id_seq', 12, true);


--
-- Name: clients_pkey; Type: CONSTRAINT; Schema: public; Owner: calebpaul
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: calebpaul
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: calebpaul
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM calebpaul;
GRANT ALL ON SCHEMA public TO calebpaul;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

