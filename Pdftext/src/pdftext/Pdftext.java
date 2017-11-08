/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftext;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL1
 */

public class Pdftext {

    /**
     * @param args the command line arguments
     */
    private static final String FILENAME = "C:\\Users\\DELL1\\Desktop\\pdf_list.txt";
    
    public static String multi_extract(String fl) throws IOException
    {  String f[]=fl.split("Desktop");
       PDFManager pdfManager = new PDFManager();
       pdfManager.setFilePath(fl);
       String text= pdfManager.ToText();   
       String str[]= text.split("About ");
       String str1[]= str[1].split("Overview");
       //System.out.println(str1[0]); 
       String str2[]= str[1].split("Developments");
       str2=str2[1].split("1 Analyst");        
       //System.out.println(str2[0].substring(3));
       //List<String> myList = new ArrayList<String>();
       str2[0]=" "+str2[0].substring(3);
       String st =f[1].substring(1).concat(str1[0]+str2[0]);
       System.out.println(st) ;
       return st;
       
       
       
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       ArrayList<String> sb = new ArrayList<String>();
       String s="";
        
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) 
        {
            
	String sCurrentLine;

	    while ((sCurrentLine = br.readLine()) != null) 
                  {
			//System.out.println(sCurrentLine);
                        s=multi_extract(sCurrentLine);
                        sb.add(s);
	            }
        PrintWriter writer = new PrintWriter("C:\\Users\\DELL1\\Desktop\\data.txt", "UTF-8");
        writer.println(sb);
        writer.close();
            
        }
       
      
       
    }
}   
    
