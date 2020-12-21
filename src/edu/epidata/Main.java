package edu.epidata;

import java.util.Comparator;
import java.util.List;
import edu.epidata.Atributo.*;
import edu.epidata.Comparator.*;
import edu.epidata.Enfrentable.*;

public class Main {

	public static void main(String[] args) 
	{
		Juego game = new Juego();
		
		Comparator<Enfrentable> FuerzaComp = new ComparatorCriterioSimple("Fuerza");
		Comparator<Enfrentable> VelocidadComp = new ComparatorCriterioSimple("Velocidad");
		Comparator<Enfrentable> InteligenciaComp = new ComparatorCriterioSimple("Inteligencia");
		Comparator<Enfrentable> ResistenciaComp = new ComparatorCriterioSimple("Resistencia");
		Comparator<Enfrentable> NombreComp = new ComparatorNombre();
		Comparator<Enfrentable> NombreFantaComp = new ComparatorNombreFantasia();
		
		ComparatorCompuesto CriteriosComp = new ComparatorCompuesto();
		CriteriosComp.addComparator(NombreComp);
		CriteriosComp.addComparator(NombreFantaComp);
		CriteriosComp.addComparator(FuerzaComp);
		CriteriosComp.addComparator(VelocidadComp);
		CriteriosComp.addComparator(InteligenciaComp);
		CriteriosComp.addComparator(ResistenciaComp);
		
		Personaje Ultraman = new Personaje("Shin Hayata","Ultraman");
		Ultraman.addAtributo("Fuerza", new AtributoSimple(100));
		Ultraman.addAtributo("Velocidad", new AtributoSimple(50));
		Ultraman.addAtributo("Inteligencia", new AtributoSimple(40));
		Ultraman.addAtributo("Resistencia", new AtributoMultiplicacion("Fuerza","Inteligencia"));
		
		Personaje Godzilla = new Personaje("Godzilla","Godzilla");
		Godzilla.addAtributo("Fuerza", new AtributoSimple(250));
		Godzilla.addAtributo("Velocidad", new AtributoSimple(10));
		Godzilla.addAtributo("Inteligencia", new AtributoSimple(20));
		Godzilla.addAtributo("Resistencia", new AtributoMultiplicacion("Fuerza","Inteligencia"));
		
		Personaje Gojira = new Personaje("Gojira","Gojira");
		Gojira.addAtributo("Fuerza", new AtributoSimple(300));
		Gojira.addAtributo("Velocidad", new AtributoSimple(20));
		Gojira.addAtributo("Inteligencia", new AtributoSimple(30));
		Gojira.addAtributo("Resistencia", new AtributoMultiplicacion("Fuerza","Inteligencia"));
		
		Personaje Ghidorah = new Personaje("King Ghidorah","King Ghidorah");
		Ghidorah.addAtributo("Fuerza", new AtributoSimple(350));
		Ghidorah.addAtributo("Velocidad", new AtributoSimple(75));
		Ghidorah.addAtributo("Inteligencia", new AtributoSimple(15));
		Ghidorah.addAtributo("Resistencia", new AtributoMultiplicacion("Fuerza","Inteligencia"));
		
		Personaje Gavan = new Personaje("Space Sherrif Gavan","Gavan");
		Gavan.addAtributo("Fuerza", new AtributoSimple(150));
		Gavan.addAtributo("Velocidad", new AtributoSimple(400));
		Gavan.addAtributo("Inteligencia", new AtributoSimple(200));
		Gavan.addAtributo("Resistencia", new AtributoMultiplicacion("Fuerza","Inteligencia"));
		
		Personaje Fourze = new Personaje("Gentaro Kisaragi","Kamen Rider Fourze");
		Fourze.addAtributo("Fuerza", new AtributoSimple(90));
		Fourze.addAtributo("Velocidad", new AtributoSimple(142));
		Fourze.addAtributo("Inteligencia", new AtributoSimple(50));
		Fourze.addAtributo("Resistencia", new AtributoMultiplicacion("Fuerza","Inteligencia"));
		
		Personaje AmbassadorHell = new Personaje("Ambassador Hell","Garagaranda");
		AmbassadorHell.addAtributo("Fuerza", new AtributoSimple(136));
		AmbassadorHell.addAtributo("Velocidad", new AtributoSimple(5));
		AmbassadorHell.addAtributo("Inteligencia", new AtributoSimple(30));
		AmbassadorHell.addAtributo("Resistencia", new AtributoMultiplicacion("Fuerza","Inteligencia"));
		
		Personaje Shredder = new Personaje("Oroku Saki","Shredder");
		Shredder.addAtributo("Fuerza", new AtributoSimple(178));
		Shredder.addAtributo("Velocidad", new AtributoSimple(78));
		Shredder.addAtributo("Inteligencia", new AtributoSimple(260));
		Shredder.addAtributo("Resistencia", new AtributoMultiplicacion("Fuerza","Inteligencia"));
		
		Personaje BlackRx = new Personaje("Kohtaro Minami","Kamen Rider Black Rx");
		BlackRx.addAtributo("Fuerza", new AtributoSimple(900));
		BlackRx.addAtributo("Velocidad", new AtributoSimple(350));
		BlackRx.addAtributo("Inteligencia", new AtributoSimple(600));
		BlackRx.addAtributo("Resistencia", new AtributoMultiplicacion("Fuerza","Inteligencia"));
		
		game.addEnfrentable(Ultraman);
		game.addEnfrentable(Godzilla);
		game.addEnfrentable(Gojira);
		game.addEnfrentable(Ghidorah);
		game.addEnfrentable(Gavan);
		game.addEnfrentable(Fourze);
		game.addEnfrentable(AmbassadorHell);
		game.addEnfrentable(Shredder);
		game.addEnfrentable(BlackRx);
		
		Liga KamenRider = new Liga("Kamen Rider League","KR lague");
		KamenRider.addIntegrante(Fourze);
		KamenRider.addIntegrante(AmbassadorHell);
		KamenRider.addIntegrante(BlackRx);
		
		Liga Kaijus = new Liga("Kaiju League","Kaiju league");
		Kaijus.addIntegrante(Godzilla);
		Kaijus.addIntegrante(Gojira);
		Kaijus.addIntegrante(Ghidorah);
		
		game.addEnfrentable(KamenRider);
		game.addEnfrentable(Kaijus);
		
		System.out.println(game.enfrentar(Ultraman, BlackRx, CriteriosComp).getNombre()+" is the winner!");
		System.out.println(game.enfrentar(KamenRider, Kaijus, CriteriosComp).getNombre()+" is the winner!");
		System.out.println(game.enfrentar(KamenRider, Ultraman, CriteriosComp).getNombre()+" is the winner!");
		
		
		for(Enfrentable vence : game.quienesVencen(Gojira, CriteriosComp)) 
		{
			System.out.println(vence.getNombre());
		}
		
		game.ordenarPersonajes(CriteriosComp);
		
		List<Personaje> PersonajesOrdenados = game.ordenarPersonajes(CriteriosComp);
		for(Personaje pers : PersonajesOrdenados) 
		{
			System.out.println(pers.toString());
		}
	
		
		
		
	}

}
