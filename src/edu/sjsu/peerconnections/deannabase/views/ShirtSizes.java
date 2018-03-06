package edu.sjsu.peerconnections.deannabase.views;

public enum ShirtSizes {
	XS(0), S(1), M(2), L(3), XL(4);
	
	private final int index;
	
	ShirtSizes(int i)
	{
		index = i;
	}
	
	public int getIndex()
	{
		return index;
	}
}
