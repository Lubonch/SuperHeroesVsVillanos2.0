package edu.epidata.Atributo;

import edu.epidata.Enfrentable.Enfrentable;

public abstract class AtributoOperacion implements Atributo
{
	protected String Key1;
	protected String Key2;
	
	public AtributoOperacion(String Key1, String Key2) 
	{
		this.Key1 = Key1;
		this.Key2 = Key2;
	}

	@Override
	public abstract float getValor(Enfrentable e);
	
}
