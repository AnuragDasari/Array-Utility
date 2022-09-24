/**
* @author  Anurag Dasari // 
* ITSC1212 - 001, Mazumder
* @version 1.0 // add .1 for each update
* @since   2021-02-22 // date last updated
* Project 4
* Find the minimum (smallest) value that appears in the array
  Find the maximum (largest) value that appears in the array
  Determine the number of unique values that appear in the array
*/
public class ArrayUtil {
	private int[] intArray;                             //  variable
	public ArrayUtil(){                                 // default constructor to create an empty array
		intArray = new int[0];
	}
	public ArrayUtil(int[] inArray)                     //constructor to initialize intArray to input argument
	{
		intArray = inArray;
	}
	public int[] getIntArray() {                        // method to return the intArray
		return intArray;
	}
	public void setIntArray(int[] inArray) {            // method to set the intArray to input argument
		intArray = inArray;
	}
	public int minValue() {                             // method to return minimum value of the array
		
		int min = 0;                                    // set min to 0
		for(int i=0;i<intArray.length;i++)              // loop for the array to determine the minimum value of the array
		{
			if(i == 0 || intArray[i] < min)
				min = intArray[i];
		}
		return min;
	}
	public int maxValue() {                             // method to return maximum value of the array
		int max = 0;                                    // set max to 0
		for(int i=0;i<intArray.length;i++)              // loop for the array to determine the maximum value of the array
		{
			if(i == 0 || intArray[i] > max)
				max = intArray[i];
		}
		return max;
	}
	public int countUniqueIntegers() {                  // method to count and return the number of unique integers in the array
		int count = 0;                                  // set count to 0
		for(int i=0;i<intArray.length;i++)              // loop for the array to find the unique integers
		{
			boolean found = false;                      // set found to false
			for(int j=0;j<i;j++)                        // loop for determine if element has occurred in the array until now or not
			{
				if(intArray[j] == intArray[i])
				{
					found = true;
					break;
				}
			}
			if(!found)                                  // if element not found, increment count by 1
				count++;
		}
		return count;
	}
	public int[] removeDuplicates(){                    // method to return an array containing all unique integers
		int[] unique = new int[countUniqueIntegers()];  // create an array of size equal to number of unique integers in the array
		int nUnique = 0;                                // set number of unique elements to 0
		
		
		for(int i=0;i<intArray.length;i++)              // loop for the array to populate unique integers into unique array
		{
			boolean found = false;
			for(int j=0;j<i;j++)
			{
				if(intArray[j] == intArray[i])
				{
					found = true;
					break;
				}
			}
			if(!found)
			{
				unique[nUnique] = intArray[i];
				nUnique++;
			}
		}
		return unique;
	}
	public void swap(int i, int j)                                              // method to swap the element at indices i and j
	{
		if(i >= 0 && i < intArray.length-1 && j >= 0 && j < intArray.length-1)  // validate indices
		{
			int temp = intArray[i];                                             // swap the elements at index i and j
			intArray[i] = intArray[j];
			intArray[j] = temp;
		}
	}
	// method to return true if the array is sorted in ascending order if Ascending is true 
	// or in descending order if arrAscending is false, else return false
	public boolean arrSorted(boolean arrAscending)
	{
		for(int i=0;i<intArray.length-1;i++)        // loop for the array
		{
			// arrAscending is true and element is greater than (i+1)th element
			// or arrAscending is false and element is less than (i+1)th element
			// array is not sorted in specified order
			if((arrAscending && intArray[i] > intArray[i+1]) || (!arrAscending && intArray[i] < intArray[i+1]))
				return false;
		}
		return true;
	}
}