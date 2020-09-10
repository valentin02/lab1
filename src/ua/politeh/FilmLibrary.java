package ua.politeh;

import java.util.ArrayList;

public class FilmLibrary {
    ArrayList<Film> films;

    public FilmLibrary() {
        this.films = new ArrayList<>();
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public void incRateBy(float delta, int viewerCount, boolean isMore) {

        if (isMore == true) {
            for (int i = 0; i < films.size(); i++) {
                if (films.get(i).getNumFviewer() > viewerCount) {
                    if (delta >= 0) {
                        films.get(i).setRating((films.get(i).getRating() + delta) >= 10 ? 10 : films.get(i).getRating() + delta);
                    } else {
                        films.get(i).setRating((films.get(i).getRating() + delta) <= 0 ? 0 : films.get(i).getRating() + delta);
                    }
                }
            }
        } else {
            for (int i = 0; i < films.size(); i++) {
                if (films.get(i).getNumFviewer() < viewerCount) {
                    if (delta >= 0) {
                        films.get(i).setRating((films.get(i).getRating() + delta) >= 10 ? 10 : films.get(i).getRating() + delta);
                    } else {
                        films.get(i).setRating((films.get(i).getRating() + delta) <= 0 ? 0 : films.get(i).getRating() + delta);
                    }
                }
            }
        }
    }

    public void filmRemove(int X) {
        films.remove(X);
    }

    public void filmSearch(String X) {
        boolean check = false;
        for (int i = 0; i < films.size(); i++) {
            if (X.toUpperCase().equals(films.get(i).getNameFmovie().toUpperCase())) {
                //System.out.println(films.get(i).toString());
                System.out.println(films.get(i).getProducer());
                check = true;
            }
        }
        if (!check) {
            System.out.println("hasn't find");
        }
    }

    public void actorSearch(String X) {
        boolean check = false;
        for (int i = 0; i < films.size(); i++) {
            if (X.toUpperCase().equals(films.get(i).getSurname().toUpperCase())) {
                // System.out.println(films.get(i).toString());
                System.out.println(films.get(i).getNameFmovie());
                check = true;
            }
        }
        if (!check) {
            System.out.println("hasn't find");
        }
    }

    public void printFilm(byte X) {
        boolean check = false;
        for (int i = 0; i < films.size(); i++) {
            if (films.get(i).getYearFissue() <= 2020 && films.get(i).getYearFissue() >= (2020 - X)) {
                //System.out.println(films.get(i).toString());
                System.out.println(films.get(i).getNumFviewer());
                check = true;
            }
        }
        if (!check) {
            System.out.println("hasn't find film");
        }
    }

    @Override
    public String toString() {
        return "FilmLibrary" + films;
    }

}

