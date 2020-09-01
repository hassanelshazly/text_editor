package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	
    // Done: Add a constructor
	public DictionaryLL() {
		dict = new LinkedList<String>();
	}

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// Done: Implement this method
    	String low_word = word.toLowerCase();
    	if(dict.indexOf(low_word) == -1) {
    		dict.add(low_word);
    		return true;
    	}
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        // Done: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        //Done: Implement this method
    	String low_word = s.toLowerCase();
    	if(dict.indexOf(low_word) != -1) 
    		return true;
        return false;
    }

    
}
