package Problem_Statement_2;

import java.util.Arrays;
import java.util.Scanner;

public class TravelerPayment
{
	static void mergeSort(int arr[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	static void merge(int arr[], int left, int mid, int right) {
		int l1 = mid - left + 1;
		int l2 = right - mid;
		int leftArr[] = new int[l1];
		int rightArr[] = new int[l2];

		for (int i = 0; i < l1; ++i) {
			leftArr[i] = arr[left + i];
		}
		for (int j = 0; j < l2; ++j) {
			rightArr[j] = arr[mid + 1 + j];
		}

		int i = 0, j = 0, k = left;

		while (i < l1 && j < l2) {
			if (leftArr[i] >= rightArr[j]) {
				arr[k] = leftArr[i];
				k++;
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
				k++;
			}
		}
		while (i < l1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while (j < l2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args)
	{
		// Creating Scanner object
		Scanner sc = new Scanner(System.in);

		// Take input of all currency denominations
		System.out.println("Enter the number of currency denomintations :");

		int size = sc.nextInt();

		if (size == 0) {
			System.out.println("No transactions possible without currency !");
			System.out.println("---- Please revisit currency exchange office ");
			sc.close();
			System.exit(0);
		}
		// Currency denominations are in integer form now a days :
		int currencyDeno[] = new int[size];

		System.out.println("Enter the currency denominations Values(Non-Decimal now a days)");
		for (int i = 0; i < size; ++i) {
			currencyDeno[i] = sc.nextInt();
		}
		// Now we r going use merge sort to sort currency values in descending order

		mergeSort(currencyDeno, 0, size - 1);

		// Now Enter Amount to be payed - (Always non zero +Value)
		System.out.println("Enter the amount you want to Pay :");
		float amount = sc.nextFloat();

		int[] count = new int[size];
		Arrays.fill(count, 0);
		int flag = 0;
		for (int k = 0; k < size; ++k) 
		{
			if (amount >= currencyDeno[k]) {
				count[k] = (int) (amount / currencyDeno[k]);

			}
			amount -= count[k] * currencyDeno[k];

			if (amount == 0) {
				flag = 1;
				break;
			}
		}
		// Minimum number of notes required as :
		if (flag == 1) {
			System.out.println("Your Payment approach in order as :");
			for (int j = 0; j < size; ++j) {
				if (count[j] != 0) {
					System.out.println(currencyDeno[j] + " :" + count[j] + " notes");
				}
			}
		} else {
			System.out.println(" oop's -Exact payment is not possible !");
		}
		sc.close();
	}
}
