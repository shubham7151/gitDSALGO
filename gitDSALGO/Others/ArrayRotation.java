package gitDSALGO.Others;

public class ArrayRotation {
    
    /*
     * Array Rotation
     */

    /*
     * rotate array to left by one index
     * complexicity : O(n)
     */

    public static int[] leftRotateByOne(int[] arr){
            int temp = arr[0];
            for(int i = 1; i<arr.length;i++){
                arr[i-1] = arr[i];
            }
            arr[arr.length-1] = temp;

        return arr;
    }

    /*
     * rotate array to left k times
     * complexicity : O(n^2)
     */
    public static int[] leftRoatateByKTimes(int[] arr, int k){
        int n = k % arr.length;
        for( int j = 0; j<n ;j++){
        int temp = arr[0];
            for(int i = 1; i<arr.length;i++){
                arr[i-1] = arr[i];
            }
            arr[arr.length-1] = temp;

        }
        return arr;
    }

    /*
     * rotate array to right by one index
     * complexicity : O(n)
     */

     public static int[] rightRotateByOne(int[] arr){
        int temp = arr[arr.length-1];
        for(int i = arr.length-1;i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    return arr;
}

/*
     * rotate array to left k times
     * complexicity : O(n^2)
     */
    public static int[] rightRoatateByKTimes(int[] arr, int k){
        int n = k % arr.length;
        for( int j = 0; j<n ;j++){
            int temp = arr[arr.length-1];
            for(int i = arr.length-1; i>0;i--){
                arr[i] = arr[i-1];
            }
            arr[0] = temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,7,8,3,9};

        int[] result = rightRoatateByKTimes(arr,3);

        for(int i : result){
            System.out.println(i + ",");
        }
    }
}
