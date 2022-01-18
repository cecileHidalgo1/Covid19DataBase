import java.util.Scanner;
public class authorizationPass {
	int x; 
	public void authorizedOnly() {
		Scanner myScanner = new Scanner(System.in);
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		System.out.print("Please enter the password: "); 
		int toFind = myScanner.nextInt();
		int[] passwords = {213,616,312,226,743,492,771,865,752,495,175,187,797,608,277,139,375,859,823,597,119,194,136,381,589,854,343,376,152,699,402,713,131,704,648,135,361,737,714,831,814,766,488,178,760,364,679,122,856,154};  //Database for Password of Authorized Ppl 
	    boolean found = false;
	    for (int n : passwords) {
	      if (n == toFind) {
	        found = true;
	        break;
	       
	      }
	    }
	    if(found) 
	    	x=1; 
	    else
	    	System.out.println("You are not authorized to enter the Database");
		
	}
	 
}
