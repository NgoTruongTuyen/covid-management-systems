
package covidmanagementsystem.managementsystem;


class Necessities {
    private String id;
    private String name;
    private int limit;
    private int limitTime;
    private int price;
    Necessities(String id, String name, int limit, int limitTime, int price){
        this.id = id;
        this.name = name;
        this.limit = limit;
        this.limitTime = limitTime;
        this.price = price;
    }
    String getID(){
        return id;
    }
    String getName(){
        return name;
    }
    int getLimit(){
        return limit;
    }
    int getLimitTime(){
        return limitTime;
    }
    int getPrice(){
        return price;
    }
    void setID(String id){
        this.id = id;
    }
    void setName(String name){
        this.name= name;
    }
    void setLimit(int limit){
        this.limit = limit;
    }
    void setLimitTime(int LimitTime){
        this.limitTime = limit;
    }
    void setPrice(int price){
        this.price = price;
    }
}
