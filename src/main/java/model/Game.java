package model;

public class Game {

	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private Player winner;

	public Game() {

	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player Player1, int lifepoints) {
		this.player1 = Player1;
		player1.setLifepoints(lifepoints);
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player Player2, int lifepoints) {
		this.player2 = Player2;
		player2.setLifepoints(lifepoints);
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void getCurrentWinner() {
		if (player1.getLifepoints() <= 0) {
			setWinner(player2);
		}
		if (player2.getLifepoints() <= 0) {
			setWinner(player1);
		}
	}

	public void switchPlayer() {
		if (winner == null) {
			if (currentPlayer == player1) {
				currentPlayer = player2;
			} else {
				currentPlayer = player1;
			}
		}
	}

	public void createDeck(Player player) {
		MonsterCard monster1 = new MonsterCard("Hyo", 3, 800, 1200);
		MonsterCard monster2 = new MonsterCard("Headless Knight", 4, 1450, 1700);
		SpellCard spell1 = new SpellCard("Beast Fangs", "Increases monster ATK and DEF by 300 points");
		SpellCard spell2 = new SpellCard("Blue Medicine", "Increase your Life Points by 400 points");
		TrapCard trap1 = new TrapCard("Compulsory Evacuation Device",
				"Target 1 monster on the field; return that target to the hand");
		FieldCard field1 = new FieldCard("Mountain", "Monsters on the field gain 200 ATK/DEF");
		player.getDeck().addCardToDeck(monster1);
		player.getDeck().addCardToDeck(monster2);
		player.getDeck().addCardToDeck(spell1);
		player.getDeck().addCardToDeck(spell2);
		player.getDeck().addCardToDeck(trap1);
		player.getDeck().addCardToDeck(field1);
	}

	public void startNewGame() {

		player1 = new Player("PLAYER 1", 8000);
		player2 = new Player("PLAYER 2", 8000);

		createDeck(player1);
		createDeck(player2);

		player1.getDeck().shuffleDeck();
		player2.getDeck().shuffleDeck();

		for (int i = 0; i < 5; i++) {
			player1.drawCard();
			player2.drawCard();
		}

		int r = (int) (2 * Math.random());
		if (r == 0) {
			currentPlayer = player1;
			player1.drawCard();
		}
		if (r == 1) {
			currentPlayer = player2;
			player2.drawCard();
		}
		
	}

}
