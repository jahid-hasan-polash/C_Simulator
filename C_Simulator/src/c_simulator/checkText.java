package c_simulator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jahidhasanpolash
 */
public class checkText {
    
    String processingString;
    boolean b = true;
    public checkText(String text){
        initiate(text);
    }
    
    public void initiate(String text){
        processingString = text;
    }
    
    public String skipHeader(){
        String textReturn = "";
        String testText = getNextLine();
        while(b == true){
            if(testText.startsWith("#")){
                testText = getNextLine();
                System.out.println(testText);
            }
            if(testText.startsWith("int main()") || testText.startsWith("main()")){
                    testText = getNextLine();
            }
            if(testText == null){
                    testText = getNextLine();
            }
            
            textReturn += testText+'\n';  
            testText = getNextLine();
            //System.out.println(textReturn);
        }
        return textReturn;
    }
    
    public String getNextLine(){
        String line = "";
        for(int forward=0;forward < processingString.length();forward++){
            char c = processingString.charAt(forward);
            //If there is a new line the line is complete
            if(c == '\n'){
                initiate(processingString.substring(forward+1));
                if(line.length() ==  0){
                    line = null;
                }
                return line;
            } //If there are some braces
            else if(c == '{' || c == '}'){
                continue;
            }
            else {
                line += c;
            }
        }
        b = false;
        return null;
    }
}





/*

#include<stdio.h>
int main()
{
int x;
int y;
}

*/
