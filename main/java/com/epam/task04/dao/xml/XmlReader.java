package com.epam.task04.dao.xml;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.epam.task04.entity.AngleBracket;

public class XmlReader implements Closeable{
	private final static String WINDOWS_1251_CODING = "windows-1251";
	
	private BufferedReader reader;
    private int symbolInt = 0;
    private char symbol = ' ';
    private StringBuilder string = new StringBuilder("");
    private AngleBracket bracket = new AngleBracket();
    
    public XmlReader(){	}
    
    public XmlReader(File file){
        try{
        	reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file), WINDOWS_1251_CODING));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean isEOF() {
    	if(symbolInt == -1)
    		return true;
    	else return false;
    }
    
    private void readUpToBracket(AngleBracket bracket) throws IOException{
    	if(bracket.isRightNextBracket()) {
			string.append(symbol);
		}
    	while(symbol != bracket.getNextBracket() && !isEOF()) {
    		symbolInt = reader.read();
			symbol = (char)symbolInt;
			if(!bracket.isLeftNextBracket(symbol))
				string.append(symbol);
		}
    	bracket.changeNextBracket();
    }
    
    private void readText() {
    	try {
    		string = new StringBuilder();
    		readUpToBracket(bracket);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    public StringBuilder readLine(){
    	do {
    		readText();
    	} while(XmlLineParser.isSpaces(string));
    	return string;
    }
    
    public void changeFile(File file) {
    	try{
    		reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file), WINDOWS_1251_CODING));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void close() {
    	try {
    		if(reader != null)
    			reader.close();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
}
