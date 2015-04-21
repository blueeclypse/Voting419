import java.util.*;

public class UserInterface {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Hello would you like to start a new user? y/n");
		String newUser = in.next();
		
		String validation = "123456789";
		User user;
		//new user
		if(newUser.equals("y")){
			//send CLA request for validation number
			System.out.println("Enter your name");
			String name = in.next();
			user = new User(name);
			validation = user.getRandomNum(9);
			
			System.out.println("Your validation number is: " + validation);
		}
		else{//old user
			System.out.println("Enter your validation number");
			validation = in.next();
			//retrieve user from CLA
			//user = CLA.getUser(validation); code for when CLA is done
			user = new User("name");
			System.out.println("Your validation number is: " + validation);
		}

		System.out.println("Enter a identification number");
		String identification = in.next();
		user.setID(identification);
		//send validation#,ID# and vote to CTF
		
		System.out.println("Who are you voting for? 1) Rep or 2) Dem?(Enter 1 or 2)");
		String vote = in.next();
		
		String result = user.getVote()+" "+user.getID()+" "+validation;
		System.out.println("Hi " + user.getName()+ ", you voted for: " + vote + " and your ID is: " + user.getID() + " with a validation number of: " + validation);
	}

}
