import java.util.Arrays;

public class LeftRotation{
public static void main (String[] args) {
    
    int d = 1;

    int[] arr = {1, 2, 3, 4, 5};
    
    for(int i = 0; i < d; i++){
        int[] arr1 = new int[5];
        for(int j = 0; j<arr.length;j++){
            if(j == 0){
                arr1[arr.length-1] = arr[0];
            }
            else{
                arr1[j-1] = arr[j];
            }
        }
        arr = arr1;   
    }
    System.out.println(Arrays.toString(arr));
}

}