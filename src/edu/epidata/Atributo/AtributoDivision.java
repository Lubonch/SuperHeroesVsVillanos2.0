package edu.epidata.Atributo;

import edu.epidata.Enfrentable.Enfrentable;

public class AtributoDivision extends AtributoOperacion
{

	public AtributoDivision(String Key1, String Key2) {
		super(Key1, Key2);
	}

	@Override
	public float getValor(Enfrentable e) 
	{
		return e.getValorAtributo(Key1) / e.getValorAtributo(Key2);
	}

}
