import java.util.*;
/*
This program is able to take an array of integer values as input 
and return how many pairs of two identical integers exist
*/
public class PairMatch {

    static int pairsOfTwo(int n, int[] ar) {
        int count=0;
        for (int i=0; i<n; i++){
            if (ar[i] != 0){
                for (int j=i+1; j<n; j++){
                    if(ar[i] == ar[j]){
                        count++;
                        ar[j]=0;
                        break;
                    }
                }
            }
        }
        return count;
    }

    static int pairsOfThree(int n, int[] ar) {
        int count=0;
        for (int i=0; i<n; i++){
            if (ar[i] != 0){
                for (int j=i+1; j<n; j++){
                    if(ar[i] == ar[j]){
                        for (int k=j+1; k<n; k++){
                            if(ar[j] == ar[k]){
                                count++;
                                ar[k]=0;
                                break;
                            }
                        }
                        ar[j]=0;
                        break;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        
        System.out.println("How many elements your array contains?");
        int n = scanner.nextInt();
        
        System.out.println("Introduce "+n+" elements one by one; to confirm an element press enter");
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = scanner.nextInt();
        }

        System.out.println("You want to find pairs of: Two/Three?");
        String option = scanner2.nextLine();
        switch(option){
            case "Two":{
                System.out.println("There are "+pairsOfTwo(n, ar)+" pairs of "+option);
                break;
            }
            case "Three":{
                System.out.println("There are "+pairsOfThree(n, ar)+" pairs of "+option);
                break;
            }
        }
        scanner.close();
        scanner2.close();
    }
}