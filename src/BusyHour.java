import ReadFile.ReadCallIntensity;
import ReadFile.ReadServiceTime;

public class BusyHour {


    private int[][] callIntensity; //minuta   - ilość wykonanych połączeń w danej minucie;

    private int[] serviceTime;

    ReadCallIntensity readCallIntensity = new ReadCallIntensity();
    ReadServiceTime readServiceTime = new ReadServiceTime();
    public BusyHour(){
        callIntensity = readCallIntensity.readFile();
        serviceTime = readServiceTime.readFile();
    }

    public int[][] getCallIntensity() {
        return callIntensity;
    }
    public int[] getServiceTime() {
        return serviceTime;
    }


}
