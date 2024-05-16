package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import data_access_object.CardDAO;

public class Game {

	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private Player winner;
	private Integer turn;
	private long startTime;

	public Game() {
		startTime = System.currentTimeMillis() + 25200000;
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

	public Integer getTurn() {
		return turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public long getStartTime() {
		return startTime;
	}

	public Player getCurrentWinner() {
		if (player1.getLifepoints() <= 0) {
			setWinner(player2);
		}
		if (player2.getLifepoints() <= 0) {
			setWinner(player1);
		}
		if (player1.getDeck().getDeck().size() == 0 && player1.getHand().getCardsInHand().size() == 0) {
			setWinner(player2);
		}
		if (player2.getDeck().getDeck().size() == 0 && player2.getHand().getCardsInHand().size() == 0) {
			setWinner(player1);
		}
		return winner;
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

	public Player getOpponentPlayer() {
		if (currentPlayer.getPlayerName() == player1.getPlayerName()) {
			return player2;
		}
		return player1;
	}

	public void createDeck(Player player, String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			List<String[]> lines = new ArrayList<>();
			String line = "";
			while ((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				lines.add(lineSplit);
			}
			for (int i = 0; i < lines.size(); i++) {
				if (lines.get(i)[0].equalsIgnoreCase("Monster")) {
					MonsterCard monsterCard = new MonsterCard(lines.get(i)[1], Integer.parseInt(lines.get(i)[2]),
							Integer.parseInt(lines.get(i)[3]), Integer.parseInt(lines.get(i)[4]));
					monsterCard.setOwner(player.getPlayerName());
					player.getDeck().addCardToDeck(monsterCard);
					CardDAO.getInstance().insert(monsterCard.getName(), monsterCard.getType(), monsterCard.getLevel(),
							monsterCard.getAttack(), monsterCard.getDefence(), "");
				}
				if (lines.get(i)[0].equalsIgnoreCase("Spell")) {
					SpellCard spellCard = new SpellCard(lines.get(i)[1], lines.get(i)[2]);
					spellCard.setOwner(player.getPlayerName());
					player.getDeck().addCardToDeck(spellCard);
					CardDAO.getInstance().insert(spellCard.getName(), spellCard.getType(), 0, 0, 0,
							spellCard.getEffect());
				}
				if (lines.get(i)[0].equalsIgnoreCase("Trap")) {
					TrapCard trapCard = new TrapCard(lines.get(i)[1], lines.get(i)[2]);
					trapCard.setOwner(player.getPlayerName());
					player.getDeck().addCardToDeck(trapCard);
					CardDAO.getInstance().insert(trapCard.getName(), trapCard.getType(), 0, 0, 0, trapCard.getEffect());
				}
				if (lines.get(i)[0].equalsIgnoreCase("Field")) {
					FieldCard fieldCard = new FieldCard(lines.get(i)[1], lines.get(i)[2]);
					fieldCard.setOwner(player.getPlayerName());
					player.getDeck().addCardToDeck(fieldCard);
					CardDAO.getInstance().insert(fieldCard.getName(), fieldCard.getType(), 0, 0, 0,
							fieldCard.getEffect());
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void endTurn() {
		currentPlayer.setNormalSummoned(false);
		currentPlayer.setSelectedCard(null);
		currentPlayer.setSelectedOpponentCard(null);
		for (int i = 0; i < 5; i++) {
			if (currentPlayer.getField().getMonster().get(i) != null) {
				currentPlayer.getField().getMonster().get(i).setAttacked(false);
			}
		}
		switchPlayer();
		currentPlayer.getField().setPhase("DRAW");
		turn++;
	}

	public void startNewGame() {

		turn = 1;

		player1 = new Player("PLAYER 1", 8000);
		player2 = new Player("PLAYER 2", 8000);

		createDeck(player1, "src/main/resources/file_txt/Deck1.txt");
		createDeck(player2, "src/main/resources/file_txt/Deck2.txt");

		player1.getDeck().shuffleDeck();
		player2.getDeck().shuffleDeck();

		for (int i = 0; i < 5; i++) {
			player1.drawCard();
			player2.drawCard();
		}

		int r = (int) (2 * Math.random());
		if (r == 0) {
			currentPlayer = player1;
		}
		if (r == 1) {
			currentPlayer = player2;
		}
		currentPlayer.getField().setPhase("MAIN 2");
	}

}
