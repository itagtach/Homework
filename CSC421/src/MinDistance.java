import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinDistance {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//Start running 10 points
		int[][] A10 = new int[2][10];		
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/Nacho/Downloads/tests&solution/10points.txt"))) {
		    String line;
		    int c =0;
		    while ((line = br.readLine()) != null) {
		       String[] token = line.split("\\s");
		       A10[0][c] = Integer.parseInt(token[0]);
		       A10[1][c] = Integer.parseInt(token[1]);
		       c++;
		    }
		}
		
        Arrays.sort(A10, new Comparator<int[]>() {
            public int compare(int[] entry1, int[] entry2) {
                int t1 = entry1[0];
                int t2 = entry2[0];
                return (t1 < t2) ? t2: t1;
            }
        });

        int[] points = new int[4];
		
        int[][] X = A10;
		
        Arrays.sort(A10, new Comparator<int[]>() {
            public int compare(int[] entry1, int[] entry2) {
                int t1 = entry1[1];
                int t2 = entry2[1];
                return (t1 < t2) ? t2: t1;
            }
        });
		
		int[][] Y = A10;
		
		double[] min = {distance(A10[0][0],A10[1][0],A10[0][1],A10[1][1]),A10[0][0],A10[1][0],A10[0][1],A10[1][1]};
		min = (minDistance(X, Y, min));
		System.out.println("For 10 points Minimum Distance: " +min[0] + ":  (" +(int)min[1] + ", " +(int)min[2] + ")<-->(" +(int)min[3] + ", " +(int)min[4] + ") ");

		//start running 100 points
		int[][] A100 = new int[2][100];		
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/Nacho/Downloads/tests&solution/100points.txt"))) {
		    String line;
		    int c =0;
		    while ((line = br.readLine()) != null) {
		       String[] token = line.split("\\s");
		       A100[0][c] = Integer.parseInt(token[0]);
		       A100[1][c] = Integer.parseInt(token[1]);
		       c++;
		    }
		}
        Arrays.sort(A100, new Comparator<int[]>() {
            public int compare(int[] entry1, int[] entry2) {
                int t1 = entry1[0];
                int t2 = entry2[0];
                return (t1 < t2) ? t2: t1;
            }
        });

       
        X = A100;
		
        Arrays.sort(A100, new Comparator<int[]>() {
            public int compare(int[] entry1, int[] entry2) {
                int t1 = entry1[1];
                int t2 = entry2[1];
                return (t1 < t2) ? t2: t1;
            }
        });
		
		Y = A100;
		
		double[] min100 = {distance(A10[0][0],A10[1][0],A10[0][1],A10[1][1]),A10[0][0],A10[1][0],A10[0][1],A10[1][1]};
		min = (minDistance(X, Y, min100));
		System.out.println("For 100 points Minimum Distance: " +min[0] + ":  (" +(int)min[1] + ", " +(int)min[2] + ")<-->(" +(int)min[3] + ", " +(int)min[4] + ") ");

		//start running 1000 points
		int[][] A1000 = new int[2][1000];		
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/Nacho/Downloads/tests&solution/1000points.txt"))) {
		    String line;
		    int c =0;
		    while ((line = br.readLine()) != null) {
		       String[] token = line.split("\\s");
		       A1000[0][c] = Integer.parseInt(token[0]);
		       A1000[1][c] = Integer.parseInt(token[1]);
		       c++;
		    }
		}
        Arrays.sort(A1000, new Comparator<int[]>() {
            public int compare(int[] entry1, int[] entry2) {
                int t1 = entry1[0];
                int t2 = entry2[0];
                return (t1 < t2) ? t2: t1;
            }
        });

       
        X = A1000;
		
        Arrays.sort(A1000, new Comparator<int[]>() {
            public int compare(int[] entry1, int[] entry2) {
                int t1 = entry1[1];
                int t2 = entry2[1];
                return (t1 < t2) ? t2: t1;
            }
        });
		
		Y = A1000;
		
		double[] min1000 = {distance(A1000[0][0],A1000[1][0],A1000[0][1],A1000[1][1]),A1000[0][0],A1000[1][0],A1000[0][1],A1000[1][1]};
		min = (minDistance(X, Y, min1000));
		System.out.println("For 1000 points Minimum Distance: " +min[0] + ":  (" +(int)min[1] + ", " +(int)min[2] + ")<-->(" +(int)min[3] + ", " +(int)min[4] + ") ");

	
	}
	
	//return the distance between two points
	public static double distance(int x1, int y1, int x2, int y2){
		return Math.pow((Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2)),.5);
	}
	//prints entire array for testing purposes
	public static void printarray(int[][] temp){
		for(int i = 0;i<temp[0].length;i++){
			System.out.print(temp[0][i] + " ");			
			System.out.println(temp[1][i]);
		}
	}
	//returns half the array, 0 for first half, 1 for second half
	public static int[][] arraysplit(int[][] temp, int half){
		
		int[][] arrayhalf = new int[2][temp[0].length/2];

		for(int i = 0 ; i < (temp[0].length/2);i++){
			arrayhalf[0][i] = temp[0][i + (half * temp[0].length/2)];
			arrayhalf[1][i] = temp[1][i + (half * temp[0].length/2)];
		}
		
		return arrayhalf;
	}
	//recursive funtion to find minumum distance
	public static double[] minDistance (int[][] X, int[][] Y, double min[]) {
		//if length < 3 give brute force answer, otherwise recurse
		if (X[0].length > 3){
			double[] firstmin = minDistance (arraysplit(X,0),Y, min);
			double[] secondmin = minDistance (arraysplit(X,1),Y, min);
			min = (firstmin[0] < secondmin[0]) ? firstmin : secondmin;
		} else if (X[0].length == 1){
			return min;
		} else if (X[0].length == 2){
			double[] dis = {distance(X[0][0],X[1][0],X[0][1],X[1][1]),X[0][0],X[1][0],X[0][1],X[1][1]};
			return ( dis[0] < min[0]) ? dis :min;
		} else if (X[0].length == 3){
			double[] dis1 = {distance(X[0][0],X[1][0],X[0][1],X[1][1]),X[0][0],X[1][0],X[0][1],X[1][1]};
			double[] dis2 = {distance(X[0][0],X[1][0],X[0][2],X[1][2]),X[0][0],X[1][0],X[0][2],X[1][2]};
			double[] dis3 = {distance(X[0][1],X[1][1],X[0][2],X[1][2]),X[0][1],X[1][1],X[0][2],X[1][2]};
			dis1 = ( dis1[0] < dis2[0]) ? dis1 : dis2;
			return ( dis1[0] < dis3[0]) ? dis1 : dis3;
		}
		
		//build Smid
		ArrayList<int[]> Smid = new ArrayList<int[]>();
		int L = X[0][(int)(X[0].length/2)];
		for (int i = 0 ; i < Y[0].length ; i++){
			if (( Y[0][i] > L - min[0]) && (Y[0][i] < L + min[0])){
				int[] temp = {Y[0][i],Y[1][i]};
				Smid.add(temp);
			}
		}
		
		//Scan through Smid
		double[] mdis = min;
		for (int i =0;i<Smid.size()-1;i++){
			int[] t1 = Smid.get(i);
			for (int j = i + 1 ; j<Smid.size();j++){
				if (j-i>8) break;
				int[] t2 = Smid.get(j);
				double[] dis = {distance(t1[0],t1[1],t2[0],t2[1]),t1[0],t1[1],t2[0],t2[1]};
				mdis = ( dis[0] < mdis[0]) ? dis : mdis;
			}
		}
		return (min[0] < mdis[0]) ? min:mdis ;
	}

}
