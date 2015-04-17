import java.util.ArrayList;

public  class Player implements Subject
{
	//Fields
	private ArrayList boards;
	protected MoveStrategy move_strategy; //private?
	protected boolean is_turn;
	protected ShipStrategy ship_strategy;
	private int playerNum;

	//Constructor
	public Player(int newPlayerNum)
	{
		playerNum = newPlayerNum;
		boards = new ArrayList();		
	}
	
	//Method to add a new board to the list of Observers
	public void add(Observer b)
	{
		boards.add(b);
		// TODO Auto-generated method stub
	}

	//Method to remove a board from the list of Observers
	public void remove(Observer b)
	{
		int i = boards.indexOf(b);
		if (i>=0)
			boards.remove(b);
		// TODO Auto-generated method stub
	}

	public void makeMove(MoveStrategy newMove)
	{
		move_strategy = newMove;
		Observer board = (Observer)boards.get(1);
		board.update(move_strategy);
	}

	
	
	//public makeMove()
	//public getState()
}
