import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Driver {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException
	{

		Scanner scan = new Scanner(System.in);
		String lcv;
		File moves = new File("testMoves.txt");
		File f = new File("testBoard.txt");
		System.out.println("\t___       __   _______   ___       ________  ________  _____ ______   _______           _________  ________          ________  ___  ___  _______   ________  ___  __    _______   ________  ________      ");
		System.out.println("\t|\\  \\     |\\  \\|\\  ___ \\ |\\  \\     |\\   ____\\|\\   __  \\|\\   _ \\  _   \\|\\  ___ \\         |\\___   ___\\\\   __  \\        |\\   ____\\|\\  \\|\\  \\|\\  ___ \\ |\\   ____\\|\\  \\|\\  \\ |\\  ___ \\ |\\   __  \\|\\   ____\\     ");
		System.out.println("\t\\ \\  \\    \\ \\  \\ \\   __/|\\ \\  \\    \\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\   __/|        \\|___ \\  \\_\\ \\  \\|\\  \\       \\ \\  \\___|\\ \\  \\\\\\  \\ \\   __/|\\ \\  \\___|\\ \\  \\/  /|\\ \\   __/|\\ \\  \\|\\  \\ \\  \\___|_    ");
		System.out.println("\t\\ \\  \\  __\\ \\  \\ \\  \\_|/_\\ \\  \\    \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\\\|__| \\  \\ \\  \\_|/__           \\ \\  \\ \\ \\  \\\\\\  \\       \\ \\  \\    \\ \\   __  \\ \\  \\_|/_\\ \\  \\    \\ \\   ___  \\ \\  \\_|/_\\ \\   _  _\\ \\_____  \\   ");
		System.out.println("\t \\ \\  \\|\\__\\_\\  \\ \\  \\_|\\ \\ \\  \\____\\ \\  \\____\\ \\  \\\\\\  \\ \\  \\    \\ \\  \\ \\  \\_|\\ \\           \\ \\  \\ \\ \\  \\\\\\  \\       \\ \\  \\____\\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\____\\ \\  \\\\ \\  \\ \\  \\_|\\ \\ \\  \\\\  \\\\|____|\\  \\  ");
		System.out.println("\t \\ \\____________\\ \\_______\\ \\_______\\ \\_______\\ \\_______\\ \\__\\    \\ \\__\\ \\_______\\           \\ \\__\\ \\ \\_______\\       \\ \\_______\\ \\__\\ \\__\\ \\_______\\ \\_______\\ \\__\\\\ \\__\\ \\_______\\ \\__\\\\ _\\ ____\\_\\  \\ "); 
		System.out.println("\t  \\|____________|\\|_______|\\|_______|\\|_______|\\|_______|\\|__|     \\|__|\\|_______|            \\|__|  \\|_______|        \\|_______|\\|__|\\|__|\\|_______|\\|_______|\\|__| \\|__|\\|_______|\\|__|\\|__|\\_________\\");
		//                           \|_________|
		System.out.println("\nWould you like to play, test, or do nothing? (p/t/q)");
		lcv = scan.next();
		if(lcv.equalsIgnoreCase("Hax")) //don't ask questions you aren't prepared to know the answers to
		{
			System.out.println("Testing mode ACTIVATED");
			for(int i = 1; i<=3; i++)
			{
				Thread.sleep(1000);
				System.out.println("Dev Mode Loading: " + i + "%");
			}
			Thread.sleep(5000); System.out.println("Dev Mode Loading: 5%");
			Thread.sleep(60000); System.out.println("Dev Mode Loading: 99%");
			for(int i = 99; i>=1; i--)
			{
				Thread.sleep(100);
				System.out.println("Reverse Dev Mode Loading: " + i + "%");
			}
			System.out.println("Click to Continue");
			Thread.sleep(2000); System.out.println("Ur an idiot if you clicked");
			Thread.sleep(500);
			System.out.println("Dev Mode Loading: 100%");



			System.out.println("Welcome to...");
			System.out.println("                                                                                                                                                                                         \r\n"
					+ "                                                                                                                                                                                         \r\n"
					+ "TTTTTTTTTTTTTTTTTTTTTTThhhhhhh                                      MMMMMMMM               MMMMMMMM                          tttt                              iiii                      \r\n"
					+ "T:::::::::::::::::::::Th:::::h                                      M:::::::M             M:::::::M                       ttt:::t                             i::::i                     \r\n"
					+ "T:::::::::::::::::::::Th:::::h                                      M::::::::M           M::::::::M                       t:::::t                              iiii                      \r\n"
					+ "T:::::TT:::::::TT:::::Th:::::h                                      M:::::::::M         M:::::::::M                       t:::::t                                                        \r\n"
					+ "TTTTTT  T:::::T  TTTTTT h::::h hhhhh           eeeeeeeeeeee         M::::::::::M       M::::::::::M  aaaaaaaaaaaaa  ttttttt:::::ttttttt   rrrrr   rrrrrrrrr  iiiiiii xxxxxxx      xxxxxxx\r\n"
					+ "        T:::::T         h::::hh:::::hhh      ee::::::::::::ee       M:::::::::::M     M:::::::::::M  a::::::::::::a t:::::::::::::::::t   r::::rrr:::::::::r i:::::i  x:::::x    x:::::x \r\n"
					+ "        T:::::T         h::::::::::::::hh   e::::::eeeee:::::ee     M:::::::M::::M   M::::M:::::::M  aaaaaaaaa:::::at:::::::::::::::::t   r:::::::::::::::::r i::::i   x:::::x  x:::::x  \r\n"
					+ "        T:::::T         h:::::::hhh::::::h e::::::e     e:::::e     M::::::M M::::M M::::M M::::::M           a::::atttttt:::::::tttttt   rr::::::rrrrr::::::ri::::i    x:::::xx:::::x   \r\n"
					+ "        T:::::T         h::::::h   h::::::he:::::::eeeee::::::e     M::::::M  M::::M::::M  M::::::M    aaaaaaa:::::a      t:::::t          r:::::r     r:::::ri::::i     x::::::::::x    \r\n"
					+ "        T:::::T         h:::::h     h:::::he:::::::::::::::::e      M::::::M   M:::::::M   M::::::M  aa::::::::::::a      t:::::t          r:::::r     rrrrrrri::::i      x::::::::x     \r\n"
					+ "        T:::::T         h:::::h     h:::::he::::::eeeeeeeeeee       M::::::M    M:::::M    M::::::M a::::aaaa::::::a      t:::::t          r:::::r            i::::i      x::::::::x     \r\n"
					+ "        T:::::T         h:::::h     h:::::he:::::::e                M::::::M     MMMMM     M::::::Ma::::a    a:::::a      t:::::t    ttttttr:::::r            i::::i     x::::::::::x    \r\n"
					+ "      TT:::::::TT       h:::::h     h:::::he::::::::e               M::::::M               M::::::Ma::::a    a:::::a      t::::::tttt:::::tr:::::r           i::::::i   x:::::xx:::::x   \r\n"
					+ "      T:::::::::T       h:::::h     h:::::h e::::::::eeeeeeee       M::::::M               M::::::Ma:::::aaaa::::::a      tt::::::::::::::tr:::::r           i::::::i  x:::::x  x:::::x  \r\n"
					+ "      T:::::::::T       h:::::h     h:::::h  ee:::::::::::::e       M::::::M               M::::::M a::::::::::aa:::a       tt:::::::::::ttr:::::r           i::::::i x:::::x    x:::::x \r\n"
					+ "      TTTTTTTTTTT       hhhhhhh     hhhhhhh    eeeeeeeeeeeeee       MMMMMMMM               MMMMMMMM  aaaaaaaaaa  aaaa         ttttttttttt  rrrrrrr           iiiiiiiixxxxxxx      xxxxxxx\r\n"
					+ "                                                                                                                                                                                         \r\n"
					+ "                                                                                                                                                                                         \r\n"
					+ "                                                                                                                                                                                         \r\n"
					+ "                                                                                                                                                                                         \r\n"
					+ "                                                                                                                                                                                         \r\n"
					+ "                                                                                                                                                                                         \r\n"
					+ "                                                                                                                                                                                         ");

			Thread.sleep(100);
			System.out.println("What do you want to do:");

			lcv = scan.next();
			lcv = "p";
		}
		if(lcv.equalsIgnoreCase("P"))
		{
			printRules();
			Checkers game = new Checkers();
			game.run();
			Driver.main(args); 
		}
		if(lcv.equalsIgnoreCase("t"))
		{
			System.out.println("test moves or board?");
			lcv = scan.next();
			if(lcv.equalsIgnoreCase("board"))
			{
				Checkers game = new Checkers(f, 2);
				game.run();
				Driver.main(args); 
			}
			else 
			{
				Checkers game = new Checkers();
				System.out.println(game.boardResult(moves));
				Driver.main(args); 
			}
		}



	}
	public static void printRules() 
	{
		System.out.println("Checkers is a game involving two people.");
		System.out.println("Each player will take their turn and each turn is as follows:");
		System.out.println("At the start of each turn you will recieve a list of all your potential moves");
		System.out.println("You will then jump if you can jump");
		System.out.println("Or you will move a piece forward in a diagonal by 1 square");
		System.out.println("Do not move off board");
		System.out.println("If a piece is Kinged then it can move backwards in a diagonal");
		System.out.println("To win, you must eliminate all of the other player's pieces'");
	}
}
