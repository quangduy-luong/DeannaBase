package edu.sjsu.peerconnections.deannabase.views;

public enum Month {
	JAN(0), FEB(1), MAR(2), APR(3), MAY(4), JUN(5), JUL(6), AUG(7), SEPT(8), OCT(9), NOV(10), DEC(11);
	
	private final int index;
	
	Month(int i)
	{
		index = i;
	}
	
	public int getIndex()
	{
		return index;
	}
}
