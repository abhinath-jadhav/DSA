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
