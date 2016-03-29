/**
 * Created by Jianbin Liu on 3/29/2016.
 */
public class DetectorTest {
    public static void main(String args[]){
        String str = "English is a 0984567891 West chen@gmail.com Germanic 1234556772342 852 language that was first spoken java@ localhost in early medieval England and is now the most M10309120@mail.ntust.edu.tw widely A123456789 used T123745018 language a123745018 in the world.";

        Detector detector = new Detector();
        detector.match(str);
    }
}
