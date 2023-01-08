import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
  public double x;
  public double y;

 public int cityNo;
 List<town> towns=new ArrayList<town>();
   public City(int cityNo,double x, double y) {
      this.x = x;
      this.y = y;
      this. cityNo= cityNo;

   }

 public void resetTownList(){
       towns=new ArrayList<town>();
 }

   public double calculateDistance(town t){
      double xDistance = Math.abs(this.x - t.x);
      double yDistance = Math.abs(this.y - t.y);
      double distance = Math.sqrt(Math.pow (xDistance,2) +Math.pow (yDistance,2) );

      return distance;
   }

   public void updateCentroid(List<town> towns){
       double x=0;
       double y=0;
       for (town t:towns
            ) {
        x+=t.x;
        y+=t.y;

       }
      this.x=x/towns.size();
      this.y=y/towns.size();
   }

    @Override
    public String toString() {
        return "City{" +
                "cityNo=" + cityNo +
                "x=" + x +
                ", y=" + y +
                '}';
    }




    public City copy(){
       City city= new City(this.cityNo,this.x,this.y);
        for (town t:towns
             ) {
            city.towns.add(t.copy());
        }
        return city;
    }
}
