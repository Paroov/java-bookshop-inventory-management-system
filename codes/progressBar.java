/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes;
import interfaces.Login_1;
import interfaces.StartingDashBoard;
import interfaces.StartingDashBoard1;
import interfaces.testingD;
import interfaces.testingD1;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class progressBar {
    public static void main(String[]args){
       
                        testingD1 ob1=new testingD1();
                        //ob1.setUpLoading();
                        ob1.setVisible(true);
                        
                        for(int i=1;i<=100;++i){
                    try{
                        Thread.sleep(80);
                        ob1.pbar.setValue(i);
                        
                        if(i%2==0){
                            ob1.pwait.setText("Loding...");
                            
                        }else{
                            ob1.pwait.setText("Loding");
                        }
                        if(i==100){
                        
                        ob1.setVisible(false);
                        StartingDashBoard o=new StartingDashBoard();
                        //ob1.setUpLoading();
                        o.setVisible(true);
                        }
                    }catch(Exception e){
                                            }
                        }
    }
    }
