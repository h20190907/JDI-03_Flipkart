package com.flipkart.constant;

/**
 * 
 * @author JEDI-03
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
     * Private parameterized constructor
     * @param value
     */
    private Grade(int value) {
        this.value = value;
    }

    
    public int hasValue() {
        return this.value;
    }

    /**
     * Method to print Enum to well format
     * @return
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