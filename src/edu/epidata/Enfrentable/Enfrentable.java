package edu.epidata.Enfrentable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Enfrentable 
{
	protected String nombre;
	protected String nombreFantasia;
	
	public String getNombre() 
	{
		return this.nombre;
	}
	
	public String getNombreFantasia() 
	{
		return this.nombreFantasia;
	}
	
	public abstract float getValorAtributo(String key);
	
	public Enfrentable enfrentar(Enfrentable e, Comparator<Enfrentable> c)
	{
		int result = c.compare(this, e);
		
		if(result == 0) return null;
		
		return result>0?this:e;
		
	}
	
	public List<Personaje> ordenar(Comparator<Enfrentable> c)
	{
		List<Personaje> personajes = this.getPersonajes();
		Collections.sort(personajes, c);
		return personajes;
		
	}
	protected abstract List<Personaje> getPersonajes();
}
