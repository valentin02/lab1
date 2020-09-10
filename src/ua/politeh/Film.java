package ua.politeh;

import lombok.Getter;

public class Film {
    @Getter
    private String nameFmovie;
    @Getter
    private String producer;
    @Getter
    private String surname;
    @Getter
    private short yearFissue;
    @Getter
    private float rating;
    @Getter
    private short numFviewer;

    public Film(String nameFmovie, String producer, String surnameActor, short yearFissue, float rating, short numFviewer) {
        this.setNameFmovie(nameFmovie);
        this.setProducer(producer);
        this.setSurname(surnameActor);
        this.setYearFissue(yearFissue);
        this.setRating(rating);
        this.setNumFviewer(numFviewer);
    }

    public void setNameFmovie(String nameFmovie) {
        this.nameFmovie = this.checkString(nameFmovie);
    }

    public void setProducer(String producer) {
        this.producer = this.checkString(producer);
    }

    public void setSurname(String surname) {
        this.surname = this.checkString(surname);
    }

    public void setYearFissue(short yearFissue) {
        this.yearFissue = (yearFissue <= 2020 && yearFissue >= 1985) ? yearFissue : -1; // the first movie was made in 1985
    }

    public void setRating(float rating) {
        this.rating = (rating > -1 && rating <= 10) ? rating : -1;
    }

    public void setNumFviewer(short numFviewer) {
        this.numFviewer = numFviewer > -1 ? numFviewer : -1;
    }

    public String checkString(String X) {
        return X.substring(0, 1).toUpperCase() + X.substring(1, X.length()).toLowerCase();
    }


    @Override
    public String toString() {
        return "\n_____________________________________\nFilm" +
                "\ntitle of movie = '" + nameFmovie + '\'' +
                "\nproducer = '" + producer + '\'' +
                "\nsurname of actor = '" + surname + '\'' +
                "\nyear of issue = " + yearFissue +
                "\nrating of movie = " + rating +
                "\nnumbers of viewer = " + numFviewer +
                "\n_____________________________________\n";
    }
}
