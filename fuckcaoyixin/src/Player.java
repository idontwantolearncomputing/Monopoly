public class Player {
    private String name;
    private int position;
    private int money;

    public Player(String name, int position, int money){
        this.name=name;
        this.position=position;
        this.money=money;
    }

    public  String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
    public int getPosition(){
        return  position;
    }
    public void setPosition(){
        this.position=position;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(){
        this.money=money;
    }
    public void move(int spaces){
        position += spaces;
    }
    public void updateMoney(int amount){
        money += amount;
    }
}