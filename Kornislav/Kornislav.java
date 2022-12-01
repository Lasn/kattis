
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Kornislav{
    private static List<String> permutes = new ArrayList<>();

    
        public  static Set<Integer[]> getPermutationsRecursive(Integer[] num){
            if (num == null)
                return null;
        
            Set<Integer[]> perms = new HashSet<>();
        
            //base case
            if (num.length == 0){
                perms.add(new Integer[0]);
                return perms;
            }
    
            int first = num[0];
            Integer[] remainder = Arrays.copyOfRange(num,1,num.length);
            Set<Integer[]> subPerms = getPermutationsRecursive(remainder);
            for (Integer[] subPerm: subPerms){
                for (int i=0; i <= subPerm.length; ++i){ 
                    Integer[] newPerm = Arrays.copyOf(subPerm, subPerm.length+1);
                    for (int j=newPerm.length-1; j>i; --j)
                        newPerm[j] = newPerm[j-1];
                    newPerm[i]=first;
                    perms.add(newPerm);
                }
            }
            return perms;
        }


    public static List<String> permute(String str, String pocket) {
        if(str.length() == 0){
            permutes.add(pocket);
            
        } else {
            for(int i = 0; i<str.length(); i++ ){
                String letter = String.valueOf(str.charAt(i));
                String front = str.substring(0, i);
                String back = str.substring(i+1);
                String together = front + back;
                permute(together, letter + pocket);
            }
        }
        return permutes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] num = {sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()};
        sc.close();
        Set<Integer[]> permutesInt = getPermutationsRecursive(num);
        Iterator<Integer[]> it = permutesInt.iterator();
        int largeNum = 0;
        while(it.hasNext()){
            Integer[] nums = it.next();
            int A = Integer.valueOf(nums[0]);
            int B = Integer.valueOf(nums[1]);
            int C = Integer.valueOf(nums[2]);
            int D = Integer.valueOf(nums[3]);
            if(A>=C && B<=D){
                if(C*B > largeNum){largeNum = C*B;}
            }
        }
        System.out.println(largeNum);   
    }
}