package edu.epidata.Comparator;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import edu.epidata.Enfrentable.Enfrentable;

public class ComparatorCompuesto implements Comparator<Enfrentable>
{
	private List<Comparator<Enfrentable>> comparators;
	
	public ComparatorCompuesto() 
	{
		comparators = new LinkedList<Comparator<Enfrentable>>();
	}
	
	public ComparatorCompuesto(List<Comparator<Enfrentable>> comparators) 
	{
		this.comparators = comparators;
	}
	
	public boolean addComparator(Comparator<Enfrentable> c) 
	{
		return comparators.add(c);
	}
	
	public boolean addComparator(Comparator<Enfrentable> c, int index) 
	{
		try 
		{
			comparators.add(index, c);
		}
		catch(Exception e) 
		{
			return false;
		}
		
		return true;
	}

	@Override
	public int compare(Enfrentable o1, Enfrentable o2) 
	{
		for (Comparator<Enfrentable> comparator : comparators) 
		{
			int result = comparator.compare(o1, o2);
			if (result != 0) 
            {
                return result;
            }
		}
		return 0;
	}
}
