package implementacao;

import java.util.List;

/**
 * Interface para armazenamento de conquistas
 * */
public interface AchievementStorage {
	
	void addAchievement(String user, Achievement a);

	List<Achievement> getAchievements(String user);
	
	Achievement getAchievement(String user, String achievementName);
}
