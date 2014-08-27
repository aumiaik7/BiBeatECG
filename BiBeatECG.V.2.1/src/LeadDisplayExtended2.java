/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package LeadDisplay;

//import display.ClientStat;
/**
 *
 * @author Aumi
 *///import processing.core.PApplet;
import javax.swing.JOptionPane;
import org.jivesoftware.smack.XMPPException;
import processing.core.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import processing.opengl.*;


/**
 *
 * @author Abul Bashar
 */

public class LeadDisplayExtended2 extends PApplet{




     /*
      * Saves the value of data
      */
      public int yval;

      private int ecgrecord[];
      private int recordBuffer[] = new int[1200];
      static int localBuffer1[] = new int[512];
      private int localBuffer2[] = new int[512];
      private int localBuffer3[] = new int[512];
      
      static int del3Y[] = new int[512];
     /*
      * previous value of x and y
      */
      private int xprev = 0;
      private int yprev = 0;
      private int yprev1 = 0;
      private int localXprev = 0;
      private int localYprev = 0;
      private int offset = 127;
      private int resolution ;
      private double del;
      private int iPos;
      private float localGain = 1.0f;
      private boolean isTrue = false;
      private boolean isLocal1 = false;
      private boolean isLocal2 = false;
      
      private static boolean flag1 = false;
      private boolean flag2 = false;
      private boolean flag3 = false;
     
      private boolean bf1 = false; // bf means Buffer Flag
      private boolean bf2 = false;
     
      private String sendData = "";
     
      
      byte selectLead[] = new byte[9];

      private String filepath = "c:/a1.txt";

      FileWriter outputStream = null;

      private int midpoint = 0;
      ClientStat clstat;
      EcgRecordGraph ecgr;
      EcgDisplay ecgD;
      communication usb;
     
      JabberSmackAPI jabb;
      
 
     
      PImage img;
      float avg = 0;
    

    public LeadDisplayExtended2(ClientStat cs, int r, communication u,EcgRecordGraph er,EcgDisplay ed,JabberSmackAPI j) {
        clstat = cs;
        resolution = r;
        usb = u;
        ecgr = er;
        ecgD = ed;
        jabb = j;
        
        for(int i = 0; i <9 ; i++)
          {

              selectLead[i]=  0;
          }
        
        //utp = ut;
    }








    public void setValue(int[] val) throws XMPPException
    {

        float avg = 0;
     
        

       background(255,255,240);
       strokeWeight( 0.0f);
       stroke(157,157,255);
       smooth();

       /*
        * weight of line
        */
        for(int i = 0; i <= width; i+=5)
        {
            line(i,0,i,height);
        }
       for(int i = 0; i <= height; i+=5)
        {
            line(0,i,width,i);
        }
          stroke(1,7,254);
        smooth();
       /*
        * weight of line
        */
        strokeWeight( 0.4f);

        for(int i = 0; i <= width; i+=25)
        {
            line(i,0,i,height);
        }

        for(int i = 0; i <= height; i+=25)
        {
            line(0,i,width,i);
        }
         /*
       * Color of the line
       */

       

       
      
       
       
       if(clstat.getSendDataFlag() == 1 || clstat.getSendDataFlag() == 3)
       {    
         
          int j = 0;
      
           
               for(j=0;j < val.length; j++)
               {
                   
                    del3Y[j] = (int)(val[j])  ;
               
               }
          
       }
       else if(clstat.getSendDataFlag() == 2)
       {
          int j = 0;
    
           
               for(j=0;j < val.length; j++)
               {
                   
                    del3Y[j] = (int)(val[j])  ;
               
               }
           ecgD.jTabbedPane1.setSelectedIndex(4);
       }

       
       
       
/// For report       
       
       
        
         
            
                
                if(clstat.getSendDataFlag() == 3)
                {
                    sendData = "";
                    sendData += clstat.getFirstName() + "\n";
                    //sendData += clstat.getLastName() + "\n";
                    sendData += clstat.getSex() + "\n";
                    sendData += clstat.getAge() + "\n";
                    sendData += clstat.getLeadNo() + "\n";
                    sendData += clstat.getGain() + "\n";
                    sendData += clstat.getFilterFlag() + "\n";
                    sendData += clstat.getPatientId() + "\n";
                    sendData += clstat.getUpazila() + "\n";
                    sendData += clstat.gethorScalling() + "\n";


                      for(int i = 0; i<del3Y.length;i++)
                    {

                        sendData += del3Y[i] + "\n";
                    }

                    jabb.sendMessage(sendData, clstat.getgmailID());


                  }
                
             

        
                

             
        

/// print data on static display
        
        
       stroke(128,0,64);
       smooth();
       /*
        * weight of line
        */
       strokeWeight(1);




       
       xprev = 0;


         
         //midpoint = 172;
//JOptionPane.showMessageDialog(null, "Helllooooo =" + val.length);
       
       
       if(flag1){
            for(int i = 0; i < 512 ; i++)
              {
               localBuffer2[i] = val[i];
              }
            flag1=false;
       }
       else{
       
          for(int i = 0; i < 512 ; i++)
            {
                localBuffer3[i] = val[i];
            }
          flag1=true;
       }
       
        clstat.setLeadE(localBuffer2, localBuffer3);
       
       
       
       
         for(int i = 0; i < del3Y.length ; i++)
         {
                //yval =  (int) map(ecgrecord[i], 0, 255, 0, height);

                       
                int xto = (int) (i * del);
                float Gain =  clstat.getGain();
                //int yto = height-yval;
                //int yto = val[i] ;
                int yto = 0 ;
                int yto1 = 0 ;
                
               
                yto = (int)(height-del3Y[i]);
                
                yto1 = (int)(height-localBuffer1[i]);
               
                    
                line(xprev,(yprev)+(-25*3), xto,(yto)+(-25*3));

                line(xprev,(yprev1)+(-25*9), xto,(yto1)+(-25*9));    
                
                xprev = xto;
                
                yprev = yto;
                
                yprev1 = yto1;
                
                localBuffer1[i] = del3Y[i];
                

        }
         
//         if(!flag1)
//                {
//                    
//                    isLocal1 = true;
//                    
//                }
//       
        
        
        
        
        
        
        
        
        
//        if(isLocal1)
//       {
//           stroke(128,0,64);
//            //fill(255,255,255,255);
//            smooth();
//           /*
//            * weight of line
//            */
//            strokeWeight(1);
//
//           
//            localXprev = 0;
//           for (int i = 0; i < del3Y.length; i++)
//           {
//               int xto = (int) (i * del);
//                float Gain =  clstat.getGain();
//               
//                int yto = localBuffer1[i] ;
//               
//                yto = height-yto;
//               
//                
//                if(flag2)
//                {
//                    line(localXprev,(localYprev)+(-(25*9)), xto,(yto)+(-(25*9)));
//                    
//                   
//                    
//                }
//                
//                else
//                {
//                    line(localXprev,(localYprev)+(-(25*9)), xto,(yto)+(-(25*9)));
//                    
//                    
//                }
//               
//
//
//                localXprev = xto;
//                localYprev = yto;
//           }
//           
//           
//            flag2 = true;
////           if(flag2)
////           {
////                clstat.setLeadE21(localBuffer1);
////                clstat.setLeadE22(del3Y);
////                midpoint = -(25*3);
////           }
////           else
////           {
////               midpoint = -(25*3);
////           }
//           
//       }

         



    }
      





    /*
 * setupt method of this PApplet
 */
public void setup () {
      /*
       *set the window size:
       */
      //size(774, 664);
     size(501, 301);
      ecgrecord = new int[resolution];

      smooth();
      //

      //hint(ENABLE_DEPTH_SORT);
      //img = loadImage("ecggrid14x12.jpg");

      //hint(DISABLE_DEPTH_TEST);
      //background(img);
      //hint(ENABLE_DEPTH_TEST);

      
      

      //del = width*1.0/resolution;
      del = 1;
      iPos = 0;


      

      /*
       * Color of the line
       */
       stroke(128,0,64);
       smooth();
       /*
        * weight of line
        */
       strokeWeight(1);

       background(255,255,240);
       strokeWeight( 0.0f);
       stroke(157,157,255);
       smooth();
       /*
        * weight of line
        */
        for(int i = 0; i <= width; i+=5)
        {
            line(i,0,i,height);
        }
       for(int i = 0; i <= height; i+=5)
        {
            line(0,i,width,i);
        }
       strokeWeight( 0.4f);
       stroke(1,7,254);
       smooth();
       /*
        * weight of line
        */
        for(int i = 0; i <= width; i+=25)
        {
            line(i,0,i,height);
        }
       for(int i = 0; i <= height; i+=25)
        {
            line(0,i,width,i);
        }
}
/*
 * draw method of this PApplet
 */
public void draw () {





  }
}
