package edu.epidata.Comparator;

import java.util.Comparator;

import edu.epidata.Enfrentable.Enfrentable;

public class ComparatorNombreFantasia implements Comparator<Enfrentable>
{

	@Override
	public int compare(Enfrentable o1, Enfrentable o2) 
	{
		return o1.getNombreFantasia().compareTo(o2.getNombreFantasia());
	}
}
