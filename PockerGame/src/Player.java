/**
 * Created by Jianbin Liu on 4/27/2016.
 */
public class Player {
    private String name = "";    // player name
    private int money = 0;  // player's money
    private int totalCount = 0;
    private int winCount = 0;
    private int loseCount = 0;

    /**
     * Constructor
     * @param name player name
     * @param money player's money
     */
    public Player(String name, int money){
        this.name = name;
        this.money = money;
    }

    /**
     * Constructor
     * @param name player name
     * @param money player's money
     * @param totalCount
     * @param winCount
     * @param loseCount
     */
    public Player(String name, int money, int totalCount, int winCount, int loseCount){

    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getMoney(){
        return this.money;
    }
    public void setMoney(int money){
        this.money = money;
    }

    public int getTotalCount(){
        return this.totalCount;
    }
    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
    }

    public int getWinCount(){
        return this.winCount;
    }
    public void setWinCount(int winCount){
        this.winCount = winCount;
    }

    public int getLoseCount(){
        return this.loseCount;
    }
    public void setLoseCount(int loseCount){
        this.loseCount = loseCount;
    }

    public double getWinningRate(){
        if(this.totalCount == 0) return 0;
        return (new Double(this.winCount) / new Double(this.totalCount)) * 100;
    }



}
