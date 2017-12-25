package implementacao;

public class AchievementStorageFactory {

	private static AchievementStorage instance;
	
	public static AchievementStorage getAchievementStorage() {
		return instance;
	}
	
	public static void setAchievementStorage(AchievementStorage achievementStorage) {
		instance = achievementStorage; 
	}
	
}
