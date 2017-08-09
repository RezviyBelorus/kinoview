package service;

import entity.Film;
import util.SiteConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Task implements Callable<List<Film>> {
    private int startPage;
    private int endPage;
    SiteConnector siteConnector;

    public Task(int startPage, int endPage) {
        this.startPage = startPage;
        this.endPage = endPage;
    }

    @Override
    public List<Film> call() throws Exception {
        List<Film> films = new ArrayList<>();
        for (int i = startPage; i < endPage; i++) {
            siteConnector = new SiteConnector(i);
            if (siteConnector != null) {
                films.addAll(KinogoPageParser.parseFilms(siteConnector.getPage(), i));
            }
        }
        return films;
    }


}
