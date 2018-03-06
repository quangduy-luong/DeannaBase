package edu.sjsu.peerconnections.deannabase.views;

public enum Pronouns {
	SHE("She/Her/Hers", 0), HE("He/Him/His", 1), THEY("They/Them/Theirs", 2), OTHER("Other", 3);
	
	private final String pronounList;
	private final int index;
	
	Pronouns(String list, int i)
	{
		pronounList = list;
		index = i;
	}

	public String getPronouns()
	{
		return pronounList;
	}
	
	public int getIndex()
	{
		return index;
	}
}
