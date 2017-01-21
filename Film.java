package Film;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
/**
 * Skapar en Film med info från en fil
 * 
 * @author Lovisa Colérus
 * 2014-11-16
 */
public class Film {
    private String _genre;
    private String _titel;
    private String _reg;       
    private static List<Film>  _filmLista = new ArrayList<>();
    
    
    /**
     * Skapar en Film
     * @param info kommer från metoden splitFile, 
     * men använder bara de tre intressanta delarna.
     */
    public Film(String[] info)
    {
        _genre = info[0];
        _titel = info[2];
        _reg = info[4];        
    }
    
    /**
     * Delar upp listan över rader i filen till attribut i en array
     * 
     * @param fileList får vi in från metoden readFile i Main
     */
    public static void splitFile(List<String> fileList){
       
        for (String line : fileList) {
            String[] splitLine = line.split(";");
            Film film = new Film(splitLine);
            _filmLista.add(film);
        }
    }
    
    /**
     * @return genre vilket är genreIDt
     */
    public String getGenre()
    {
        return _genre;
    }

    
    /**
     * @return titel som är titeln på filmen
     */
    public String getTitel()
    {
        return _titel;
    }
    
    /**
     * @return reg som är filmens regissör
     */
    public String getRegissor()
    {
        return _reg;
    }
    
    /**
     * Räknar hur många filmer det finns genom att bara lägga till de filmer
     * som har en annorlunda titel
     * @return antalet filmer
     */
    public static int antalFilmer()
    {
        HashSet<String> set = new HashSet<>();
        for (Film film : _filmLista) {
            String filmTitel = film.getTitel();
            set.add(filmTitel);
        }
        return set.size();
    }
    
    /**
     * @return filmLista som är en lista över alla filmer
     */
    public static List<Film> getFilmLista()
    {
        return _filmLista;
    }
}
