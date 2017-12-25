package teste;

import java.util.Arrays;

import org.junit.Test;

import implementacao.AchievementObserverInventor;
import implementacao.AchievementObserverPartOfTheCommunity;
import implementacao.AchievementStorageFactory;
import implementacao.ForumService;
import implementacao.ForumServiceGamificationProxy;
import implementacao.ForumServiceMock;
import implementacao.MemoryAchievementStorage;

public class TestComponenteGamificacao {

	@Test
	public void testeAdicionandoTopico() {
		
		MemoryAchievementStorage storage = MemoryAchievementStorage.criarMemoryAchievementStorage();
		storage.setObservadores(Arrays.asList(new AchievementObserverInventor(), new AchievementObserverPartOfTheCommunity()));
		
		AchievementStorageFactory.setAchievementStorage(storage);
		
		ForumService forumService = new ForumServiceGamificationProxy(new ForumServiceMock());
		
		forumService.addTopic("jonatas", "Topico de teste1");
		
	}

	@Test
	public void testeAdicionandoComentario() {
		
		MemoryAchievementStorage storage = MemoryAchievementStorage.criarMemoryAchievementStorage();
		storage.setObservadores(Arrays.asList(new AchievementObserverInventor(), new AchievementObserverPartOfTheCommunity()));
		
		AchievementStorageFactory.setAchievementStorage(storage);
		
		ForumService forumService = new ForumServiceGamificationProxy(new ForumServiceMock());
		
		forumService.addComment("jonatas", "topico teste", "comentário aleatório");
		
	}
	
	@Test
	public void testeCurtindoTopico() {
		
		MemoryAchievementStorage storage = MemoryAchievementStorage.criarMemoryAchievementStorage();
		storage.setObservadores(Arrays.asList(new AchievementObserverInventor(), new AchievementObserverPartOfTheCommunity()));
		
		AchievementStorageFactory.setAchievementStorage(storage);
		
		ForumService forumService = new ForumServiceGamificationProxy(new ForumServiceMock());
		
		forumService.likeTopic("jonatas", "topico teste", "usuário aleatório");
		
	}

	@Test
	public void testeCurtindoComentario() {
		
		MemoryAchievementStorage storage = MemoryAchievementStorage.criarMemoryAchievementStorage();
		storage.setObservadores(Arrays.asList(new AchievementObserverInventor(), new AchievementObserverPartOfTheCommunity()));
		
		AchievementStorageFactory.setAchievementStorage(storage);
		
		ForumService forumService = new ForumServiceGamificationProxy(new ForumServiceMock());
		
		forumService.likeComment("jonatas", "topico aleatorio", "coment", "coment user");
		
	}

	@Test
	public void testeAdicionandoTopicoDuasVezes() {
		
		MemoryAchievementStorage storage = MemoryAchievementStorage.criarMemoryAchievementStorage();
		storage.setObservadores(Arrays.asList(new AchievementObserverInventor(), new AchievementObserverPartOfTheCommunity()));
		
		AchievementStorageFactory.setAchievementStorage(storage);
		
		ForumService forumService = new ForumServiceGamificationProxy(new ForumServiceMock());
		
		forumService.addTopic("jonatas", "Topico de teste1");
		forumService.addTopic("jonatas", "Topico de teste2");
		
	}
	
	@Test
	public void testeAdicionandoTopicoVariasVezesAteAtingirOBadgeInventor() {
		
		MemoryAchievementStorage storage = MemoryAchievementStorage.criarMemoryAchievementStorage();
		storage.setObservadores(Arrays.asList(new AchievementObserverInventor(), new AchievementObserverPartOfTheCommunity()));
		
		AchievementStorageFactory.setAchievementStorage(storage);
		
		ForumService forumService = new ForumServiceGamificationProxy(new ForumServiceMock());
		
		for (int i = 0; i <= 20; i++) {
			forumService.addTopic("jonatas", "Topico de teste"+i);
		}
		
	}

	@Test
	public void testeAdicionandoComentarioVariasVezesAteAtingirOBadgePartOfTheCommunity() {
		
		MemoryAchievementStorage storage = MemoryAchievementStorage.criarMemoryAchievementStorage();
		storage.setObservadores(Arrays.asList(new AchievementObserverInventor(), new AchievementObserverPartOfTheCommunity()));
		
		AchievementStorageFactory.setAchievementStorage(storage);
		
		ForumService forumService = new ForumServiceGamificationProxy(new ForumServiceMock());
		
		for (int i = 0; i <= 40; i++) {
			forumService.addComment("jonatas", "Topico de teste"+i, "comentario aleatorio");
		}
		System.out.println(storage.getAchievement("jonatas", "PART OF THE COMMUNITY").getName());
	}

}
