import java.util.*;

public class Searches {
	public static void main(String[] args) {
		Random randGen = new Random();
		Scanner keyboard = new Scanner(System.in);
		int[] data = new int[100];
		
		// generate values for the data array
		data[0] = randGen.nextInt(10) + 1;
		for(int i = 1;  i < 100; i++) {
			data[i] = data[i-1] + randGen.nextInt(10) + 1;
		}
		System.out.println("An array of one-hundred ascending values was generated.");
	
					
		// prints the values for the data array to the screen
		System.out.println("\n The generated array contains the following values:");
		for(int y = 0; y<10; y++) {
			for(int x = 0; x<10; x++)
				System.out.printf("%6d",data[y*10+x]);
			System.out.println();	
		}
		
		System.out.println("Please enter the number you would like to search for:");
		int numToFind = keyboard.nextInt();
		
		
		int linearFoundAt = linearSearch(data,numToFind);
		
		int binaryFoundAt = binarySearch(data,numToFind);
		
		System.out.print("Linear search ");
		if(linearFoundAt == -1)
			System.out.println("did not find the value " +numToFind + ".");
		else
			System.out.println("found the value " +numToFind + " at index " + linearFoundAt+".");
			
		
		System.out.print("Binary search ");
		if(binaryFoundAt == -1)
			System.out.println("did not find the value " +numToFind + ".");
		else
			System.out.println("found the value " +numToFind + " at index " + binaryFoundAt+".");
	}
	
	// Pre:		receives an array of data and a value to find
	// Post:	returns the index where the value was found in the array
	//			or -1 if the value was not found
	private static int linearSearch(int[] data, int numToFind) {
		int found = -1;
		for (int x=0; x<data.length;x++) {
			if (data[x]==numToFind) {
				found = x;
				break;
			}
		}
		return found;
	}
	
	// Pre:		receives an array of data and a value to find
	// Post:	returns the index where the value was found in the array
	//			or -1 if the value was not found
	private static int binarySearch(int[] data, int numToFind) {
		int start=0, end=data.length;
		while(start<=end) {
			int check = (start + end) / 2;
			if (data[check] == numToFind) {
				return check;
			}
			else if (data[check] > numToFind) {
				end=check-1;
			}
			else{
				start=check+1;
			}
		}
		return-1;
	}
}