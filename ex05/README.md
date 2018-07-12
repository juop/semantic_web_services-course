---
author:
   name1: Opdenplatz, Juliette
   name2: Haselwanter, Stefan
title:
   main: Semantic Web Services
   sub1: Assignment 5
revision:
   doc: doc.md
   level: 1
   date: 28.04.2018
---

# Task

Write a SPARQL query to retrieve "States of Austria with their capital cities and the geo-coordinates of those cities". 
Run the query against http://dbpedia.org/sparql. 
Submit the complete query and query results.

# SPARQL Query

Note that the first subquery doesn't include Vienna because there is no _seat_ attribute for it, so we do a union where we specifically just include a row for Vienna.
It gets a little ugly but for the sake of completeness we do it like that.

```sparql
SELECT DISTINCT ?state ?state_label ?capital ?capital_label ?lon_label ?lat_label
WHERE {  
  {
    ?state dct:subject dbc:States_of_Austria.
    ?state dbp:seat ?capital.
    ?capital geo:long ?lon_label.
    ?capital geo:lat ?lat_label.
    ?state rdfs:label ?state_label.
    ?capital rdfs:label ?capital_label.
    FILTER (lang(?capital_label)='en' and lang(?state_label)='en')
  } 
  UNION
  {
    ?capital dct:subject dbc:Vienna.
    ?capital geo:long ?lon_label.
    ?capital geo:lat ?lat_label.
    ?capital rdfs:label ?capital_label.
    ?state dct:subject dbc:Vienna.
    ?state rdfs:label ?state_label.
    FILTER ( ?capital_label = "Vienna"@en and ?state_label = "Vienna"@en)
  }
}
``` 

# Result

|state|state_label|capital|capital_label|lon_label|lat_label|
|-----|-----------|-------|-------------|---------|---------|
|[Styria](http://dbpedia.org/resource/Styria)|"Styria"@en|[Graz](http://dbpedia.org/resource/Graz)|"Graz"@en|15.4333|47.0667|
|[Tyrol](http://dbpedia.org/resource/Tyrol_(state))|"Tyrol (state)"@en|[Innsbruck](http://dbpedia.org/resource/Innsbruck)|"Innsbruck"@en|11.3833|47.2667|
|[Carinthia](http://dbpedia.org/resource/Carinthia)|"Carinthia"@en|[Klagenfurt](http://dbpedia.org/resource/Klagenfurt)|"Klagenfurt"@en|14.3|46.6167|
|[Upper Austria](http://dbpedia.org/resource/Upper_Austria)|"Upper Austria"@en|[Linz](http://dbpedia.org/resource/Linz)|"Linz"@en|14.2833|48.3|
|[Salzburg (state)](http://dbpedia.org/resource/Salzburg_(state))|"Salzburg (state)"@en|[Salzburg](http://dbpedia.org/resource/Salzburg)|"Salzburg"@en|13.0333|47.8|
|[Voralberg](http://dbpedia.org/resource/Voralberg)|"Voralberg"@en|[Bregenz](http://dbpedia.org/resource/Bregenz)|"Bregenz"@en|9.74917|47.505|
|[Burgenland](http://dbpedia.org/resource/Burgenland)|"Burgenland"@en|[Eisenstadt](http://dbpedia.org/resource/Eisenstadt)|"Eisenstadt"@en|16.5167|47.85|
|[Lower Austria](http://dbpedia.org/resource/Lower_Austria)|"Lower Austria"@en|[Sankt Pölten](http://dbpedia.org/resource/Sankt_Pölten)|"Sankt Pölten"@en|15.6167|48.2|
|[Vienna](http://dbpedia.org/resource/Vienna)|"Vienna"@en|[Vienna](http://dbpedia.org/resource/Vienna)|"Vienna"@en|16.3667|48.2|
