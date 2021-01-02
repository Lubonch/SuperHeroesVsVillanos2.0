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
				
		return result>0?this:e;
		
	}
	
	public List<Personaje> ordenar(Comparator<Enfrentable> c)
	{
		List<Personaje> personajes = this.getPersonajes();
		Collections.sort(personajes, c);
		return personajes;
		
	}
	protected abstract List<Personaje> getPersonajes();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((nombreFantasia == null) ? 0 : nombreFantasia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enfrentable other = (Enfrentable) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nombreFantasia == null) {
			if (other.nombreFantasia != null)
				return false;
		} else if (!nombreFantasia.equals(other.nombreFantasia))
			return false;
		return true;
	}
}
