package funDifficult;

public class Skyline {
	
	public void skyline() {
	
	int[][]b=new int[][]{{1,11,5},{2,6,7},{3,13,9},{12,7,16},{14,3,25},{19,18,22},{23,13,29},{24,4,28}};
	
	int[]y=new int[10000];
	int i;
	for(int[]o:b)
		for(i=o[0];i<o[2];y[i]=Math.max(y[i++],o[1]));
	for(i=0;i<9999;)
		if(y[i++]!=y[i])
			System.out.print(i+" "+y[i]+" ");
	
	}
	
	public static void main(String[] args) {
		Skyline skyline = new Skyline();
		skyline.skyline();
	}

}
