package covidmanagementsystem.managementsystem;


class PaymentHistory {
    private String id;
    private int balance;
    private String date;
    
    PaymentHistory(String id, int balance, String date){
        this.id = id;
        this.balance = balance;
        this.date = date;              
    }
    String getId(){
        return id;
    }
    int getBalance(){
        return balance;
    }
    String getDate(){
        return date;
    }
    
    void setId(String id){
        this.id = id;
    }
    void setBalance(int balance){
        this.balance = balance;
    }
    void setDate(String date){
        this.date = date;
    }
}
