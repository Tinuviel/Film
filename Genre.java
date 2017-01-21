package Film;


import java.util.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

/**
 * Skapar en Genre med hjälp av info från en fil
 *
 * @author Lovisa Colérus
 * 2014-11-16
 */
public class Genre {
    public static List<Genre> _genreLista = new ArrayList<>();
    private List<Film> _filmer = new ArrayList<>();
    private String _name;
    private String _nr;
    
    /**
     * Skapar en Genre
     * Sätter Action-genrens nr manuellt pga det läggs till en punkt för
     * att det är början av filen
     * @param info kommer från splitFile och innehåller genreID och Genrenamn
     */
    public Genre(String[] info)
    {
        _name = info[1];
        if(_name.equals("Action"))
        {
            _nr = "g1";
        }else{
            _nr = info[0];
        }
    }
    
    /**
     * @return _name som är Genrens namn
     */
    public String getGenreName()
    {
        return _name;
    }
    
    /**
     * @return _nr som är Genrens ID-nummer
     */
    public String getGenreNr()
    {
        return _nr;
    }
    
    /**
     * Delar upp listan över rader i filen till attribut i en array
     * 
     * @param fileList får vi in från metoden readFile i Main
     */
    public static void splitFile(List<String> fileList){   
        for (String line : fileList) {
            String[] splitLine = line.split(";");
            Genre genre = new Genre(splitLine);
            _genreLista.add(genre);
           
        }
     }
    
   
    
    /**
     * @return antalet Genrer
     */
    public int getAntalGenre()
    {
        return _genreLista.size();
    }
    
    /**
     * Lägger till en film i en lista över filmer
     * @param film 
     */
    public void addFilm(Film film){
        _filmer.add(film);
    }
    
    /**
     * @return antalet filmer i en viss Genre
     */
    public int antalFilmerIGenren()
    {
        return _filmer.size();
    }
    
    /**
     * Skriver ut vilka filmtitlar som finns i en Genre
     */
    public void titlarIEnGenre()
    {
        for (Film film : _filmer) {
            System.out.println(film.getTitel());  
        }
    }
    
    /**
     * Skapar en Lista för varje Genre med de filmer som hör till den genren. 
     */
    public static void skapaGenreLista()
    {
        for(Film film : Film.getFilmLista())
        {
            String filmGenre = film.getGenre();
            for(Genre genre : _genreLista)
            {
                if(genre.getGenreNr().equals(filmGenre))
                {
                    genre.addFilm(film);
                }
            }
        }
    }
}
