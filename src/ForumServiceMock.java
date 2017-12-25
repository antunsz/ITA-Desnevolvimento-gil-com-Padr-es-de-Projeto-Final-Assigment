package implementacao;

public class ForumServiceMock implements ForumService{

	@Override
	public void addTopic(String user, String topic) {
		System.out.println("Foi adicionado um novo tópico pelo usuário: " +user);
	}

	@Override
	public void addComment(String user, String topic, String comment) {
		System.out.println("Foi adicionado um comentário pelo usuario: " +user);
	}

	@Override
	public void likeTopic(String user, String topic, String topicUser) {
		System.out.println("O usuário " +user + " curtiu um tópico");
	}

	@Override
	public void likeComment(String user, String topic, String comment, String commentUser) {
		System.out.println("O usuário " +user + " comentou um tópico");
	}

}
