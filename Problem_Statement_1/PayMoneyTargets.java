package Problem_Statement_1;

import java.util.Scanner;

public class PayMoneyTargets 
{
	public static void main(String[] args) 
	{
		// PayMoney daily workflow
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of transactions Today");
		int n = sc.nextInt();
		if (n == 0) {
			System.out.println("Sorry -- No transcations happens today");
			sc.close();
			System.exit(0);
		}
		float transArray[] = new float[n];
		System.out.println("Enter values in array of transactions");
		for (int i = 0; i < n; ++i)
			transArray[i] = sc.nextFloat();

		// Now making transactions Adhesive Array
		for (int i = 1; i < n; ++i)
			transArray[i] += transArray[i - 1];

		// No. of targets to be achieved
		System.out.println("Enter total no. of target needs to be achieved ?");
		int noOfTargets = sc.nextInt();
		if (noOfTargets == 0) {
			System.out.println("-- Don't worry it's all Fine today-Nothing to Achieve:");
			sc.close();
			System.exit(0);
		}
		int k = 1;
		float amount;
		int flag;
		while (noOfTargets > 0) {
			System.out.println("Enter target to be achieved -> number " + k);
			amount = sc.nextFloat();
			flag = 0;
			for (int j = 0; j < n; ++j) {
				if (amount <= transArray[j]) {
					System.out.println(" Yes--Target Successfull in '" + (j + 1) + "' transaction \n");
					flag = 1;
					break;
				}
			}
			k++;
			noOfTargets--;
			if (flag != 1)
				System.out.println("\n   Sorry ---- This Target Value is not Achieved \n");

		}
		sc.close();
		System.out.println("\n ------ That's all for today ------");
	}
}
