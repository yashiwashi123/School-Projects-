public class GatherTweets{ 

	public static void collectTweets(int numtweets, String searchwords, GeoLocation loc,
				     double radius, Query.ResultType type, String outfile) {

	StringTokenizer searchtok = new StringTokenizer(searchwords);
	while (searchtok.hasMoreTokens()) {
	    String word = searchtok.nextToken();
	    SearchTweets tweets= new SearchTweets(new Query(word),numtweets,loc,radius, type);
	    System.out.println("Num Tweets: " + tweets.numTweets());
	    tweets.print();
	    tweets.save(outfile);				
	}
    }

}