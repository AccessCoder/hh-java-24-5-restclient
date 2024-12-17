package org.example.hhjava245restclient.service;

import org.example.hhjava245restclient.model.RickAndMortyChar;
import org.example.hhjava245restclient.model.RickAndMortyResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RAndMService {

    private final RestClient client;

    public RAndMService(RestClient.Builder restClientBuilder) {
        this.client = restClientBuilder.baseUrl("https://rickandmortyapi.com/api/character").build();
    }

    public List<RickAndMortyChar> getCharacters() {
        return client
                .get() //-> REST Methode
                //.uri() -> evtl. URL ergänzen
                .retrieve() // "Drücke" auf Senden und warte auf Antwort!
                .body(RickAndMortyResponse.class) //Wandelt Response in angegebenes Objekt um
                .results();
    }

    public RickAndMortyChar getCharacterById(int id) {
        return client
                .get() //-> REST Methode
                .uri("/"+id) // -> evtl. URL ergänzen
                .retrieve() // "Drücke" auf Senden und warte auf Antwort!
                .body(RickAndMortyChar.class); //Wandelt Response in angegebenes Objekt um

    }
}
