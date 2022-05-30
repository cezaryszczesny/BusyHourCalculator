package MathCalculations;

import java.util.ArrayList;
import java.util.Collections;

public class TrafficVolume {
    //czas połączeń w ciągu godziny/godzine
    private final int[] minuteServiceTime = new int[1440];


    private ArrayList<Double> hourTrafficVolume = new ArrayList<>();

    public ArrayList<Double> getHourTrafficVolume() {
        return hourTrafficVolume;
    }

    int index = 0;
    Double maxVolume = Double.valueOf(0);

    public void calculateMinuteServiceTime(int[][] callIntensity, int[] serviceTime) {

        int count = 0;

        for (int i = 0; i < callIntensity.length; i++) {
            int z = callIntensity[i][0] - 1;

            for (int j = 0; j < callIntensity[i][1]; j++) {
                // minuteServiceTime[i][1] += serviceTime[count];
                if (serviceTime[count] > 60) {
                    int temp = 1;
                    int rest = serviceTime[count] - 60;

                    minuteServiceTime[z] += 60;

                    while (rest > 60) {
                        if (i + temp > minuteServiceTime.length) {
                            break;
                        }
                        minuteServiceTime[z + temp] += 60;
                        rest -= 60;
                        temp++;

                    }
                    if (i + temp < minuteServiceTime.length) {
                        minuteServiceTime[z + temp] += rest;
                    }

                    count++;
                    continue;
                }

                minuteServiceTime[z] += serviceTime[count];
                count++;

            }
        }
    }

    public void calculateHourTrafficVolume(){

        for(int i = 0; i < minuteServiceTime.length-59; i++ ){
            int sum = 0;

            for(int j = i; j <= (i + 60) && j < 1440; j++){
                sum += minuteServiceTime[j];

                System.out.println(j);
            }
            double volume = sum/60/60;
            hourTrafficVolume.add(volume);
        }
    }

    public void findBusyHour(){

        maxVolume = Collections.max(hourTrafficVolume);
        index = hourTrafficVolume.indexOf(maxVolume);
        System.out.println(maxVolume + " "  + index);
    }
}

