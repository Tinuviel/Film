package Film;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

/**
 * Skriver ut frågor och svar om filmer
 * 
 * @author Lovisa Colérus
 * 2014-11-16
 */
public class Main {
    
    /**
     * Startar hela programmet
     * @param args 
     */
    public static void main(String[] args) {
        List<String> _filmList = new ArrayList(readFile("movies.txt"));
        List<String> _genreLista = new ArrayList(readFile("genre.txt"));
       
        Film.splitFile(_filmList);
        Regissor.skapaRegLista();
        Genre.splitFile(_genreLista);
        Genre.skapaGenreLista();
        
        printAntalFilmer();
        printRegLista();
        printGenreLista();
        printMysterieLista();
    }
    
    /**
     * Läser in en fil och lägger varje rad i en plats i en String-lista
     * 
     * @param filename tar in namnet på filen
     * @return file lista över alla rader i filen
     */
    public static List<String> readFile(String filename){
        List<String> file = new ArrayList<> ();
        
        try{
            BufferedReader in = new BufferedReader(new FileReader(filename));
             String str;
             while ((str = in.readLine()) != null){
                 file.add(str);
             }
             in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return file;
    }
    
    /**
     * Skriver ut hur många filmer det finns i filen
     */
    public static void printAntalFilmer()
    {
        System.out.println("Hur många filmer är det totalt? ");
        System.out.println(Film.antalFilmer());
        System.out.println();
    }
    
    /**
     * Skriver ut en fråga och ett svar om regissörer
     * Hänvisar till frågan för mer specifik info
     */
    public static void printRegLista()
    {
        System.out.println("Hur många regissörer finns det totalt?");
        System.out.println(Regissor._regLista.size());
        System.out.println();
        System.out.println("Hur många filmer har respektive regissör med i filen?");
        for(Regissor reg : Regissor._regLista)
        {
            System.out.println(reg.getName() + ": " + reg.antalFilmer());
        }
        System.out.println();
    }
    
    /**
     * Skriver ut hur många filmer det finns i varje Genre
     */
    public static void printGenreLista()
    {
        System.out.println("Hur många filmer finns det i varje genre?");
        for(Genre genre : Genre._genreLista)
        {
            System.out.println(genre.getGenreName() + " " + genre.antalFilmerIGenren());
        }
        System.out.println();
    }
    
    /**
     * Skriver ut vilka filmer som finns i Mysteriegenren
     */
    public static void printMysterieLista()
    {
        Genre genre = Genre._genreLista.get(9);
        System.out.println("Dessa filmer finns i Mysteriegenren: ");
        genre.titlarIEnGenre();
    }
}
