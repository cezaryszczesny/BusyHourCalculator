package ReadFile;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadServiceTime {
    public int[] readFile(){
        int[] result = new int[34931];

        String path = "src\\serviceTime.txt";
        String line;

        BufferedReader reader;

        int count=0;

        try{
            reader = new BufferedReader(new FileReader(path));

            while ((line= reader.readLine()) !=null){
                if (line.isBlank()) {
                    break;
                }
                line=line.trim();

                result[count] = Integer.parseInt(line);
                count++;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
