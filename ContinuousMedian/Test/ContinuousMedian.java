
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class ContinuousMedian{
    private static List<Long> test;
    private static String print = "";


    public static void main(String[] args) {
        
        //fast();
        //slow();
        //slowArrayList();
        //ArrayListNoSort();
        


        readInput(1000);
        ArrayListNoSortTest();
        slowArrayListTest();
        
       
        System.out.println(print);
        
    }

    public static boolean readInput(int lenght) {
        try {
            File obj = new File("Test.txt");
            Scanner sc = new Scanner(obj);
            test = new ArrayList<>();
            while(sc.hasNextLong()){
                test.add(sc.nextLong());
            }
            sc.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }   
    }

    public static void fast() {
        Kattio sc = new Kattio(System.in);
        int t = sc.getInt();
        long start = System.nanoTime();
        for(int i = 0; i<t; i++){
            int n = sc.getInt();
            long[] setNum = new long[n];
            long sum = 0;
            for(int j= 0; j<n;j++ ){
                long a = sc.getLong();
                setNum[j]=a;
                if(j!=0 && setNum[j]<setNum[j-1]){
                    int position = Arrays.binarySearch(setNum, 0, j+1, a);
                    long[] newList = new long[n];
                    int idx = 0;
                    for(int g= 0; g<n-j;g++){
                        if(g==j+position){
                            newList[g] = setNum[j];
                            idx++; 
                        }
                        newList[idx] = setNum[g];
                        idx++;
                    }
                    setNum = newList;
                }
                if(j%2!=0){
                    sum += (setNum[j/2]+setNum[(j/2)+1])/2;
                } else {
                    sum += setNum[j/2];
                }
            }
            System.out.println(sum);
        }  
        long end = System.nanoTime();
        print += "Fast:\nTime to run " + (end-start) + " in nano seconds\n";
    }

    public static void ArrayListNoSort(){
        Kattio sc = new Kattio(System.in);
        int t = sc.getInt();
        long start = System.nanoTime();
        for(int i = 0; i<t; i++){
            int n = sc.getInt();
            List<Long> setNum = new ArrayList<>();
            long sum = 0;
            for(int j= 0; j<n;j++ ){
                long a = sc.getLong();
                if(j!=0 && a<setNum.get(j-1)){
                    int idx = Collections.binarySearch(setNum, a);
                    idx = (idx*-1)-1;
                    if(idx < 0) idx = 0; 
                    setNum.add(idx, a);
                } else {
                    setNum.add(a);
                }
                if(j%2!=0){
                    sum += (setNum.get(j/2)+setNum.get((j/2)+1))/2;
                } else {
                    sum += setNum.get(j/2);
                }
            }
            System.out.println(sum);
        }  
        long end = System.nanoTime();
        print += "ArrayListNoSort:\nTime to run " + (end-start) + " in nano seconds\n";
    }
    
    public static void slowArrayList(){
        Kattio sc = new Kattio(System.in);
        int t = sc.getInt();
        long start = System.nanoTime();
        for(int i = 0; i<t; i++){
            int n = sc.getInt();
            List<Long> setNum = new ArrayList<>();
            long sum = 0;
            for(int j= 0; j<n;j++ ){
                long a = sc.getLong();
                setNum.add(a);
                if(j!=0 && a<setNum.get(j-1)){
                    Collections.sort(setNum);
                }
                if(j%2!=0){
                    sum += (setNum.get(j/2)+setNum.get((j/2)+1))/2;
                } else {
                    sum += setNum.get(j/2);
                }
            }
            System.out.println(sum);
        }  
        long end = System.nanoTime();
        print += "SlowArrayList:\nTime to run " + (end-start) + " in nano seconds\n";
    }

    public static void slow(){
        Kattio sc = new Kattio(System.in);
        int t = sc.getInt();
        long start = System.nanoTime();
        for(int i = 0; i<t; i++){
            int n = sc.getInt();
            long[] setNum = new long[n];
            long sum = 0;
            for(int j= 0; j<n;j++ ){
                long a = sc.getLong();
                setNum[j]=a;
                if(j!=0 && a<setNum[j-1]){
                    Arrays.sort(setNum, 0, j+1);
                }
                if(j%2!=0){
                    sum += (setNum[j/2]+setNum[(j/2)+1])/2;
                } else {
                    sum += setNum[j/2];
                }
            }
            System.out.println(sum);
        }  
        long end = System.nanoTime();
        print += "Slow:\nTime to run " + (end-start) + " in nano seconds\n";
    }

    public static void ArrayListNoSortTest(){
        
        long start = System.nanoTime();
    
            int n = test.size();
            List<Long> setNum = new ArrayList<>();
            long sum = 0;

            for(int j= 0; j<n;j++ ){
                long a = test.get(j);
                if(j!=0 && a<setNum.get(j-1)){
                    int idx = Collections.binarySearch(setNum, a);
                    idx = (idx*-1)-1;
                    if(idx < 0) idx = 0; 
                    setNum.add(idx, a);
                } else {
                    setNum.add(a);
                }
                if(j%2!=0){
                    sum += (setNum.get(j/2)+setNum.get((j/2)+1))/2;
                } else {
                    sum += setNum.get(j/2);
                }
            }
            System.out.println(sum);
        
    
        
        long end = System.nanoTime();
        print += "ArrayListNoSort:\nTime to run " + (end-start) + " in nano seconds\n";

        setNum.forEach((a) -> {System.out.println(a);});
    }

    public static void slowArrayListTest(){
      
        long start = System.nanoTime();
      
            int n = test.size();
            List<Long> setNum = new ArrayList<>();
            long sum = 0;
            for(int j= 0; j<n;j++ ){
                long a = test.get(j);
                setNum.add(a);
                if(j!=0 && a<setNum.get(j-1)){
                    Collections.sort(setNum);
                }
                if(j%2!=0){
                    sum += (setNum.get(j/2)+setNum.get((j/2)+1))/2;
                } else {
                    sum += setNum.get(j/2);
                }
            }
            System.out.println(sum);
        
        long end = System.nanoTime();
        print += "SlowArrayList:\nTime to run " + (end-start) + " in nano seconds\n";
    }


}