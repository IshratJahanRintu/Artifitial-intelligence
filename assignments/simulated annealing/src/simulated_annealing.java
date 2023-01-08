import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class simulated_annealing {



    public static void main(String[] args) {
          double temp=10000;

          double coolingRate=0.0002;
      ArrayList<Box> boxes=new ArrayList<Box>(Arrays.asList(
              new Box("box2",2),
              new Box("box5",5),
              new Box("box3",3),
              new Box("box7",7),
              new Box("box6",6),
              new Box("box4",4),
              new Box("box1",1),

              new Box("box8",8)));
    
       sequence current=new sequence(boxes);
       current=new sequence(current.generateRandomSequence());
       sequence best=new sequence(current.series);

        while(temp>0.001){

            if(current.total_wrong()==0){
                System.out.println("The sequence is :" +current);
                return;
            }


               sequence s=new sequence(current.series);

               sequence newSeries=new sequence(s.suffle());
               if(newSeries.acceptanceProbability(current,temp)>Math.random()){

                   current=new sequence(newSeries.series);


               }



    temp*=1-coolingRate;
        }
    }



}



class Box{
    String name;
    int size;

    public Box(String name, int size) {
        this.name = name;
        this.size = size;
    }
   public Box copy(){
        return new Box(this.name,this.size);
   }
    @Override
    public String toString() {
        return name;
    }
}
