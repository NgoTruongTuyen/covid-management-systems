
package covidmanagementsystem.managementsystem;

import java.util.*;


class Bill{
    private String id;
    private String userid;
    private List<String> necessities;
    private List<String> amount;
    private double totalCost;
    private String datetime;
    Bill(String id, String userid,List<String> necessities,List<String> amount,double totalCost,String datetime){
        this.id = id;
        this.userid = userid;
        this.necessities = necessities;
        this.amount = amount;
        this.totalCost = totalCost;
        this.datetime = datetime;
    }
    Bill(String id, String userid,String necessities,String amount,double totalCost,String datetime){
        this.id = id;
        this.userid = userid;
        String temp[] = necessities.split(", ");
        List<String> ne = new ArrayList<String>();
        for(String a : temp){
            ne.add(a);
        }
        temp = amount.split(", ");
        List<String> am = new ArrayList<String>();
        for(String a : temp){
            am.add(a);
        }
        this.necessities = ne;
        this.amount = am;
        this.totalCost = totalCost;
        this.datetime = datetime;
    }
    String getId(){
        return id;
    }
    List<String> getNecessities(){
        return necessities;
    }
    String getNecessitiesList(){
        String rs = "";
        for (String a : necessities){
            rs+=a +",";
        }
        return rs.substring(0, rs.length() - 1);
    }
    List<String> getAmount(){
        return amount;
    }
    String getAmountList(){
        String rs = "";
        for (String a : amount){
            rs+=(a) +",";
        }
        return rs.substring(0, rs.length() - 1);
    }
    String getDate(){
        return datetime;
    }
    double getTotalCost(){
        return totalCost;
    }
    
    void setId( String id){
        this.id = id;
    }
    void setUserid(String userid){
        this.userid = userid;
    }
    void setTotalCost(double totalCost){ 
        this.totalCost = totalCost;
    }
    void setDatetime(String date){
        this.datetime = date;
    }
    void setNecessities(List<String> necessities){
        this.necessities = necessities;
    }
    void setAmount(List<String> amount){
        this.amount = amount;
    }
    void setNecessities(String necessities){
        String temp[] = necessities.split(", ");
        for(String a : temp){
            this.necessities.add(a);
        }
    }
    void setAmount(String amount){
        String temp[] = amount.split(", ");
        for(String a : temp){
            this.amount.add(a);
        }
    }
}