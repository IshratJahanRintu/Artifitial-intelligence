import java.util.*;

public class kMeansClustering {

    ArrayList<City> cities=new ArrayList<City>();
    ArrayList<City> lastState=new ArrayList<City>();



    public void initiateCities(ArrayList<town> towns,int numberOfCities){
        for (int i=1;i<=numberOfCities;i++){
            int cityPosition = (int) (towns.size() * Math.random());
            town t=towns.get(cityPosition);

            City c=new City(i,t.x,t.y);
            cities.add(c);
        }

    }
    public void resettowns(){
        for (City city:cities
             ) {
            city.resetTownList();
        }
    }
public void printResult(){

    for (City c:cities
         )

    {
        System.out.println("City = "+c.cityNo+"--->");
        if(c.towns.size()>0) {
            for (town t : c.towns
            ) {
                System.out.println(t.name);
            }
        }
        else{
            System.out.println("No towns");
        }
        System.out.println("--------------------------------");
    }
}
   public void cluster(ArrayList<town> towns, int numberOfCities, int MaxIteration ){
        initiateCities(towns,numberOfCities);

       while (MaxIteration > 0) {

            resettowns();
           for (town t:towns
                ) {

               for (City c:cities
                    ) {
                 if(c.calculateDistance(t)<t.minDistance){

                     t.minDistance=c.calculateDistance(t);
                     t.CityNo=c;

                 }
               }

              t.CityNo.towns.add(t);
           }
           if(cities.equals(lastState)){
               break;
           }

           for (City city:cities
                ) {
               if(city.towns!=null)city.updateCentroid(city.towns);


           }


           MaxIteration--;
       }



   }

    public static void main(String[] args) {
         ArrayList<town> towns=new ArrayList<town>(

                Arrays.asList(
                        new town("town1",2,10),
                        new town("town2",2,5),
                        new town("town3",8,4),
                        new town("town4",5,8),
                        new town("town5",7,5),
                        new town("town6",6,4),
                        new town("town7",1,2),
                        new town("town8",4,9))

        );

 kMeansClustering kmeans=new kMeansClustering();
  kmeans.cluster(towns,2,100);
   kmeans.printResult();


    }
}
