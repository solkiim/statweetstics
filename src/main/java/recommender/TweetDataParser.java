// package edu.brown.cs.suggest;
// import java.util.Arrays;
// import com.google.common.base.Splitter;
// import com.google.common.base.CharMatcher;
// import java.util.List;
// import java.util.ArrayList;
// import java.sql.SQLException;
// import java.io.File;
// import java.util.LinkedHashMap;
// import java.io.InputStreamReader;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.util.Iterator;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;
// import java.util.Set;
// import java.util.HashSet;
// import edu.brown.cs.OAuth.Data;
// import edu.brown.cs.suggest.ORM.Tweet;
// public class TweetDataParser implements Parser<List<Tweet>, Data> {
// 	private static final Splitter MY_SPLITTER = Splitter.on(CharMatcher.WHITESPACE).trimResults().omitEmptyStrings();

// 	private Set<String> stopwords = new HashSet<>();

// 	public TweetDataParser() {
// 		stopwords.add("i");
// 		stopwords.add("am");
// 		stopwords.add("the");
// 		stopwords.add("with");
// 		stopwords.add("the");
// 		stopwords.add("a");
// 		stopwords.add("of");
// 		stopwords.add("in");
// 		stopwords.add("on");
// 		stopwords.add("is");
// 		stopwords.add("and");
// 		stopwords.add("that");
// 		stopwords.add("an");
// 		stopwords.add("are");
// 		stopwords.add("when");
// 		stopwords.add("if");
// 		stopwords.add("be");
// 		stopwords.add("so");
// 		stopwords.add("as");
// 		stopwords.add("not");
// 		stopwords.add("would");
// 		stopwords.add("who");
// 	}

// 	//private static final Splitter MY_SPLITTER2 = Splitter.on("|").trimResults().omitEmptyStrings();
// 	public List<Tweet> parse(Data data) {
// 		List<String> timeLine = data.getTimeLineData();
// 		List<Integer> favoriteCount = data.getFavoriteCount();
// 		List<Tweet> res = new ArrayList<>();
// 		assert timeLine.size() == favoriteCount.size() : "timeLine and count not same size";
// 		for (int i = 0; i < timeLine.size(); i++) {
// 			String text = timeLine.get(i);
// 			String newText = normilizeText(text);
// 			int rt = favoriteCount.get(i).intValue();
// 			List<String> words = MY_SPLITTER.splitToList(newText);
// 			words = normilizeWords(words);
// 			if (!(words.size()==0)) {
// 				res.add(new Tweet(words,text,rt));
// 			}
			
// 		}
// 		return res;
		
// 	}
// 	public String normilizeText(String text) {

// 		List<Tuple<String,String>> command = new ArrayList<>();
// 		command.add(new Tuple("http://[^\\s]+"," "));
// 		command.add(new Tuple("https://[^\\s]+"," "));
// 		command.add(new Tuple("\\.\\.+"," "));
// 		command.add(new Tuple("( |^\\s)['!\"$%&'()*+,-./:;<=>?@\\[\\]^_`\\{\\|\\}~']+\\w+( |$)", " "));
// 		command.add(new Tuple("@\\w+", " "));//removes user
// 		command.add(new Tuple("[\\.\\!\\?\\,\\;\\:\\\'\\\"\\-]", ""));
// 		//command.add(new Tuple("[( |^)['!\"$%&'()*+,-./:;<=>?@\\[\\]^_`\\{\\|\\}~']+\\w+( |$)]{2,}", " "));
// 		//System.out.println("input: "+text);
// 		String newText = text;
// 		int i = 0;
// 		for (Tuple<String,String> r : command) {
// 			//i++;
// 			//System.out.println("input"+i+": "+newText);
// 			newText = newText.replaceAll(r.first(),r.second());
// 		}
// 		//i++;
// 		//System.out.println("input"+i+": "+newText);
// 		return newText;
// 	}
// 	public List<String> normilizeWords(List<String> words){
// 		int len = words.size();
// 		List<String> result = new ArrayList<>();
// 		for (String word : words) {
// 			word = word.toLowerCase();
// 			if (!stopwords.contains(word)) {
// 				result.add(word);
// 			}
			
// 		}
// 		return result;
// 	}
	
// 	// }
// 	// public List<List<Tweet>> parse(List<Data> rawList) {
// 	// 	List<Tweet> res = new ArrayList<>();
// 	// 	for (String d : rawList) {
// 	// 		res.add(parse(d));
// 	// 	}
// 	// 	return res;
// 	// }
// }