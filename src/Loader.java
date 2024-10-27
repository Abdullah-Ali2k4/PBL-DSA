import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Loader {

    public LunarStack loadLunar(){
        String path="D:\\PBL-DSA\\src\\lunar.csv";
        String line="";
        LunarStack lq= new LunarStack();
        try {
            BufferedReader bf= new BufferedReader(new FileReader(path));
            int count=0;
            while ((line = bf.readLine()) != null) {
                String[] data = line.split(",");
                if(count==0){count++; continue;}
               
                for (int i = 0; i < 16; i++) {
                    if(data[i].equals("-")){
                        data[i]="0";
                    }
                }
                // Create a new LunarEclipse object and push it onto the queue
                lq.push(new LunarEclipse(data));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return lq;
    }

    public SolarQueue loadSolar(){
        String path="D:\\PBL-DSA\\src\\solar.csv";
        SolarQueue linkedQueue=new SolarQueue();
        String line="";
        try {
            BufferedReader br=new BufferedReader(new FileReader(path));
            int count=0;
            while ((line=br.readLine())!=null){
                String[] data=line.split(",");
                if (count==0) {count++;continue;}
                if (data.length<15) {
                    String[] temp=new String[15];
                    for (int i = 0; i < data.length; i++) {
                        temp[i]=data[i];
                    }
                    for (int i = data.length; i <15 ; i++) {
                        temp[i]="0";
                    }
                    data=temp;
                }
                for (int i = 0; i < 15; i++) {
                    if(data[i].equals("-")){
                        data[i]="0";
                    }
                }
                linkedQueue.enqueue(new SolarEclipse(data));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return linkedQueue;
    }
}
