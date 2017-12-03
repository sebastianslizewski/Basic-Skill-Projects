package stateczki;

public class GameSettings {
	
	public static boolean turnOnHardcore(String hardcoreChar , String hardcoreUserType){
		   
		
		   if(hardcoreChar.equals(hardcoreUserType)) {
			   System.out.println("You choose hardcore mode.  ");
			   return true;
		    	
		    } else 
		   System.out.println("You choose normal mode.  ");
		   return false;
	   }

}
