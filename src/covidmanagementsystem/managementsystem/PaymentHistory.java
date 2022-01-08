package covidmanagementsystem.managementsystem;


class PaymentHistory {
    private String id;
    private int money;
    private String date;
    
    PaymentHistory(String id, int money, String date){
        this.id = id;
        this.money = money;
        this.date = date;              
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
