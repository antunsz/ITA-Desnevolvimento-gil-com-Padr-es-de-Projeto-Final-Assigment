package implementacao;

import java.util.List;

/**
 * Classe que representa a pontuação
 * */
public class Points extends Achievement {

	private int pontos;

	public Points(String name, int pontos) {
		super(name);
		this.pontos = pontos;
	}

	@Override
	public List<Achievement> tratarConquista(String user, List<Achievement> conquistas) {
		
		for (Achievement achievement : conquistas) {
			if(achievement.equals(this)) {
				Points points = (Points) achievement;
				points.pontos += this.pontos; 
				return conquistas;
			}
		}
		
		conquistas.add(this);
		
		return conquistas;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

}
