package Clustering;

import java.util.*;

class Information{
    int mathNumber;
    int seNumber;
    String result;
}
class Result{
    double distance;
    String result ;
    public double getDistance(){
        return distance;
    }
}

class ResultComparator implements Comparator<Result>{

    // Overriding compare()method of Comparator
    // for descending order of cgpa
    public int compare(Result r1, Result r2) {
        if (r1.distance < r2.distance)
            return -1;
        else if (r1.distance > r2.distance)
            return 1;
        return 0;
    }
}



public class KNN {
    public static void main(String[] args) {
        int input ;
        System.out.println("Enter input Number :");
        Scanner s = new Scanner(System.in);
        input = s.nextInt();
        ArrayList<Information> valueList = new ArrayList<>();
        System.out.println("Enter input values : ");

        for (int i = 0; i <input ; i++) {
            Information information = new Information();
            int matheValue = s.nextInt();
            int seValue = s.nextInt();
            String result = s.next();
            information.mathNumber = matheValue;
            information.seNumber =seValue;
            information.result = result;
            valueList.add(information);

        }

        for (Information i:valueList
        ) {
            System.out.println("m = "+i.mathNumber+" se = "+i.seNumber+" r = "+i.result );
        }

        int mathNumber,seNumber;
        String result;
        System.out.println("Enter  math : ");
        mathNumber = s.nextInt();
        System.out.println("Enter  se : ");
        seNumber = s.nextInt();

        int k;
        System.out.println("Enter k value : ");
        k = s.nextInt();

        KMeans(valueList,mathNumber,seNumber,k);
    }





    public static void KMeans(ArrayList<Information> valueList, int mathNumberG, int seNumberG,int k){
        //ArrayList<Integer> cluster1 = new ArrayList<>();
        //ArrayList<Integer> distance = new ArrayList<>();
        //ArrayList<Result> distanceList = new ArrayList<>();


        PriorityQueue<Result> distanceList = new
                PriorityQueue<Result>(valueList.size(), new ResultComparator());

        // PriorityQueue<Result> distanceList = new PriorityQueue<>();
        for (Information arrayList: valueList) {
            int mathNumber = arrayList.mathNumber;
            int seNumber = arrayList.seNumber;

            double distance = calculateDistance(mathNumberG,mathNumber,seNumberG,seNumber);
            Result result1 = new Result();
            result1.distance = distance;
            result1.result =arrayList.result;
            distanceList.add(result1);

        }

        System.out.println("Distance set  :  ");
        int pass=0;
        int fail=0;


        for (Result r :distanceList) {
            System.out.println(" dis = "+ r.distance);
        }
        for (int i = 0; i <distanceList.size() ; i++) {
            String result = distanceList.poll().result;
            System.out.println(i+ " = "+ result);
            if (result.equals("p")){
                pass++;
            }else{
                fail++;
            }
        }
        if(pass>fail){
            System.out.println("You Passed away");
        }else{
            System.out.println("You failed in life");
        }


    }
    private static double calculateDistance(int mathNumberG,int mathNumber,int seNumberG,int seNumber) {
        //return Math.sqrt((Math.pow((mathNumberG-mathNumber),2)+Math.pow((seNumberG-seNumber),2)));
        return Math.sqrt(((mathNumberG-mathNumber)*(mathNumberG-mathNumber))+((seNumberG-seNumber)*(seNumberG-seNumber)));
    }
}
