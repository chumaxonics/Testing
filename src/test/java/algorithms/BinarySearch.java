package algorithms;

public class BinarySearch {

    static int findNumber(int [] data, int target){
        //array = 1 2 3 4 5 6
        // target = 3

        int low =0;
        int high = data.length-1;
        while (low <= high){
            int midpoint = (low + high )/2;
            int midPointNumber = data[midpoint];
            if(target == midPointNumber){
                return midpoint;
            }
            if(target < midPointNumber){
                high = midpoint - 1;
                //System.out.println("New High" + high);
            }else {
                low = midpoint + 1;
                //System.out.println("New low" + low);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9};
        int result =(findNumber(data,16));
        if ( !(result==-1)){
            System.out.println("Number found at index : " + result);
        }else {
            System.out.println("Not found");
        }
    }
}
