
package covidmanagementsystem.managementsystem;


import java.sql.Array;
import java.util.*;



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

    public TreatmentSite(String name, int capacity, int currentNumber) {
        this.name = name;
        this.capacity = capacity;
        this.currentNumber = currentNumber;
    }

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
        this.capacity=10000;
        this.currentNumber=0;
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
class ManagementHistory{

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }
    private String id;
    private String content;
    private String date;
    ManagementHistory(String id,String content , String date){
        this.id=id;
        this.content = content;
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
    private List<ManagementHistory> statusHistory;
    private double dept;
    private List<Bill> billCodes;
    User(String idCard, String name, String dob, String address, int state, TreatmentSite treatmentSite, String relatedPerson, List<ManagementHistory> statusHistory , double dept, List<Bill> billCodes ){
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
    
        User(String idCard, String name, String dob, String address, int state, String treatmentSiteName,String relatedPerson){
        this.idCard = idCard;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.state = state;
        this.treatmentSite = new TreatmentSite(treatmentSiteName);
        this.relatedPerson = relatedPerson;
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
    List<Bill> getBill(){
        return billCodes;
    }
    List<ManagementHistory> getStatusHistory(){
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
    void setBill(List<Bill> bill){
        this.billCodes = bill;
    }
    void setStatusHistory(List<ManagementHistory> t){
        statusHistory = t;
    }
    void setTreatmentSite(TreatmentSite t){
        treatmentSite = t;
    }
}