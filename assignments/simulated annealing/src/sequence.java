import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sequence {
    ArrayList<Box> series;

    public sequence(ArrayList<Box> boxList){
        series=new ArrayList<Box>();
        for (Box b:boxList
             ) {
            series.add(b.copy());

        };
    }

  public  ArrayList<Box>  generateRandomSequence(){
      Collections.shuffle(this.series);
      return this.series;
    }
public ArrayList<Box> suffle(){
    int pos1 = (int) (series.size() * Math.random());
    int pos2 = (int) (series.size() * Math.random());


    Box swap1 = series.get(pos1);
    Box swap2 = series.get(pos2);

    series.set(pos1,swap2);
    series.set(pos2,swap1);
    return series;

}

    public  int total_wrong(){
        int total_wrong=0;
        for (int i=0;i<this.series.size()-1;i++
        ) {

            if(this.series.get(i).size> this.series.get(i+1).size){
                total_wrong++;
            }
        }
        return total_wrong;
    }


    public  double acceptanceProbability(sequence current,double t){
        if(current.total_wrong()>this.total_wrong()){
            return 1;
        }
        else {
            return Math.exp((current.total_wrong()-this.total_wrong())/t);

        }

    }

    @Override
    public String toString() {
        return "sequence{" +
                 series +
                '}';
    }
}
