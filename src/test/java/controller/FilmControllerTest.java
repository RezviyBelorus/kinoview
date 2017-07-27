package controller;

import entity.Film;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import service.FilmService;
import web.ModelAndView;
import web.View;
import web.response.FilmDTO;

import static org.junit.Assert.*;

/**
 * Created by alexfomin on 13.07.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class FilmControllerTest {
    @Mock
    private FilmService filmService;

    @InjectMocks
    private FilmController filmController;

    @Test
    public void shuoldUploadFilm() throws Exception {
        FilmDTO film = new FilmDTO(new Film());
        film.setName("testFilm");

        Mockito.when(filmService.save("testFilm", "1980", "1", "2",
                "12:02:01", "4", "123", "321")).thenReturn(film);

        //when
        ModelAndView actual = filmController.upload("testFilm", "1980", "1", "2",
                "12:02:01", "4", "123", "321");

        //then
        assertEquals(View.FILM, actual.getView());
    }

    @Test
    public void shouldDelete() throws Exception {
        //given
        FilmDTO filmDTO = new FilmDTO(new Film());

        Mockito.when(filmService.delete("testFilm")).thenReturn(filmDTO);

        //when
        ModelAndView actual = filmController.delete("testFilm");

        //then
        assertEquals(View.FILM, actual.getView());
    }

    @Test
    public void shouldFindFilm() throws Exception {
        //given
        FilmDTO filmDTO = new FilmDTO(new Film());
        filmDTO.setName("testFilm");

        Mockito.when(filmService.find("testFilm")).thenReturn(filmDTO);

        //when
        ModelAndView actual = filmController.find("testFilm");

        //then
        assertEquals(View.FILM, actual.getView());
    }

    @Test
    public void shouldAddFilmToFavorites() throws Exception {
        //given
        Mockito.when(filmService.addToFavorites("login", "filmName")).thenReturn(true);

        //when
        ModelAndView actual = filmController.addToFavorites("login", "filmName");

        //then
        assertEquals(View.FILM, actual.getView());
    }

    @Test
    public void shouldSetStatus() throws Exception {
        //given
        FilmDTO filmDTO = new FilmDTO(new Film());
        Mockito.when(filmService.setStatus("filmName", "1")).thenReturn(filmDTO);

        //when
        ModelAndView actual = filmController.setStatus("filmName", "1");

        //then
        assertEquals(View.FILM, actual.getView());
    }

}