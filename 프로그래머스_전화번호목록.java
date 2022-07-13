import java.util.*;
public class Solution {
    public static boolean solution(String[] phone_book) {
    	for(int i=0; i<phone_book.length -1; i++) {
    		int hashPhone = phone_book[i].hashCode();
    		int len = phone_book[i].length();
    		for(int j=i+1; j< phone_book.length; j++) {
    			if(phone_book[j].length() >=len && 
    					hashPhone == (phone_book[j].substring(0, len).hashCode())){
    				return false;
    			}
    			else if(phone_book[j].length()<len && 
    					phone_book[i].substring(0, phone_book[j].length())
    					.hashCode() == phone_book[j].hashCode()) {
    				return false;
    			}
			}
    	}
        return true;
    }
}