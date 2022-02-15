package gugudan;

public class GugudanMain {

	public static void main(String[] args) {
		int result = 0;
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {	
				if(j != 1) {				
					result = i*j;
//					System.out.print(j + " X " + i + " = " + (i*j)+ "\t");
					System.out.printf("%d X %d = %d\t",j,i , result);
				}
			}
			System.out.println();
		}
	}
}
