package com.API.Newtech.service;


import com.API.Newtech.model.Film;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {


private final RestTemplate template ;



    public FilmService(RestTemplate template) {
        this.template = template;
    }

    private final String FILMS_API_URL = "https://ghibliapi.herokuapp.com/films/";


    public List<Film> findAllFilms() {
      ResponseEntity<List<Film>> exchange = template.exchange(FILMS_API_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Film>>() {});


      return exchange.getBody();
    }

    public List<Film> findFilmsByTitle(String title) {
       List<Film> filmArray = findAllFilms();
        List<Film> filmList = new ArrayList<>();
        for (int i = 0; i < filmArray.size(); i++) {
            Film film = filmArray.get(i);
            String englishTitle = film.getTitle().toLowerCase();
            String romajiTitle = film.getOriginal_title_romanised().toLowerCase();
            if (englishTitle.contains(title.toLowerCase()) || romajiTitle.contains(title.toLowerCase())) {
                filmList.add(film);
            }
        }
        return filmList;
    }

}
