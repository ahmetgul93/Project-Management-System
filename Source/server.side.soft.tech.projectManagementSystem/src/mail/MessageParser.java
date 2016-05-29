package mail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MessageParser {

  public static void parse() {
    final List<String> messages = MessageManager.getMessages();
    for (final String message : messages) {
    	Pattern pattern = Pattern.compile("[0-9]+-[A-z]+\\s[A-z]+"); 
    	Matcher matcher = pattern.matcher(message);
    	ArrayList<String> matches = new ArrayList<String>();
    	while (matcher.find()) { 
    		  // Get the matching string  
    		  matches.add( matcher.group() );
    		}
    	
    	for(String match: matches) // TEST
    	{
		 System.out.println(match + " ");
    	}
    	
    }
  }
}
