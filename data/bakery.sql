--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3 (Debian 16.3-1.pgdg120+1)
-- Dumped by pg_dump version 16.3 (Debian 16.3-1.pgdg120+1)

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
-- Name: app_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.app_user (
    id integer NOT NULL,
    email character varying(255),
    full_name character varying(255),
    password character varying(255),
    phone character varying(255),
    role character varying(255),
    username character varying(255),
    CONSTRAINT app_user_role_check CHECK (((role)::text = ANY ((ARRAY['ROLE_ADMIN'::character varying, 'ROLE_CASHIER'::character varying, 'ROLE_CUSTOMER'::character varying])::text[])))
);


ALTER TABLE public.app_user OWNER TO postgres;

--
-- Name: cart; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cart (
    id integer NOT NULL,
    app_user_id integer
);


ALTER TABLE public.cart OWNER TO postgres;

--
-- Name: cart_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cart_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cart_id_seq OWNER TO postgres;

--
-- Name: cart_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cart_id_seq OWNED BY public.cart.id;


--
-- Name: cart_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cart_item (
    id integer NOT NULL,
    amount integer NOT NULL,
    cart_id integer,
    product_id integer
);


ALTER TABLE public.cart_item OWNER TO postgres;

--
-- Name: cart_item_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cart_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cart_item_id_seq OWNER TO postgres;

--
-- Name: cart_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cart_item_id_seq OWNED BY public.cart_item.id;


--
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    id integer NOT NULL,
    img_path character varying(255),
    name character varying(255)
);


ALTER TABLE public.category OWNER TO postgres;

--
-- Name: category_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.category_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.category_sequence OWNER TO postgres;

--
-- Name: order_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_item (
    id bigint NOT NULL,
    amount integer,
    fk_product_id integer,
    fk_sale_order_id bigint
);


ALTER TABLE public.order_item OWNER TO postgres;

--
-- Name: order_item_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.order_item_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.order_item_sequence OWNER TO postgres;

--
-- Name: order_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.order_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.order_sequence OWNER TO postgres;

--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id integer NOT NULL,
    description character varying(255),
    img_path character varying(255),
    name character varying(255),
    price double precision,
    quantity integer,
    fk_category_id integer
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: product_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.product_sequence OWNER TO postgres;

--
-- Name: sale_order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sale_order (
    id bigint NOT NULL,
    ship_address character varying(255),
    total double precision,
    fk_customer_id integer,
    fk_employee_id integer
);


ALTER TABLE public.sale_order OWNER TO postgres;

--
-- Name: user_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_sequence OWNER TO postgres;

--
-- Name: cart id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart ALTER COLUMN id SET DEFAULT nextval('public.cart_id_seq'::regclass);


--
-- Name: cart_item id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart_item ALTER COLUMN id SET DEFAULT nextval('public.cart_item_id_seq'::regclass);


--
-- Data for Name: app_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.app_user (id, email, full_name, password, phone, role, username) FROM stdin;
3	quythuong001@gmail.com	Tran Quy Thuong	$2a$10$00TKrm2GPjFYueSL.gYaJe5fowjn//A.N4bzcMBz2ITgA1jNDkl3e	0946373532	ROLE_CUSTOMER	quythuong
4	admin@bakery.com	Admin	$2a$10$Qd8A9G1KdBPWBnHyglNAFOzQxtI7Qj83DTurP4IUwLCXEVMacGwuS	0999999999	ROLE_ADMIN	admin
\.


--
-- Data for Name: cart; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cart (id, app_user_id) FROM stdin;
\.


--
-- Data for Name: cart_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cart_item (id, amount, cart_id, product_id) FROM stdin;
\.


--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category (id, img_path, name) FROM stdin;
1	\N	Bread
2	\N	Cakes
3	\N	Cookies
4	\N	Pudding
5	\N	Pastry
\.


--
-- Data for Name: order_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_item (id, amount, fk_product_id, fk_sale_order_id) FROM stdin;
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, description, img_path, name, price, quantity, fk_category_id) FROM stdin;
1	A flaky and buttery croissant filled with rich chocolate	/images/chocolate_croissant.jpg	Chocolate Croissant	3.5	50	5
2	A moist and fluffy muffin packed with fresh blueberries	/images/blueberry_muffin.jpg	Blueberry Muffin	2.75	100	5
3	A sweet roll with a cinnamon filling and topped with icing	/images/cinnamon_roll.jpg	Cinnamon Roll	3	75	5
4	A crusty loaf of sourdough bread	/images/sourdough_bread.jpg	Sourdough Bread	4	30	1
5	A freshly baked plain bagel	/images/bagel.jpg	Bagel	1.5	60	1
6	A tangy and sweet lemon tart with a buttery crust	/images/lemon_tart.jpg	Lemon Tart	3.25	40	2
7	A classic apple pie with a flaky crust and spiced apple filling	/images/apple_pie.jpg	Apple Pie	4.5	20	2
8	A long and crusty baguette	/images/baguette.jpg	Baguette	2	50	1
9	A chewy cookie filled with chocolate chips	/images/chocolate_chip_cookie.jpg	Chocolate Chip Cookie	1.75	120	3
10	A moist and spiced carrot cake with cream cheese frosting	/images/carrot_cake.jpg	Carrot Cake	3.75	25	2
11	A rich and creamy chocolate pudding	/images/chocolate_pudding.jpg	Chocolate Pudding	2.5	80	4
12	A light and airy vanilla pudding	/images/vanilla_pudding.jpg	Vanilla Pudding	2.5	80	4
13	A decadent and fudgy brownie	/images/brownie.jpg	Brownie	2	90	3
14	A crispy and flaky puff pastry	/images/puff_pastry.jpg	Puff Pastry	2.75	60	5
15	A sweet and tart cherry pie	/images/cherry_pie.jpg	Cherry Pie	4.5	20	2
16	A savory cheese danish	/images/cheese_danish.jpg	Cheese Danish	3	40	5
17	A sweet and gooey sticky bun	/images/sticky_bun.jpg	Sticky Bun	3.5	50	5
18	A classic New York-style cheesecake	/images/cheesecake.jpg	Cheesecake	4	25	2
19	A fresh and tangy key lime pie	/images/key_lime_pie.jpg	Key Lime Pie	4.5	20	2
20	A light and fluffy sponge cake	/images/sponge_cake.jpg	Sponge Cake	3.75	30	2
21	A hearty multigrain bread loaf	/images/multigrain_bread.jpg	Multigrain Bread	4.5	30	1
22	A sweet and soft sugar cookie	/images/sugar_cookie.jpg	Sugar Cookie	1.5	120	3
23	A moist and dense banana bread	/images/banana_bread.jpg	Banana Bread	3	40	1
24	A rich and buttery brioche	/images/brioche.jpg	Brioche	3.5	35	1
25	A flaky and sweet almond croissant	/images/almond_croissant.jpg	Almond Croissant	3.75	50	5
\.


--
-- Data for Name: sale_order; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sale_order (id, ship_address, total, fk_customer_id, fk_employee_id) FROM stdin;
\.


--
-- Name: cart_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cart_id_seq', 1, false);


--
-- Name: cart_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cart_item_id_seq', 1, false);


--
-- Name: category_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.category_sequence', 1, false);


--
-- Name: order_item_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_item_sequence', 1, false);


--
-- Name: order_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_sequence', 1, false);


--
-- Name: product_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_sequence', 1, false);


--
-- Name: user_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_sequence', 4, true);


--
-- Name: app_user app_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT app_user_pkey PRIMARY KEY (id);


--
-- Name: cart_item cart_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT cart_item_pkey PRIMARY KEY (id);


--
-- Name: cart cart_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (id);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: order_item order_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT order_item_pkey PRIMARY KEY (id);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: sale_order sale_order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale_order
    ADD CONSTRAINT sale_order_pkey PRIMARY KEY (id);


--
-- Name: cart_item uk_r5b99rvdnupujm2h7hh2bh6m7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT uk_r5b99rvdnupujm2h7hh2bh6m7 UNIQUE (product_id);


--
-- Name: cart uk_surd71kgr0t6ityyixak3lq0a; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT uk_surd71kgr0t6ityyixak3lq0a UNIQUE (app_user_id);


--
-- Name: cart_item fk1uobyhgl1wvgt1jpccia8xxs3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT fk1uobyhgl1wvgt1jpccia8xxs3 FOREIGN KEY (cart_id) REFERENCES public.cart(id);


--
-- Name: cart fk3ec32ji648pftldnv912b7ng; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT fk3ec32ji648pftldnv912b7ng FOREIGN KEY (app_user_id) REFERENCES public.app_user(id);


--
-- Name: sale_order fk90a262h25jl8rf2o35fbm4mvn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale_order
    ADD CONSTRAINT fk90a262h25jl8rf2o35fbm4mvn FOREIGN KEY (fk_employee_id) REFERENCES public.app_user(id);


--
-- Name: cart_item fkjcyd5wv4igqnw413rgxbfu4nv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT fkjcyd5wv4igqnw413rgxbfu4nv FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- Name: order_item fkjs3hhxbqu3gtdu2yfhq1t24wq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT fkjs3hhxbqu3gtdu2yfhq1t24wq FOREIGN KEY (fk_product_id) REFERENCES public.product(id);


--
-- Name: order_item fkka6lnp1tw1900lmaygk6ebxap; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT fkka6lnp1tw1900lmaygk6ebxap FOREIGN KEY (fk_sale_order_id) REFERENCES public.sale_order(id);


--
-- Name: sale_order fkki2y4qtyxasek0842ixth8flb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale_order
    ADD CONSTRAINT fkki2y4qtyxasek0842ixth8flb FOREIGN KEY (fk_customer_id) REFERENCES public.app_user(id);


--
-- Name: product fkpxqa5fj6hpcc9mew356eoj68d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkpxqa5fj6hpcc9mew356eoj68d FOREIGN KEY (fk_category_id) REFERENCES public.category(id);


--
-- PostgreSQL database dump complete
--

