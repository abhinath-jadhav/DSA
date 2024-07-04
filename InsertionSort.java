class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3,1,5,2,1,10,5};
        
        for(int i=0; i<arr.length-1; i++){
            int j = i;
            int k = arr[i+1];
            while(j > -1 && arr[j] >= k){
               
                arr[j+1] = arr[j];
                j--;
                //System.out.println(j);
            }
            arr[j+1] = k;
        }
        for(int i: arr) System.out.print(i + " ");
    }
}
