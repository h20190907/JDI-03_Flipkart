package com.flipkart.constant;

/**
 * 
 * @author JEDI-03
 * Enumeration class for Grade
 * 
 */
public enum Grade {
    A(10),
    A_MINUS(9),
    B(8),
    B_MINUS(7),
    C(6),
	C_MINUS(5),
    D(4),
    E(3);

    final private int value;

    /**
     * Parameterized Constructor
     * @param value
     */
    private Grade(int value) {
        this.value = value;
    }

    /**
     * Method to get Grade Value
     * @return Grade Value
     */
    public int hasValue() {
        return this.value;
    }

    /**
     * Method to convert Grade enum to String
     * @return Grade in String
     */
    @Override
    public String toString() {
    	
        final String name = name();
        
        if (name.contains("PLUS")) 
            return name.charAt(0) + "+"; 
        else if (name.contains("MINUS")) 
            return name.charAt(0) + "-"; 
        else 
            return name;
    }

}