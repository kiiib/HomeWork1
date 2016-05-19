/**
 * Created by Jianbin Liu on 5/19/2016.
 */
public abstract class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return String.format("name = %s", getName());
    }
}


