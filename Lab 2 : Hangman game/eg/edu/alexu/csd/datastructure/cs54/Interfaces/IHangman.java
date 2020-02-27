package eg.edu.alexu.csd.datastructure.cs54;

public interface IHangman {
	void setDictionary(String[] words);
	String selectRandomSecretWord();
	String guess(Character c) throws Exception;
	void setMaxWrongGuesses(Integer max);
}
