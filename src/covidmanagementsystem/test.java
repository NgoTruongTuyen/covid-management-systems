/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package covidmanagementsystem;

import covidmanagementsystem.managementsystem.NecessitiesModify;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class test {
    public static void main(String[] args){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now();
        String a = now.toString();
        a = a.substring(0,10);
        System.out.println(a);
    }
}
