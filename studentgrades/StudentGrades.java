/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgrades;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jasmineherd
 */

public class StudentGrades {

   static Scanner sc = new Scanner(System.in);
   static NumberFormat formatter = new DecimalFormat("#0.00"); 
   static String  lgrade;
    
    public static void main(String[] args) {
        String studentID;
        
        System.out.println("Welcome to the grade calculator.");
        
        studentID = getID();//priming read
        
        //whenever NOT quit do something
        while(!studentID.equalsIgnoreCase("quit")){
            if(isValid(studentID)){
               gradeStudent(studentID);
               sc.nextLine();
            }
            
            studentID =getID();
            
        }//while
        keepTrack();
                
        System.out.println("Thanks for using the grade calculator");
    }//main
    
    
        public static String getID(){
            String sid;
           
           
           do{
              try{
                  System.out.print("Student ID?('quit' to exit): ");
                  sid = sc.nextLine();
                  if(sid.isEmpty()){
                      System.out.println("Please enter an ID or the work 'quit' ");
                  }
              }catch(Exception e){
                  System.out.println("unexpected/unknown input. Please re-enter");
                  sid = "";
              } 
       
           }while(sid.isEmpty());
            return sid;
            
                    
        }//getID
        
        public static boolean isValid(String sid){
            boolean goodval = false;
            
            if(!sid.substring(0,1).equals("A")){
                System.out.println("ID must start with capital 'A' ");
            }else if (sid.length() != 9){
                System.out.println("ID must have 8 digits after the capital 'A.' ");
            }else{
                try{
                    long id = Long.parseLong(sid.substring(1));
                    if(id <= 0){
                    System.out.println("Numeric part of ID invalid.");
                }else{
                        goodval = true;
                    }
                    
                }catch(Exception e){
                    System.out.println("Must have 8 didgits after the 'A'");
                    
                }
            }                       
            return goodval;
        }//isValid
        
        public static void gradeStudent(String sid){
            double qavg,cavg;
            double q1,q2,q3,q4,q5,qm,mt,pr,fe ;

            
            q1 = getOneScore("Quiz 1 Score");
            q2 = getOneScore("Quiz 2 Score");
            q3 = getOneScore("Quiz 3 Score");
            q4 = getOneScore("Quiz 4 Score");
            q5 = getOneScore("Quiz 5 Score");
            qm =getOneScore("Quiz Makeup Score");
            mt = getOneScore("Midterm Score");
            pr = getOneScore("Problem Score") ;
            //fe = getOneScore("Final Exam Score");
            
            
            double[] q = {q1,q2,q3,q4,q5,qm};
            //SORT AN ARRAY-Acscending order
            Arrays.sort(q);
            qavg = (q[2] +  q[3] + q[4]+  q[5])/4.0;//Quiz average.Drop two lowest scores.(positions 0-1,start at 2)
            if(qavg >= 89.5 && mt >= 89.5 && pr >= 89.5){
                cavg = (qavg +mt + pr)/3.0;
                lgrade = "A";
            }else{
                fe = getOneScore("Final Exam: ");
                cavg = (qavg * .5)+ (mt * .15) + (pr * .1) + (fe * .25);
                if(cavg >= 89.5){
                    lgrade = "A";
                } else if(cavg >=79.5){                    
                    lgrade = "B";
                }else if(cavg >=69.5){
                    lgrade = "C";
                }else if(cavg >= 59.5){
                    lgrade = "D";
                }else{
                    lgrade = "F";
                }
                
            }//big else
            
            System.out.println("Student " + sid + " earned a quiz average of "+
                    formatter.format(qavg) + " a course average of "+ formatter.format(cavg) + 
                    " and a letter grade of "+ lgrade);
            
            /////////////////////////////

                
            
            

            
            
            
        }//gradeStudent
        
        public static double getOneScore(String prompt){
            double s;
            
            do{
                try{
                    System.out.print(prompt + ": ");
                    s = sc.nextDouble();
                    if(s < 0 || s > 125){
                        System.out.println("Scores between 0 and 125 only");
                    }
                }catch(Exception e){
                    System.out.println("Score entry must be numberic: 0-125");
                    sc.nextLine();
                    s = -1;
                            
                }
                
            }while(s < 0 || s > 125);
            return s;
        }
        public static void keepTrack(){
           int grades[]={a,b,c,d,f};
           
           for(int i =0;i<=grades.length();i++){
               

       
            }
        }
             
            
        }
        

    
    

//EXTRA CREDIT KEEP TRACK OF LETTER GRADES -ABCDF- ARRAYS?