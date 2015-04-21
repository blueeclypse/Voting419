import java.util.*;


public class User {
	private String name;
	Random rand = new Random();
	private String identification;
	private String vote;
	
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
	
	public String getRandomNum(int numOfDigits)
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
	
	public String getName(){
		return name;
	}
	
	public String getID(){
		return identification;
	}
	
	public void setID(String id){
		identification = id;
	}
	
	public void setVote(String vote){
		this.vote = vote;
	}
	
	public String getVote(){
		return vote;
	}

}
