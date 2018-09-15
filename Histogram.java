import java.io.File;
import java.util.Scanner;
import java.io.IOException;
public class Histogram{
	public static String repeat(String str, int times) {
    	return new String(new char[times]).replace("\0", str);
	}
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		int bins;
		if (args.length==1) {
			System.out.println("How many bins would you like?");
			bins = input.nextInt();
		}else{
			bins = Integer.parseInt(args[1]);
		}
		int[][] repo = new int[102][2];
		int m = 101 % bins;
	 	int n = 101 / bins;
		repo[bins - 1][0] = 0;
		repo[bins - 1][1] = 0;
		for (int i = 0;i < bins; i ++) {
			repo[bins - i - 1][0] = m + n * i;
			repo[i][1] = 0;
		}
		Scanner sc = new Scanner(new File(args[0]));
		while(sc.hasNext()){
			String[] temp = sc.nextLine().split(",");
			int num = Integer.parseInt(temp[1].trim());
			int group = (100 - num) / n;
			if (group >= bins) {
				group = bins - 1;
			}
			repo[group][1] += 1;
		}
		for (int i = 0;i < bins -1 ;i ++ ) {
			System.out.printf("%3d -%3d | ",(repo[i][0]+n-1),(repo[i][0]));
			System.out.println(repeat("[]",repo[i][1]));
		}
		System.out.printf( "%3d -%3d | ",(m + n - 1) ,0);
		System.out.println(repeat("[]", repo[bins-1][1]));

	}
}
