package model;

public class Game {

	private Player player;
	private Player opponent;
	private Player currentPlayer;
	private Player winner;

	public Game() {

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player newPlayer, int lifepoints) {
		this.player = newPlayer;
		player.setLifepoints(lifepoints);
	}

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player opponentPlayer, int lifepoints) {
		this.opponent = opponentPlayer;
		opponent.setLifepoints(lifepoints);
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
		if (player.getLifepoints() <= 0) {
			setWinner(opponent);
		}
		if (opponent.getLifepoints() <= 0) {
			setWinner(player);
		}
	}

	public void switchPlayer() {
		if (winner == null) {
			if (currentPlayer == player) {
				currentPlayer = opponent;
			} else {
				currentPlayer = player;
			}
		}
	}

}
