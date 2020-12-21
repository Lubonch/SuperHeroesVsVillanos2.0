package edu.epidata.Enfrentable;

import java.util.ArrayList;
import java.util.List;

public class Liga extends Enfrentable
{
	private List<Enfrentable> integrantes;
	
	public Liga(String nombre, String nombreFantasia, List<Enfrentable> integrantes) 
	{
		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.integrantes = integrantes;
	}
	
	public Liga(String nombre, String nombreFantasia) 
	{
		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.integrantes = new ArrayList<Enfrentable>();
	}
	
	public boolean addIntegrante(Enfrentable e) 
	{
		return integrantes.add(e);
	}
	
	@Override
	public float getValorAtributo(String key) 
	{
		/*float atrib = 0;
		for(Enfrentable integrante: integrantes) 
		{
			atrib += integrante.getValorAtributo(key);
		}
		return atrib/integrantes.size();*/
		
		return (float) integrantes.stream()
				.mapToDouble(e->e.getValorAtributo(key)).average().orElse(0);
	}

	@Override
	protected List<Personaje> getPersonajes() 
	{
		List<Personaje> personajes = new ArrayList<Personaje>();
		for(Enfrentable integrante: integrantes) 
		{
			if(integrante instanceof Personaje) 
			{
				personajes.addAll(integrante.getPersonajes());
			}
		}
		return personajes;
	}
}
