import java.util.Arrays;

public class ArrayDs {
    
    public static void main(String[] args){

        final int LOOPS = 4;
        int counter = 0;
         

        int[][] arr = {
            {-9, -9, -9, 1, 1, 1},
            { 0, -9, 0, 4, 3, 2},
            {-9, -9, -9, 1, 2, 3},
            {0, 0, 8, 6, 6, 0},
            {0, 0, 0, -2, 0, 0},
            {0, 0, 1, 2, 4, 0}
            };
            
        int[] storedValues = new int[16];

        for(int i = 0; i < LOOPS; i++){
            for(int j = 0; j < LOOPS; j++){
                storedValues[counter++] = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
            }
        }
        System.out.println(Arrays.toString(storedValues));
    }
}
