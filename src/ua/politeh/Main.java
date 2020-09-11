package ua.politeh;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FilmLibrary filmLibrary = new FilmLibrary();

        filmLibrary.addFilm(new Film("name1", "producer1", "actor1", (short) 2020, 2.3f, (short) 1500));
        filmLibrary.addFilm(new Film("name2", "producer2", "actor2", (short) 2018, 3.2f, (short) 3500));
        filmLibrary.addFilm(new Film("name3", "producer3", "actor3", (short) 2015, 3.2f, (short) 2500));
        filmLibrary.addFilm(new Film("name4", "producer4", "actor4", (short) 2005, 3.2f, (short) 1500));
        filmLibrary.addFilm(new Film("name5", "producer5", "actor5", (short) 1995, 3.2f, (short) 500));

        Scanner in = new Scanner(System.in);

        while (true) {

            //System.out.println(filmLibrary.toString());
            System.out.println("Hello, " +
                    "enter number from the list\n" +
                    "\n1 Add data to list\n" +
                    "2 Output data from list\n" +
                    "3 Delete data from list\n" +
                    "4 Search Data from the list \n" +
                    "5 Edit rating of films by viewers\n" +
                    "0 Exit");

            switch ((int) checkNum(in)) {
                case 1:
                    addFilm(filmLibrary, in);
                    break;
                case 2:
                    System.out.println(filmLibrary.toString());
                    break;
                case 3:
                    deleteByName(filmLibrary, in);
                    break;
                case 4:
                    generalSearch(filmLibrary, in);
                    break;
                case 5:
                    incRateBy(in, filmLibrary);
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void generalSearch(FilmLibrary fl, Scanner in) {
        System.out.println("Search by" +
                "\n 1 by n last year" +
                "\n 2 by name of main actor" +
                "\n 3 by producer");
        switch ((int) checkNum(in)) {
            case 1:
                lastYear(fl, in);
                break;
            case 2:
                mainActor(fl, in);
                break;
            case 3:
                producer(fl, in);
                break;
        }
    }

    private static void producer(FilmLibrary fl, Scanner in) {
        System.out.println("Enter the title of movie");
        String main = checkString(in, null);
        fl.filmSearch(main);
    }

    private static void mainActor(FilmLibrary fl, Scanner in) {
        System.out.println("Enter surname of main actor");
        String main = checkString(in, null);
        fl.actorSearch(main);
    }

    private static void lastYear(FilmLibrary fl, Scanner in) {
        System.out.println("Enter num of years in which were released movies");
        byte lastYear = (byte) checkShort(in);
        fl.printFilm(lastYear);
    }

    private static void deleteByName(FilmLibrary fl, Scanner in) {
        System.out.println(fl.toString());
        System.out.println("Enter name of film you want do delete:");

        String str = checkString(in, null);
        boolean check = false;
        for (Film f : fl.films
        ) {
            if (f.getNameFmovie().trim().toLowerCase().equals(str.trim().toLowerCase())) {
                fl.filmRemove(fl.films.indexOf(f));
                check = true;
                break;
            }
        }

        System.out.println(fl.toString());
        if (!check) {
            System.out.println(fl.toString());
            System.out.println("Film not found, please enter correct name!");
        } else {
            System.out.println("Done!");
        }
    }

    static short checkShort(Scanner in) {

        while (true) {

            String s = in.nextLine();
            try {
                short a = Short.parseShort(s);
                //System.out.println(a);
                return a;

            } catch (NumberFormatException e) {
                System.out.println("Incorrect input, please try again!");
            }
            return -1;
        }
    }

    static float checkNum(Scanner in) {
        while (true) {

            String s = in.nextLine();
            try {
                float a = Float.parseFloat(s);
                //System.out.println(a);
                return a;

            } catch (NumberFormatException e) {
                System.out.println("Incorrect input, please try again!");
            }
        }
    }

    static String checkString(Scanner in, String[] strings) {
        boolean check = false;
        while (true) {
            String s = in.nextLine();
            if (!(strings == null)) {
                for (String ss :
                        strings) {
                    if ((s.equals(ss))) {
                        check = true;
                        break;
                    } else {
                        check = false;
                    }
                }
            } else {
                check = true;
            }

            if (check) {
                return s;
            } else {
                System.out.print("Please, enter valid commands: [ ");
                for (String s1 : strings
                ) {
                    System.out.print(s1 + " ");
                }
                System.out.println("]");
            }
        }
    }

    static void addFilm(FilmLibrary film, Scanner in) {

        System.out.println("Enter the title of the movie");
        String title = in.nextLine();

        System.out.println("Enter producer of the movie");
        String producer = in.nextLine();

        System.out.println("Enter surname of main actor");
        String surname = in.nextLine();

        System.out.println("Enter year of issue");
        short year = (short) checkNum(in);

        System.out.println("Enter the evaluation of the movie");
        float rating = checkNum(in);

        System.out.println("Enter the count of the viewer");
        short viewer = (short) checkNum(in);

        film.addFilm(new Film(title, producer, surname, year, rating, viewer));
    }

    static void incRateBy(Scanner in, FilmLibrary film) {
        System.out.println("Enter \'add\' for adding rating, \'remove\' for remove rating");

        float delta;

        String sign = checkString(in, new String[]{"add", "remove"});
        if (sign.equals("add")) {
            delta = 1;
        } else if (sign.equals("remove")) {
            delta = -1;
        } else {
            delta = 0;
            System.out.println("delta error!");
        }

        System.out.println("Enter change of rate:");
        float ratedelta = checkNum(in);
        ratedelta = ratedelta * delta;
        System.out.println("Enter count of viewers:");
        short viewers = checkShort(in);
        System.out.println("Enter \'more\' if you want to edit rate of films with more than " + viewers + " viewers \n" +
                "or enter \'less\' if you want to edit rate of films with less than " + viewers + " viewers: ");

        String more = checkString(in, new String[]{"more", "less"});
        boolean mor;
        if (more.equals("more")) {
            mor = true;
        } else if (more.equals("less")) {
            mor = false;
        } else {
            mor = false;
            System.out.println("mor error!");
        }

        film.incRateBy(ratedelta, viewers, mor);
        System.out.println(film.toString());
        System.out.println("Done!");

    }


}
