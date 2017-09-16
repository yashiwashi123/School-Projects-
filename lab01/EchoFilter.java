import javazoom.jl.player.StdPlayer;

public class EchoFilter {
	public Wave[] waves; 
	public Wave[] ewaves; 

	public EchoFilter(){
		ewaves= new Wave[10];
		waves= new Wave[10];
	}
	
	public Wave get(Wave w){
		
		int counter = 0;
			if (counter == 9) {
				ewaves[counter]=waves[counter-9];
				counter = counter-9;
			}
			else{
				while (counter <9){
					
					double [] leftch= null;
					double [] rightch= null;

					w = new Wave (leftch, rightch);

					leftch = w.getLeft();
					rightch = w.getRight();
					waves[counter] = w;
					counter ++;

				} 
			}
		Wave echowave = waves[counter].plus(ewaves[counter]);
		return echowave;
		}

		/* This is as far as I've gotten with this code. I keep getting Null Pointer Exceptions which makes me 
		assume that the arrays(waves and ewaves) I fill with "waves are actually not filled with anything. I thought of filling my waves with 
		the same functions that were used in MP3player with the hope of having Wave w continuously refresh itself. Obviously it did not work.
*/
		

	} 
