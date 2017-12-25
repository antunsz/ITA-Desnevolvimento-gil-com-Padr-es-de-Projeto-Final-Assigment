package implementacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryAchievementStorage implements AchievementStorage{
	
	private static MemoryAchievementStorage memoryAchievementStorage;
	
	private Map<String, List<Achievement>> conquistasDeUsuarios = new HashMap<>();
	
	private List<AchievementObserver> observadores;
	
	private MemoryAchievementStorage() {}
	
	public static MemoryAchievementStorage criarMemoryAchievementStorage() {
		if(memoryAchievementStorage == null) {
			memoryAchievementStorage = new MemoryAchievementStorage();
		}
		return memoryAchievementStorage;
	}
	
	@Override
	public void addAchievement(String user, Achievement conquista) {
		
		List<Achievement> conquistas = 
				conquistasDeUsuarios.containsKey(user) 
				? conquistasDeUsuarios.get(user) : new ArrayList<Achievement>();
		
		conquistas = conquista.tratarConquista(user, conquistas);
		
		conquistasDeUsuarios.put(user, conquistas);
		
		for (AchievementObserver observador : observadores) {
			conquista = obterConquistaSeForDoTipoPoints(conquista, conquistas);
			observador.achievementUpdate(user, conquista);
		}
		
	}

	@Override
	public List<Achievement> getAchievements(String user) {
		return conquistasDeUsuarios.get(user);
	}

	@Override
	public Achievement getAchievement(String user, String achievementName) {
		List<Achievement> conquistas = conquistasDeUsuarios.get(user);
		
		for (Achievement conquista : conquistas) {
			if(conquista.getName().equals(achievementName)){
				return conquista;
			}
		}
		
		return null;
	}

	public void setObservadores(List<AchievementObserver> observadores) {
		this.observadores = observadores;
	}
	
	private Achievement obterConquistaSeForDoTipoPoints(Achievement conquista, List<Achievement> conquistas) {
		if(conquista instanceof Points) {
			for (Achievement conquistaSalva : conquistas) {
				if(conquistaSalva.equals(conquista))
					conquista = conquistaSalva;
			} 
		}
		return conquista;
	}

}
