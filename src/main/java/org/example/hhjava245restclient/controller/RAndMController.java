package org.example.hhjava245restclient.controller;

import org.example.hhjava245restclient.model.RickAndMortyChar;
import org.example.hhjava245restclient.service.RAndMService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rick")
public class RAndMController {

    private final RAndMService service;

    public RAndMController(RAndMService service) {
        this.service = service;
    }

    @GetMapping
    public List<RickAndMortyChar> getAllChars(){
        return service.getCharacters();
    }

    @GetMapping("/{id}")
    public RickAndMortyChar getCharById(@PathVariable int id){
        return service.getCharacterById(id);
    }
}
