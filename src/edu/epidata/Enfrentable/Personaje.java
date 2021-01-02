package edu.epidata.Enfrentable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import edu.epidata.Atributo.Atributo;

public class Personaje extends Enfrentable
{
	private Map<String, Atributo> atributos;
	
	public Personaje(String nombre, String nombreFantasia) 
	{
		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		atributos = new HashMap<String, Atributo>();
	}
	
	@Override
	public float getValorAtributo(String key) 
	{
		Atributo atrib = atributos.get(key);
		
		return atrib != null ? atrib.getValor(this) : 0;
	}
	
	public boolean addAtributo(String k, Atributo a) 
	{
		if(k == null || a == null) return false;
		
		return atributos.put(k, a) != null ? true : false;
	}
	
	@Override
	protected List<Personaje> getPersonajes() 
	{
		List<Personaje> personajes = new ArrayList<Personaje>();
		personajes.add(this);
		return personajes;
		
	}

	@Override
	public String toString() 
	{
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append(String.format("Nombre: %1$s nombreFantasia: %2$s",nombre,nombreFantasia));
		for(Map.Entry<String, Atributo> entry : atributos.entrySet()) 
		{
			sbuilder.append(String.format(" %1$s: ",entry.getKey()));
			sbuilder.append(String.format(" %1$s: ",entry.getValue().getValor(this)));
		}
		return sbuilder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((atributos == null) ? 0 : atributos.hashCode());
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
		Personaje other = (Personaje) obj;
		if (atributos == null) {
			if (other.atributos != null)
				return false;
		} else if (!atributos.equals(other.atributos))
			return false;
		return true;
	}
}
