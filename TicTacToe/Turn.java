public enum Turn{

	CIRCLE_PLAYER,	//�}���̃v���C���[�̃^�[��
	CROSS_PLAYER;	//�o�c�̃v���C���[�̃^�[��

	//���̎�Ԃ̏�Ԃ�Ԃ�
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
