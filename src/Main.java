import MathCalculations.TrafficVolume;

public class Main {
    public static void main(String[] args) {

        var busyHour = new BusyHour();

        var trafficVolume = new TrafficVolume();

        trafficVolume.calculateMinuteServiceTime(busyHour.getCallIntensity(), busyHour.getServiceTime());
        trafficVolume.calculateHourTrafficVolume();
        trafficVolume.findBusyHour();
    }
}