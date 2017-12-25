package implementacao;

public class ForumServiceGamificationProxy implements ForumService {
	
	private AchievementStorage achievementStorage;
	
	private ForumService forumService;
	
	public ForumServiceGamificationProxy(ForumService forumService) {
		this.achievementStorage = AchievementStorageFactory.getAchievementStorage();
		this.forumService = forumService;
	}
	
	@Override
	public void addTopic(String user, String topic) {
		forumService.addTopic(user, topic);
		
		Achievement points = new Points("CREATION", 5);
		achievementStorage.addAchievement(user, points);
		
		Achievement badge = new Badge("I CAN TALK");
		achievementStorage.addAchievement(user, badge);
		
	}

	@Override
	public void addComment(String user, String topic, String comment) {
		forumService.addComment(user, topic, comment);
	
		Achievement points = new Points("PARTICIPATION", 3);
		achievementStorage.addAchievement(user, points);

		Achievement badge = new Badge("LET ME ADD");
		achievementStorage.addAchievement(user, badge);
		
	}

	@Override
	public void likeTopic(String user, String topic, String topicUser) {
		forumService.likeTopic(user, topic, topicUser);

		Achievement points = new Points("CREATION", 1);
		achievementStorage.addAchievement(user, points);
		
	}

	@Override
	public void likeComment(String user, String topic, String comment, String commentUser) {
		forumService.likeComment(user, topic, comment, commentUser);
	
		Achievement points = new Points("PARTICIPATION", 1);
		achievementStorage.addAchievement(user, points);

	}

}
