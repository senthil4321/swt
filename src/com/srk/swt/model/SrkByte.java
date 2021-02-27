package com.srk.swt.model;

public class SrkByte extends PropertyChangeListnerBase {

    public boolean isBit0() {
	return bit0;
    }

    /*
     * https://docs.oracle.com/javase/7/docs/api/java/beans/PropertyChangeSupport.
     * html
     */
    public void setBit0(boolean newValue) {
	boolean oldValue = this.bit0;
	this.bit0 = newValue;
	firePropertyChange("bit0", oldValue, newValue);
	printModel();
    }

    public boolean isBit1() {
	return bit1;
    }

    public void setBit1(boolean bit1) {
	firePropertyChange("bit1", this.bit1, this.bit1 = bit1);
	printModel();
    }

    public boolean isBit2() {
	return bit2;
    }

    public void setBit2(boolean bit2) {
	firePropertyChange("bit2", this.bit2, this.bit2 = bit2);
	printModel();
    }

    public boolean isBit3() {
	return bit3;
    }

    public void setBit3(boolean bit3) {
	firePropertyChange("bit3", this.bit3, this.bit3 = bit3);
	printModel();
    }

    boolean bit0 = false;
    boolean bit1 = false;
    boolean bit2 = false;
    boolean bit3 = false;

    public String printModel() {
	System.out.println(bit0);
	System.out.println(bit1);
	System.out.println(bit2);
	System.out.println(bit3);
	System.out.println();
	return "Test";
    }

}
