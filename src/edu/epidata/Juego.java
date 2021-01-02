package edu.epidata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import edu.epidata.Enfrentable.Enfrentable;
import edu.epidata.Enfrentable.Personaje;

public class Juego 
{
	private List<Enfrentable> enfrentables;
	
	public Juego() 
	{
		this.enfrentables = new ArrayList<Enfrentable>();
	}
	
	public List<Enfrentable> quienesVencen(Enfrentable e, Comparator<Enfrentable> c)
	{
		List<Enfrentable> enfrentablesVencen = enfrentables.stream()
							  							   .map(enfren -> e.enfrentar(enfren, c))
							  							   .distinct()
							  							   .collect(Collectors.toList());
		/*
		for(Enfrentable enfren : enfrentables) 
		{
			enfrentablesVencen.add(e.enfrentar(enfren, c));
			
		}
		*/
		return enfrentablesVencen;
	}
	
	public Enfrentable enfrentar(Enfrentable e1, Enfrentable e2, Comparator<Enfrentable> c) 
	{
		return e1.enfrentar(e2, c);
	}
	
	public boolean addEnfrentable(Enfrentable e) 
	{
		if(e == null)
			return false;
		
		return enfrentables.add(e);
	}
	
	public List<Personaje> ordenarPersonajes(Comparator<Enfrentable> c)
	{
		
		List<Personaje> personajesOrdenados = enfrentables.stream()
								.map(e -> e.ordenar(c))
							    .flatMap(List::stream)
							    .distinct().sorted(c)
								.collect(Collectors.toList());
		
		/*
		 * for(Enfrentable enfrentable : enfrentables) 
		{
			personajesOrdenados.addAll(enfrentable.ordenar(c));
		}
		
		Collections.sort(personajesOrdenados, c);
		*/
		return personajesOrdenados;
	}
}
