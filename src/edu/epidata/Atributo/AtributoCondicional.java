package edu.epidata.Atributo;

import edu.epidata.Enfrentable.Enfrentable;

public class AtributoCondicional implements Atributo
{
	private String Key1;
	private String Key2;
	private Atributo atributoThen;
	private Atributo atributoElse;
	
	public AtributoCondicional(String Key1, String Key2, Atributo AtributoThen, Atributo AtributoElse) 
	{
		this.Key1 = Key1;
		this.Key2 = Key2;
		this.atributoThen = AtributoThen;
		this.atributoElse = AtributoElse;
	}
	@Override
	public float getValor(Enfrentable e) 
	{
		return e.getValorAtributo(Key1) > e.getValorAtributo(Key2)?atributoThen.getValor(e) : atributoElse.getValor(e); 
	}
		
}
