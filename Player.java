public interface Player{
	Player setTurn(Turn turn);
	Turn getTurn();
	Player calc();
	Point getResult();
}
