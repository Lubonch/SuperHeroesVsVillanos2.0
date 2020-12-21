package edu.epidata.Comparator;

import java.util.Comparator;

import edu.epidata.Enfrentable.Enfrentable;

public class ComparatorNombre implements Comparator<Enfrentable>
{

	@Override
	public int compare(Enfrentable o1, Enfrentable o2) 
	{
		return o1.getNombre().compareTo(o2.getNombre());
	}
}
