package gitDSALGO.leetcode;

public class L2180_Count_Integers_With_Even_Digit_Sum {
    
    public int countEven(int num) {
        int counter = 0;
        for(int i = 1;i<=num;i++){
            if(sumOfDigit(i) % 2 == 0){
                counter++;
            }
        }
        return counter;
    }

    public int sumOfDigit(int n){
        int sum = 0;

        while(n >0){
            // System.out.println(n);
            sum += n%10;
            n = n/10;
        }

        return sum;
    }

    public static void main(String[] args) {
        
    }
}
