import java.util.ArrayList;
import java.util.Scanner;

//Ryan Jones
//Kristine Lee
//Kaeyan Jones
//Sepideh Roghanchi
//Tulsi Patel

//Main loop, in standard engine fashion

public class main
{
	
	protected static Player   player1;
	protected static Player   player2;
	protected static Scanner  input;
	protected static String   userInput;
	protected static Board    board1;
	protected static Board    board2;
	protected static int      numOfShips;
	
	//method to display the menu
	public static void displayMenu(int menuType){
		
		if(menuType==0){
			System.out.println("-----------BattleShip--------------");
			System.out.println("-----------Main menu--------");
			System.out.println("S - Start Game");
			System.out.println("Q - quit");
		}
		
		else if(menuType==1){
			System.out.println("-------Board Type-------------");
			System.out.println("L - Large Board ");
			System.out.println("S - Small Board");
			System.out.println("C - Custom Board");
		}
	}
	
	
	
	//Method that allows the user to setup their boards for the game
	private static void setupBoard(){
		int tempCount = numOfShips;
		int x;
		int y;
		char orientation;
		
		System.out.println("Player 1 Board Setup");
		//Player one setups their board
		while(tempCount!=0){
			System.out.print("Input: ");
			
			userInput = input.next();
			x = Integer.parseInt(userInput);
			userInput = input.next();
			y = Integer.parseInt(userInput);
			
			userInput = input.next(); 
			userInput = userInput.toLowerCase();
			orientation = userInput.charAt(0);
			
			if((board1.isValidLocation(x, y)==true)&&(orientation=='l')||(orientation=='r')){
				player1.placeShip(x, y, orientation);
				if(player1.is_valid==true){
					System.out.println("Ship is already in this location.Choose another location to place your ship");
					tempCount--;
				}
			}
			
		}
		
		tempCount = numOfShips;
		
		System.out.println("Player 2 Board Setup");
		//Player two setups their board
		while(tempCount!=0){
			System.out.print("Input: ");
			
			userInput = input.next();
			x = Integer.parseInt(userInput);
			userInput = input.next();
			y = Integer.parseInt(userInput);
			
			userInput = input.next(); 
			userInput = userInput.toLowerCase();
			orientation = userInput.charAt(0);
			
			if((board2.isValidLocation(x, y)==true)&&(orientation=='l')||(orientation=='r')){
				player2.placeShip(x, y, orientation);
				if(player2.is_valid==true){
					System.out.println("Ship is already in this location.Choose another location to place your ship");
					tempCount--;
				}
			}
			
		}
		
		
		
		
		
		
	}
	public static  void getUserMove(){
		
		
		
		
	}
	
	public static void runGame(){
		Boolean gameOver   = false;
		player1.is_turn    = true;
		
		while(!gameOver){
			
			if(player1.is_turn==true){
			
				getUserMove();
			
			
			}
			
			else{
			
			
			
			
			}
			
			
			
		}
		
		
		
	}
	
	public static void setupGame(){
		
		//player 1
		player1  = new Player();
		
		//player 2
		player2  = new Player();
		
		//variable to check if done
		Boolean done = false;
		
		
		displayMenu(1);
		while(!done){
			System.out.print("Input: ");
			userInput = input.next();
			userInput = userInput.toLowerCase();
			
			//Creates a large board
			if(userInput .equals("l")){
				LargeBoardFactory largeBoard = new LargeBoardFactory();
				board1 = new Board(largeBoard.size,largeBoard.num_ships);
				board2 = new Board(largeBoard.size,largeBoard.num_ships);
				board1.register(player1);
				board2.register(player2);
				numOfShips = largeBoard.num_ships;
				done  = true;
			
			}
			//Creates a small board
			else if(userInput.equals("s")){
				SmallBoardFactory smallBoard = new SmallBoardFactory();
				board1 = new Board(smallBoard.size,smallBoard.num_ships);
				board2 = new Board(smallBoard.size,smallBoard.num_ships);
				board1.register(player1);
				board2.register(player2);
				numOfShips = smallBoard.num_ships;
				done = true;
				
			}
			
			//Create a Custom board
			else if(userInput.equals("c")){
				CustomBoardFactory customBoard = new CustomBoardFactory();
				board1 = new Board(customBoard.size,customBoard.num_ships);
				board2 = new Board(customBoard.size,customBoard.num_ships);
				board1.register(player1);
				board2.register(player2);
				numOfShips = customBoard.num_ships;
				done = true;	
			}
			//what was entered was not valid 
			else
				System.out.println("Error: NOT VALID INPUT");
			
		}
		
		//The user is sent this method in which they place their ships on the board
		setupBoard();
		
		//Boards are finally switched once they are setup
		player1.remove(board1);
		player2.remove(board2);
		board1.register(player2);
		board2.register(player1);	
		
		
		
	}
	
	
	public static void main(String[] args)
	{
		//setup scanner for system input
		input = new Scanner(System.in);
		
		//display main menu 
		displayMenu(0);
		boolean quit = false;
		
		//while user has not quit the program
		while (!quit)
		{
			//get user input for main menu 
			System.out.print("Input: ");
			userInput = input.nextLine();
			userInput = userInput.toLowerCase();
			
			//start game
			if(userInput.equals("s")){
				//lunch setup method	
				setupGame();
			
				//start game 
				runGame();
				
			}
			else if(userInput.equals("q")){
				quit = true;
			}
			
			
			
		}
	}
}