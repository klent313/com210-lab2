https://www.programiz.com/java-programming/online-compiler/

import java.util.Scanner; //Import the Scanner class
//import java.util.Arrays;   //Import the Arrays class

class Main {
  public static void main(String[] args) {
    //Create a Scanner Object
    Scanner methodObject = new Scanner(System.in);

    //Make an unsorted int array
    int numElements = 0;
    while(numElements < 10)
    {
      System.out.println("\nHow many elements do you want to have in the unsorted array?:");
      numElements = methodObject.nextInt();
      if(numElements < 10)
      {
        System.out.println("\nInvalid size! Array must have at least 10 elements in it!");
      }
    }
    int[] unsortedIntArray = new int[numElements];
    unsortedIntArray = randomlyFillIntArray(unsortedIntArray);
    int nextA = setNextIntArray(unsortedIntArray);

    //Make a sorted int array
    numElements = 0;
    while(numElements < 10)
    {
      System.out.println("\nHow many elements do you want to have in the sorted array?:");
      numElements = methodObject.nextInt();
      if(numElements < 10)
      {
        System.out.println("\nInvalid size! Array must have at least 10 elements in it!");
      }
    }
    int[] sortedIntArray = new int[numElements];
    sortedIntArray = randomlyFillIntArray(sortedIntArray);
    sortedIntArray = sortIntArray(sortedIntArray);
    int nextB = setNextIntArray(sortedIntArray);

    //Ask if arrays should be displayed
    methodObject.nextLine();
    boolean printArrays = false;
    System.out.println("\nType YES if you would like the arrays to be displayed.:");
    String printCheck = methodObject.nextLine();
    if(printCheck.toUpperCase().equals("YES"))
    {
      printArrays = true;
    }

    //Print both arrays
    System.out.println("\n__________\n\n");
    if(printArrays)
    {
      printIntArray(unsortedIntArray, nextA);
      printIntArray(sortedIntArray, nextB);
    }

    //Test the fetch operations
    int searchKey = 0;
    int targetIndex = nextA;
    while(targetIndex == nextA)
    {
      searchKey = (int)(Math.random() * 100) + 1;
      targetIndex = fetchUnsortedIntArray(unsortedIntArray, searchKey, nextA);
      if(targetIndex != nextA)
      {
        System.out.println("Search Target Value " + searchKey + " was found at index " + targetIndex + " for array A.");
      }
    }

    targetIndex = nextB;
    while(targetIndex == nextB)
    {
      searchKey = (int)(Math.random() * 100) + 1;
      targetIndex = fetchSortedIntArray(sortedIntArray, searchKey, nextB);
      if(targetIndex != nextB)
      {
        System.out.println("Search Target Value " + searchKey + " was found at index " + targetIndex + " for array B.");
      }
    }

    //Test the delete operations
    System.out.println("\n");
    int tempNext = nextA;
    while(nextA == tempNext)
    {
      searchKey = (int)(Math.random() * 100) + 1;
      unsortedIntArray = deleteUnsortedIntArray(unsortedIntArray, searchKey, nextA);
      nextA = setNextIntArray(unsortedIntArray);
    }
    if(printArrays)
    {
      printIntArray(unsortedIntArray, nextA);
    }
    System.out.println("Delete Target Value " + searchKey + " was deleted for array A.\n\n");
    
    tempNext = nextB;
    while(nextB == tempNext)
    {
      searchKey = (int)(Math.random() * 100) + 1;
      sortedIntArray = deleteSortedIntArray(sortedIntArray, searchKey, nextB);
      nextB = setNextIntArray(sortedIntArray);
    }
    if(printArrays)
    {
      printIntArray(sortedIntArray, nextB);
    }
    System.out.println("Delete Target Value " + searchKey + " was deleted for array B.\n\n");

    //Test the insert operations
    System.out.println("\n");
    if(nextA < unsortedIntArray.length)
    {
      searchKey = (int)(Math.random() * 100) + 1;
      unsortedIntArray = insertUnsortedIntArray(unsortedIntArray, searchKey, nextA);
      nextA = setNextIntArray(unsortedIntArray);
      if(printArrays)
      {
        printIntArray(unsortedIntArray, nextA);
      }
      System.out.println("Insert Target Value " + searchKey + " was inserted for array A.\n\n");
    }

    if(nextB < sortedIntArray.length)
    {
      searchKey = (int)(Math.random() * 100) + 1;
      sortedIntArray = insertSortedIntArray(sortedIntArray, searchKey, nextB);
      nextB = setNextIntArray(sortedIntArray);
      if(printArrays)
      {
        printIntArray(sortedIntArray, nextB);
      }
      System.out.println("Insert Target Value " + searchKey + " was inserted for array B.\n\n");
    }
  }

  //Fill an int array with random integers 1-100
  public static int[] randomlyFillIntArray(int[] intArray)
  {
    for(int i = 0; i < intArray.length; i++)
    {
      intArray[i] = (int)(Math.random() * 100) + 1;
    }
    return intArray;
  }

  //Sort a given int array in ascending order (Bubble Sort)
  public static int[] sortIntArray(int[] intArray)
  {
    for(int i = 0; i < intArray.length; i++)
    {
      for(int j = 0; j < intArray.length - 1; j++)
      {
        if(intArray[j] > intArray[j + 1])
        {
          int swap = intArray[j + 1];
          intArray[j + 1] = intArray[j];
          intArray[j] = swap;
        }
      }
    }
    return intArray;
  }

  //Print an int array
  public static void printIntArray(int[] intArray, int next)
  {
    System.out.print("Array: ");
    for(int i = 0; i < next; i++)
    {
      System.out.print(intArray[i] + ", ");
    }
    if(next < intArray.length)
    {
      int nullElementsNum = intArray.length - next;
      System.out.print("Remaining null elements: " + nullElementsNum);
    }
    System.out.println("\n");
  }

  //Set the next value of an associated int array
  public static int setNextIntArray(int[] intArray)
  {
    for(int i = 0; i < intArray.length; i++)
    {
      if(intArray[i] == 0)
      {
        return i;
      }
    }
    return intArray.length;
  }

  //Search an unsorted int array for a target value
  public static int fetchUnsortedIntArray(int[] intArray, int targetKey, int next)
  {
    int count = 0;
    int i = 0;
    while(i < next)
    {
      if(intArray[i] == targetKey)
      {
        count++;
        System.out.println("\n\nCount is: " + count + "\n");
        return i;
      }
      count++;
      i++;
    }
    //System.out.println("\n\nCount is: " + count + "\n");
    return next;
  }

  //Search a sorted int array for a target value
  public static int fetchSortedIntArray(int[] intArray, int targetKey, int next)
  {
    int count = 0;
    int low = 0;
    int high = next - 1;
    int i = (low + high) / 2;
    while(intArray[i] != targetKey)
    {
      if((intArray[i] > targetKey) && (high != low))
      {
        high = i - 1;
      }
      else
      {
        low = i + 1;
      }
      i = (low + high) / 2;
      if(high <= low)
      {
        count++;
        //System.out.println("\n\nCount is: " + count + "\n");
        return next;
      }
      count++;
    }
    System.out.println("\n\nCount is: " + count + "\n");
    return i;
  }

  //Insert a value into an unsorted int array
  public static int[] insertUnsortedIntArray(int[] intArray, int insertNum, int next)
  {
    int count = 0;
    if(next < intArray.length)
    {
      count++;
      intArray[next] = insertNum;
    }
    else
    {
      count++;
      System.out.println("Array is full! Insertion not possible!");
    }
    System.out.println("\n\nCount is: " + count + "\n");
    return intArray;
  }

  //Insert a value into a sorted int array
  public static int[] insertSortedIntArray(int[] intArray, int insertNum, int next)
  {
    int count = 0;
    if(next >= intArray.length)
    {
      count++;
      System.out.println("\n\nCount is: " + count + "\n");
      System.out.println("Array is full! Insertion not possible!");
      return intArray;
    }
    int low = 0;
    int high = next - 1;
    int i = (low + high) / 2;
    while(!((intArray[i] > insertNum) && (intArray[i - 1] < insertNum)))
    {
      if(intArray[i] > insertNum)
      {
        high = i - 1;
      }
      else
      {
        low = i + 1;
      }
      i = (low + high) / 2;
      count++;
      if((i <= 0) || (intArray[i] == insertNum))
      {
        break;
      }
    }
    for(int j = next; (j >= i) && (j >= 1); j--)
    {
      intArray[j] = intArray[j - 1];
      count++;
    }
    intArray[i] = insertNum;
    System.out.println("\n\nCount is: " + count + "\n");
    return intArray;
  }

  //Delete a value from an unsorted int array
  public static int[] deleteUnsortedIntArray(int[] intArray, int deleteNum, int next)
  {
    int count = 0;
    int i = fetchUnsortedIntArray(intArray, deleteNum, next);
    if(i == next)
    {
      count++;
      System.out.println("\n\nCount is: " + count + "\n");
      return intArray;
    }
    for(int j = i; j < next - 1; j++)
    {
      intArray[j] = intArray[j + 1];
      count++;
    }
    intArray[next - 1] = 0;
    System.out.println("\n\nCount is: " + count + "\n");
    return intArray;
  }
  
  //Delete a value from a sorted int array
  public static int[] deleteSortedIntArray(int[] intArray, int deleteNum, int next)
  {
    int count = 0;
    int i = fetchSortedIntArray(intArray, deleteNum, next);
    if(i == next)
    {
      count++;
      System.out.println("\n\nCount is: " + count + "\n");
      return intArray;
    }
    for(int j = i; j < next - 1; j++)
    {
      intArray[j] = intArray[j + 1];
      count++;
    }
    intArray[next - 1] = 0;
    System.out.println("\n\nCount is: " + count + "\n");
    return intArray;
  }
}

