package com.epam.task04.entity;

public class AngleBracket {
	private final static char LEFT_BRACKET = '<';
	private final static char RIGHT_BRACKET = '>';
    private char nextBracket = '<';
    
    public AngleBracket() { };
    
    public boolean isLeftNextBracket() {
    	if(nextBracket == LEFT_BRACKET)
    		return true;
    	else return false;
    }
    
    public boolean isLeftNextBracket(char symbol) {
    	if(symbol == LEFT_BRACKET)
    		return true;
    	else return false;
    }
    
    public boolean isRightNextBracket() {
    	if(nextBracket == RIGHT_BRACKET)
    		return true;
    	else return false;
    }
    
    public boolean isRightNextBracket(char symbol) {
    	if(symbol == RIGHT_BRACKET)
    		return true;
    	else return false;
    }
    
    public void changeNextBracket() {
    	if(nextBracket == LEFT_BRACKET)
    		nextBracket = RIGHT_BRACKET;
    	else
    		nextBracket = LEFT_BRACKET;
    }
    
    public char getNextBracket() {
    	return nextBracket;
    }
}
