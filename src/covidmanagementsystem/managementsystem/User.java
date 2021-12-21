
package covidmanagementsystem.managementsystem;


import java.util.ArrayList;
import java.util.List;



class Address{
    private String city;
    private String distric;
    private String ward;
    
    Address(){
        city ="";
        distric = "";
        ward = "";
    }
    Address(String city, String distric, String ward){
        this.city = city;
        this.distric = distric;
        this.ward = ward;
    }
    String getCity(){
        return city;
    }
    String getDistric(){
        return distric;
    }
    String getWard(){
        return ward;
    }
    String getAddress(){
        return ward + ", " + distric + ", " + city;
    }
   
}

class TreatmentSite{

    
     String name;
     int capacity;
     int currentNumber;

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }
    TreatmentSite(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }
}
class staHistory{
    private String content;
    private String date;
    staHistory(String content , String date){
        this.content = content;
        this.date = date;
    }
    String getContent(){
        return content;
    }
    String getDate(){
        return date;
    }
    void setContent(String con){
        this.content = con;
    }
    void setDate(String date){
        this.date = date;
    }
    
}
class User {
    private String idCard;
    private String name;
    private String dob;
    private String address;
    private int state;
    private TreatmentSite treatmentSite;
    private String relatedPerson;
    private List<staHistory> statusHistory;
    private double dept;
    private List<String> billCodes;
    User(String idCard, String name, String dob, String address, int state, TreatmentSite treatmentSite, String relatedPerson, List<staHistory> statusHistory , double dept, List<String> billCodes ){
        this.idCard = idCard;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.state = state;
        this.treatmentSite = treatmentSite;
        this.relatedPerson = relatedPerson;
        this.statusHistory = statusHistory;
        this.dept = dept;
        this.billCodes = billCodes;
    }
    
    User(String idCard, String name, String dob, String address, int state, String treatmentSiteName){
        this.idCard = idCard;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.state = state;
        this.treatmentSite = new TreatmentSite(treatmentSiteName);
        this.relatedPerson = null;
        this.statusHistory = null;
        this.dept = 0;
        this.billCodes = null;
    }
    String getID(){
        return idCard;
    }
    String getName(){
        return name;
    }
    String getDOB(){
        return dob;
    }
    String getAddress(){
        return address;
    }
   int getState(){
        return state;
    }
    double getDept(){
        return dept;
    }
    String getRelated(){
        return relatedPerson;
    }
    List<String> getBill(){
        return billCodes;
    }
    List<staHistory> getStatusHistory(){
        return statusHistory;
    }
    TreatmentSite getTreatmentSite(){
        return treatmentSite;
    }
    String getTreatmentSiteName(){
        return treatmentSite.getName();
    }
    
    void setID(String id){
        idCard  = id;
    }
    void setName(String name){
        this.name = name;
    }
    void setDOB(String dob){
        this.dob = dob;
    }
    void setAddress(String add){
        address = add;
    }
    void setState(int t){
        state = t;
    }
    void setDept(double t){
        dept = t;
    }
    void setRelatedPerson(String t){
        relatedPerson = t;
    }
    void setBill(List<String> Bill){
        this.billCodes = Bill;
    }
    void setStatusHistory(List<staHistory> t){
        statusHistory = t;
    }
    void setTreatmentSite(TreatmentSite t){
        treatmentSite = t;
    }
}