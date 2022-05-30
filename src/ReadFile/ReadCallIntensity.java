package ReadFile;

import java.io.BufferedReader;
import java.io.FileReader;


public class ReadCallIntensity {

    public int[][] readFile(){
        int[][] result =
                new int[1004][2];

        String path = "src\\int.txt";
        String line;

        BufferedReader reader;

        int count = 0;

        try{
                reader = new BufferedReader(new FileReader(path));

                while((line=reader.readLine()) != null){
                     if(line.isBlank()){
                         break;
                     }
                    line = line.replace(',','.');
                    String[] element = line.trim().split("\\t");

                    result[count][0] = Integer.parseInt(element[0]);
                    result[count][1] = (int)Math.round(Double.parseDouble(element[1])*42000);
                    count++;

                }
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(result[942][0]);
        System.out.println(result[942][1]);
        return result;
    }
}
