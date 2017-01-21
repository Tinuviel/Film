package Film;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Skapar en Regissör
 * 
* @author Lovisa Colérus
 * 2014-11-16
 */
public class Regissor {
    private String _name;
    private List<Film> _filmer = new ArrayList<>();
    public static List<Regissor> _regLista = new ArrayList<>();
    
    /**
     * Skapar en Regissör som är definerad genom sitt namn.
     * @param name 
     */
    public Regissor(String name)
    {
        _name = name;
    }
    
    /**
     * @return _name som är namnet på Regissören
     */
    public String getName(){
        return _name;
    }
    
    /**
     * Lägger till en film i en lista över filmer
     * @param film 
     */
    public void addFilm(Film film){
        _filmer.add(film);
    }
    
    /**
     * Skapar en lista för varje Regissör med de filmer som tillhör regissören
     */
    public static void skapaRegLista()
    {
        for(Film film : Film.getFilmLista())
        {
            Regissor tmpReg = new Regissor(film.getRegissor());
            if(_regLista.contains(tmpReg))
            {
                int index = _regLista.indexOf(tmpReg);
                _regLista.get(index).addFilm(film);
            }else{
                tmpReg.addFilm(film);
                _regLista.add(tmpReg);
            }
        }
    }
    
    /**
     * @return antalet filmer för en Regissör
     */
    public int antalFilmer()
    {
        return _filmer.size();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Regissor)
        {
            Regissor r = (Regissor)o;
            return this.getName().equals(r.getName());
        }else{
            return false;
        }
    }
}
