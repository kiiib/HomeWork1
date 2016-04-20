/**
 * Created by Jianbin Liu on 4/19/2016.
 */
public class Language {
    private String rank;
    private String name;
    private String rating;

    /**
     * Constructor
     * @param rank language rank
     * @param name language name
     * @param rating language rating
     */
    public Language(String rank, String name, String rating){
        this.rank = rank;
        this.name = name;
        this.rating = rating;
    }

    /**
     * get the language rank
     * @return String
     */
    public String getRank() { return rank; }

    /**
     * get the language name
     * @return String
     */
    public String getName() { return name; }

    /**
     * get the language rating
     * @return String
     */
    public String getRating() { return rating; }


}
