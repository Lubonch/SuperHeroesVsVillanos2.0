package edu.epidata.Atributo;

import edu.epidata.Enfrentable.Enfrentable;

public class AtributoSimple implements Atributo
{
	private float valor;
	
	public AtributoSimple(float valor) 
	{
		this.valor = valor;
	}
	
	@Override
	public float getValor(Enfrentable e) 
	{
		return this.valor;
	}
	
	public void setValor(float valor) 
	{
		this.valor = valor;
	}
}
