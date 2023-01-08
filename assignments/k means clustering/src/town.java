public class town {
   public int x;
 public    int y;
 public City CityNo;
 String name;
 double minDistance=200000000;


    public town(String name,int x, int y){
        this.name=name;
        this.x = x;
        this.y = y;

    }

    @Override
    public String toString() {
        return "town{" +
                "CityNo=" + CityNo +
                ", name='" + name + '\'' +
                '}';
    }


    public town copy(){
        town t=new town(name,x,y);
        t.CityNo=this.CityNo;
        t.minDistance=this.minDistance;
        return t;
    }
}
