COPY public.person (id, first_name,last_name, gender, address) FROM stdin;
1	Bom	Dia	Male	suave
2	Olha	So	Female	aquilo
\.


SELECT pg_catalog.setval('public.person_id_seq', 4, true);
