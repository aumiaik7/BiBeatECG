/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package display;

import processing.core.PApplet;
import javax.swing.tree.*;


/**
 *
 * @author Aumi
 */
public class ClientStat {//extends PApplet{

    private static boolean stat = false;
     private static boolean checkBox = false;

    private static String IP;

    private String fName = "Not Given";
    private String lName;
    private String leadNo;
    private String sex = "Not selected";
    private String age = "Not Given";
    private static int[] lead1 = new int[512];private static int[] lead2 = new int[512];private static int[] lead3 = new int[512];
    private static int[] leadaVR = null;private static int[] leadaVL = null;private static int[] leadaVF = null;
    private static int[] leadV1 = null;private static int[] leadV2 = null;private static int[] leadV3 = null;
    private static int[] leadV4 = null;private static int[] leadV5 = null;private static int[] leadV6 = null;
    private int sendDataFalag = 0;
    private float gain = 0.9f;
    private String upazila;
    private String pId ;
    
    private String gmailID = "" ;
    private String senderGmailID = "" ;
    private int sendorReceive = 0;
    private int horizontalScalingFlag = 3;
    
    
    private  boolean dataFlag = true;
    private  boolean filterFlag = false;
    EcgDisplay ecgDisplay ;
    DefaultMutableTreeNode node;
    LeadDisplay1 ld1;
    LeadDisplay2 ld2;
    LeadDisplay3 ld3;
    LeadDisplay4 ld4;
    
    
    
    
    

    

    public ClientStat()
    {
        //ecgDisplay = ed;
        
       
    }
    public void sethorScalling(int fl)
    {
        horizontalScalingFlag = fl;
    }
    public int gethorScalling()
    {
        return horizontalScalingFlag;
    }
     public void setUpazila(String up)
    {
        upazila = up;
    }
    public String getUpazila()
    {
        return upazila;
    } 
    public void setPatientId(String id)
    {
        pId = id;
    }
    public String getPatientId()
    {
        return pId;
    }
    public void setSendOrReceive(int a)
    {
        sendorReceive = a;
    }
    public int getSendOrReceive()
    {
        return sendorReceive;
    }
    public void setgmailID(String id)
    {
        gmailID = id;
    }
    public String getgmailID()
    {
        return gmailID;
    }
    public void setSenderGmailID(String id)
    {
        senderGmailID = id;
    }
    public String getSenderGmailID()
    {
        return senderGmailID;
    }
    public void setEcgDisplay(EcgDisplay ed)
    {
        ecgDisplay = ed;
    }
    public EcgDisplay getEcgDisplay()
    {
        return ecgDisplay;
    }
    public void setclientStat(boolean flag)
    {
        stat = flag;
    }

    public boolean getClientStat()
    {
        return stat;
    }

    public void setIpAddress(String ip)
    {
        IP = ip;
    }
    public String getIpAddress()
    {
        return IP;
    }
     public void setPatientName(String fname)
    {
        fName = fname;
        //lName = lname;
    }

     public String getFirstName()
     {
        return fName;
     }

     public String getLastName()
     {
        return lName;
     }

     public void setSelectedLead(String lead)
     {
        leadNo = lead;
     }

     public String getLeadNo()
     {

//         if(ecgDisplay.leadComboBox.getSelectedItem() == "Lead I")
//             leadNo = (String) ecgDisplay.leadComboBox.getSelectedItem();
//
//         else if(ecgDisplay.leadComboBox.getSelectedItem() == "Lead II")
//             leadNo = (String) ecgDisplay.leadComboBox.getSelectedItem();
//         else if(ecgDisplay.leadComboBox.getSelectedItem() == "Lead III")
//             leadNo = (String) ecgDisplay.leadComboBox.getSelectedItem();
//         else if(ecgDisplay.leadComboBox.getSelectedItem() == "Lead aVR")
//             leadNo = (String) ecgDisplay.leadComboBox.getSelectedItem();
//         else if(ecgDisplay.leadComboBox.getSelectedItem() == "Lead aVL")
//             leadNo = (String) ecgDisplay.leadComboBox.getSelectedItem();
//         else if(ecgDisplay.leadComboBox.getSelectedItem() == "Lead aVF")
//             leadNo = (String) ecgDisplay.leadComboBox.getSelectedItem();
//         else if(ecgDisplay.leadComboBox.getSelectedItem() == "Lead V1")
//             leadNo = (String) ecgDisplay.leadComboBox.getSelectedItem();
//         else if(ecgDisplay.leadComboBox.getSelectedItem() == "Lead V2")
//             leadNo = (String) ecgDisplay.leadComboBox.getSelectedItem();
//         else if(ecgDisplay.leadComboBox.getSelectedItem() == "Lead V3")
//             leadNo = (String) ecgDisplay.leadComboBox.getSelectedItem();
//         else if(ecgDisplay.leadComboBox.getSelectedItem() == "Lead V4")
//             leadNo = (String) ecgDisplay.leadComboBox.getSelectedItem();
//         else if(ecgDisplay.leadComboBox.getSelectedItem() == "Lead V5")
//             leadNo = (String) ecgDisplay.leadComboBox.getSelectedItem();
//         else if(ecgDisplay.leadComboBox.getSelectedItem() == "Lead V6")
//             leadNo = (String) ecgDisplay.leadComboBox.getSelectedItem();

        return leadNo;
     }
     public void setSex(String s)
     {
        sex = s;
     }

     public String getSex()
     {
        return sex;
     }
     public void setAge(String a)
     {
        age = a;
     }

     public String getAge()
     {
        return age;
     }

      public void setCheckBox(boolean check)
     {
        checkBox = check;
     }

     public boolean getCheckBox()
     {
        return checkBox;
     }
     public void setGain(float gn)
     {
        gain = gn;
     }

     public float getGain()
     {
        return gain;
     }
     
     public void setLead1(int[] leadI)
     {
         lead1 = leadI;
         
         
         
     }
     public void setLead2(int[] leadII)
     {
         lead2 = leadII;
     }
     public void setLead3(int[] leadIII)
     {
         lead3 = leadIII;
     }
     public void setLeadaVR(int[] leadavr)
     {
         leadaVR = leadavr;
     }
     public void setLeadaVL(int[] leadavl)
     {
         leadaVL = leadavl;
     }
     public void setLeadaVF(int[] leadavf)
     {
         leadaVF = leadavf;
     }
     public void setLeadV1(int[] leadv1)
     {
         leadV1 = leadv1;
     }
     public void setLeadV2(int[] leadv2)
     {
         leadV2 = leadv2;
     }
     public void setLeadV3(int[] leadv3)
     {
         leadV3 = leadv3;
     }
     public void setLeadV4(int[] leadv4)
     {
         leadV4 = leadv4;
     }
     public void setLeadV5(int[] leadv5)
     {
         leadV5 = leadv5;
     }
     public void setLeadV6(int[] leadv6)
     {
         leadV6 = leadv6;
     }
     
     
      public int[] getLead1()
      {
         return lead1;
      }
     public int[] getLead2()
      {
         return lead2;
      }
     public int[] getLead3()
      {
         return lead3;
      }
     public int[] getLeadaVR()
      {
         return leadaVR;
      }
     public int[] getLeadaVL()
      {
         return leadaVL;
      }
     public int[] getLeadaVF()
      {
         return leadaVF;
      }
     public int[] getLeadV1()
      {
         return leadV1;
      }
     public int[] getLeadV2()
      {
         return leadV2;
      }
     public int[] getLeadV3()
      {
         return leadV3;
      }
     public int[] getLeadV4()
      {
         return leadV4;
      }
     public int[] getLeadV5()
      {
         return leadV5;
      }
     public int[] getLeadV6()
      {
         return leadV6;
      }
     
     public void setNode(DefaultMutableTreeNode nod)
     {
         node = nod;
         System.out.println(""+node);
         System.out.println("yappppppppppppppppppppppiiiiiiiiii"+node);
     }

     public DefaultMutableTreeNode getNode()
     {
         return node;
     }
     
     public void sendDataFlag(int df)
     {
         sendDataFalag = df;
     }
     public int getSendDataFlag()
     {
         return sendDataFalag;
     }
     public void leadDisplay(LeadDisplay1 l1,LeadDisplay2 l2,LeadDisplay3 l3,LeadDisplay4 l4)
     {
         ld1 = l1;
         ld2 = l2;
         ld3 = l3;
         ld4 = l4;
     }
     public LeadDisplay1 getDisplay1Object()
     {
         return ld1;
     }
      public LeadDisplay2 getDisplay2Object()
     {
         return ld2;
     }
       public LeadDisplay3 getDisplay3Object()
     {
         return ld3;
     }
        public LeadDisplay4 getDisplay4Object()
     {
         return ld4;
     }
        
    public void dataFalg(boolean fl)
    {
        dataFlag = fl;
    }
    
    public boolean dataFlagStatus()
    {
        return dataFlag;
    }
    public void setFilterFlag(boolean fl2)
    {
        filterFlag = fl2;
    }
    
    public boolean getFilterFlag()
    {
        return filterFlag;
    }
}
//        
//    public void setup () {
//      /*
//       *set the window size:
//       */
//      size(500, 150);
//
//
//
//      /*
//       * Color of the line
//       */
//       stroke(128,0,64);
//       smooth();
//       /*
//        * weight of line
//        */
//       strokeWeight(1);
//
//       background(255,255,240);
//}
///*
// * draw method of this PApplet
// */
//public void draw () {
//
//
//
//            }
//
//
//}
