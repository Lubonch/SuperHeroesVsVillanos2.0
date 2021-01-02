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
		if(e == null) return false;
			
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
			personajes.addAll(integrante.getPersonajes());
		}
		return personajes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((integrantes == null) ? 0 : integrantes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Liga other = (Liga) obj;
		if (integrantes == null) {
			if (other.integrantes != null)
				return false;
		} else if (!integrantes.equals(other.integrantes))
			return false;
		return true;
	}

}
