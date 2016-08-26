public enum Turn{

	CIRCLE_PLAYER,	//マルのプレイヤーのターン
	CROSS_PLAYER;	//バツのプレイヤーのターン

	//この手番の状態を返す
	public State getState(){
		switch(this){
			case CIRCLE_PLAYER:
				return State.CIRCLE;
			case CROSS_PLAYER:
				return State.CROSS;
			default:
				return State.EMPTY;
		}
	}
}
