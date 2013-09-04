import java.io.StringReader;

import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.objectbank.TokenizerFactory;
import edu.stanford.nlp.process.PTBTokenizer.PTBTokenizerFactory;
import edu.stanford.nlp.process.Tokenizer;

/**
 * An example for Homework 0 of 11791 F13
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 */
public class DependencyExample {

	/**
	 * Tokenize a sentence in the argument, and print out 
	 * the tokens to the console.
	 * 
	 * @param args
	 *          Set the first argument as the sentence to 
	 *          be tokenized.
	 */
	public static void main(String[] args) {
    TokenizerFactory<Word> factory = 
    		PTBTokenizerFactory.newTokenizerFactory();
    Tokenizer<Word> tokenizer = 
    		factory.getTokenizer(new StringReader(args[0]));
    System.out.println(tokenizer.tokenize());
  }
}
