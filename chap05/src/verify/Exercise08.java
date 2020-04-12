package verify;

public class Exercise08 {
    public static void main(String[] args) {
        int[][] array = {
            { 95, 86 },
            { 83, 92, 96 },
            { 78, 83, 93, 87, 88 }
        };
        
        int sum = 0;
        double avg = 0.0;
        
        /* My Solution */
        for(int i=0; i<array.length; i++)
            for(int index : array[i])
                sum += index;
        
        avg = (double) sum / (array[0].length + array[1].length + array[2].length);
        /*  ****** ******  */
        
        /* Better Solution */
        int count = 0;
        for(int i=0; i<array.length; i++)
            for(int index : array[i]) {
                sum += index;
                count++;
            }
        avg = (double) sum / count;
        /*  ****** ******  */
        
        System.out.println("sum : " + sum);
        System.out.println("avg : " + avg);
    }
}
