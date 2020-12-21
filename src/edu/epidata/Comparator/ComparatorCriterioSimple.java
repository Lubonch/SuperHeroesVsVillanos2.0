package edu.epidata.Comparator;

import java.util.Comparator;

import edu.epidata.Enfrentable.Enfrentable;

public class ComparatorCriterioSimple implements Comparator<Enfrentable>
{
	private String atributo;
	
	public ComparatorCriterioSimple(String atributo) 
	{
		this.atributo = atributo;
	}
	@Override
	public int compare(Enfrentable o1, Enfrentable o2) 
	{
		Float val1 = o1.getValorAtributo(atributo);
		Float val2 = o2.getValorAtributo(atributo);
		
		return val1.compareTo(val2);
	}

}
