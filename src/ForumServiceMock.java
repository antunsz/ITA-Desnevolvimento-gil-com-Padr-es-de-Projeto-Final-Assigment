package implementacao;

public class ForumServiceMock implements ForumService{

	@Override
	public void addTopic(String user, String topic) {
		System.out.println("Foi adicionado um novo t�pico pelo usu�rio: " +user);
	}

	@Override
	public void addComment(String user, String topic, String comment) {
		System.out.println("Foi adicionado um coment�rio pelo usuario: " +user);
	}

	@Override
	public void likeTopic(String user, String topic, String topicUser) {
		System.out.println("O usu�rio " +user + " curtiu um t�pico");
	}

	@Override
	public void likeComment(String user, String topic, String comment, String commentUser) {
		System.out.println("O usu�rio " +user + " comentou um t�pico");
	}

}
