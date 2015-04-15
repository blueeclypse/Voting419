import java.util.*;


public class User {
	private String name;
	static Random rand = new Random();
	
	public static void main(String[] args){
		/*System.out.println(getRandomNum(2));
		System.out.println(getRandomNum(5));
		System.out.println(getRandomNum(10));
		System.out.println(getRandomNum(15));
		System.out.println(getRandomNum(27));
		System.out.println(getRandomNum(19));*/
	}
	
	public User(String name){
		this.name = name;
	}
	
	private static String getRandomNum(int numOfDigits)
	{
		String answer = "";
		int max = 9;
		int min = 0;
		int count = 0;
		while(count<numOfDigits){
			int random = rand.nextInt((max-min)+1)+min;
			answer = answer + random; 
			count++;
		}
		return answer;
	}

}
