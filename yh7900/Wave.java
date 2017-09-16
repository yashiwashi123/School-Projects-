import javazoom.jl.player.StdPlayer;

public class Wave {
	private double[] leftchannel;
	private double[] rightchannel;
	public static final int samplerate = 44100;

	public Wave(double Hz, double seconds, double amplitude)
 	{
 		int nsamples = (int)(samplerate*seconds + 0.5);

 		leftchannel= new double[nsamples];
 		rightchannel= new double[nsamples];

 		for (int i = 0; i < leftchannel.length; i++) {
 			leftchannel[i] = amplitude * Math.sin(2*Math.PI*Hz*i/samplerate);
 			rightchannel[i]= amplitude * Math.sin(2*Math.PI*Hz*i/samplerate);

 			}
 			}

 	public Wave (double[] left, double[] right){
	    leftchannel = left;  // XX copy the entire array in this new object (-1)
 		rightchannel = right; 

 	}
 	public Wave (){
 		leftchannel= null;
 		rightchannel= null;
 	}
    // XX good code.  YOu MUST comment it! (-2)
    public Wave plus(Wave b){
 		//for this section I recieved help from Stefanie Walker
 		double[] newLeft = new double[leftchannel.length];
 		double[] newRight = new double[rightchannel.length];
 		for (int i=0; i < leftchannel.length; i++){
 			newLeft[i] = (leftchannel[i] + b.leftchannel[i])/2;
 			newRight[i] = (rightchannel[i] + b.rightchannel[i])/2;
 		}
 		return new Wave (newLeft, newRight);
 		
 	}

 	public void play() 
 		{
 			StdPlayer.playWave(leftchannel, rightchannel);

 		}
 	public double [] getLeft(){
 		return leftchannel;
 	}
 	public double[] getRight(){
 		return rightchannel;
 	}

 		
 	}
