import java.util.*;

public class RearrangeArray {
    public static void main(String[] args) {
        int[] arr = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        rearrange(arr);
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
    }

    static void rearrange(int[] arr) {
        int n = arr.length;
        
        // Step 1: Partition the array (move all negative numbers to the left side)
        int i = partition(arr, n);
        
        // Step 2: Arrange alternately positive and negative numbers
        int pos = i; // First positive number index
        int neg = 0; // First negative number index

        // Swap the alternate negative and positive numbers
        while (pos < n && neg < pos && arr[neg] < 0) {
            swap(arr, neg, pos);
            pos++;
            neg += 2;
        }
    }

    // Partition the array, moving all negative numbers to the left
    static int partition(int[] arr, int n) {
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] < 0) {
                swap(arr, i, j);
                i++;
            }
        }
        return i; // This is the index where the positive numbers start
    }

    // Helper function to swap two elements in the array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


public class RearrangeArray {
  /*
    Input: arr[] = [9, 4, -2, -1, 5, 0, -5, -3, 2]
    Output: 9 -2 4 -1 5 -5 0 -3 2
    Explanation: The positive numbers are [9, 4, 5, 0, 2] and the negative integers are [-2, -1, -5, -3]. Since, we need to start with the positive integer first
  */
  public static void main(String[] args) {
    int[] arr = {9, 4, -2, -1, 5, 0, -5, -3, 2};
    List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
    rearrange(list);
    list.stream().forEach(System.out::println);

  }
  void rearrange(ArrayList<Integer> arr) {
        // code here
        int i = 0;
        int j = 1;
        while(arr.get(0) > 0){
           int temp =  arr.get(0);
           arr.set(0, arr.get(i));   
           arr.set(i, temp);
           i++;
        }
        i = 1;
        boolean pos = false;
        while( j < arr.size()){
            if(pos){
                while(arr.get(i) > 0){
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                    j++;
                    
                }  
                pos = false;
            } else {
                while(arr.get(i) < 0){
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                    j++;
                }
                pos = true;
            }
        }
    }
}
