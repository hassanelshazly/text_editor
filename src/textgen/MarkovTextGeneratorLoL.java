package textgen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private Map<String, List<String>> wordMap; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordMap = new HashMap<String, List<String>>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		// Done: Implement this method
		String [] tempWords = sourceText.split(" ");
		List<String> words = new ArrayList<String>();
		for(String word : tempWords) {
			if(!word.equals("")) {
				words.add(word);
			}
		}
		// if no words available do no thing 
		if(words.size() > 0)  {
			starter = words.get(0);
			// loop over all the words
			for(int i = 0; i < words.size() - 1; i++) {
				if(wordMap.containsKey(words.get(i))) {
					wordMap.get(words.get(i)).add(words.get(i+1));
				} else {
					List<String> temp = new ArrayList<String>();
					temp.add(words.get(i+1));
					wordMap.put(words.get(i), temp);
				}
			}
			// Associate the last word with the first word
			if(wordMap.containsKey(words.get(words.size() - 1))) {
				wordMap.get(words.get(words.size() - 1)).add(starter);
			} else {
				List<String> temp = new ArrayList<String>();
				temp.add(starter);
				wordMap.put(words.get(words.size() - 1), temp);
			}
		}
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // Done: Implement this method
		String text = "";
		if(numWords > 0) {
			text = starter;
			String lastWord = starter;
			if(wordMap.size() != 0) {
				for(int i = 1; i < numWords; i++) {
					List<String> nextWords = wordMap.get(lastWord);
					int rand = rnGenerator.nextInt(nextWords.size());
					lastWord = nextWords.get(rand);
					text += " "+ lastWord;
				}
			}
		}
		return text;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturnAll = "";
		for (String word : wordMap.keySet())
		{
			String toReturn = word + ": ";
			for (String s : wordMap.get(word)) {
				toReturn += s + "->";
			}
			toReturn += "\n";
			toReturnAll += toReturn;
		}
		return toReturnAll;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// Done: Implement this method.
		wordMap = new HashMap<String, List<String>>();
		starter = "";
		train(sourceText);
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */

// not used
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
	    return null;
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


