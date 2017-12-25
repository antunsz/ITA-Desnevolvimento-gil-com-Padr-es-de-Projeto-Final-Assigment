package implementacao;

import java.util.List;

/**
 * Classe que representa um objetivo
 * */
public class Badge extends Achievement{

	public Badge(String name) {
		super(name);
	}

	@Override
	public List<Achievement> tratarConquista(String user, List<Achievement> conquistas) {
		
		for (Achievement achievement : conquistas) {
			if(achievement.equals(this)) {
				return conquistas;
			}
		}
		
		conquistas.add(this);
		return conquistas;
	}

}
