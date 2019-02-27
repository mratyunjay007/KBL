package shop.akapp.com.kbl;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<Questions> list;

    @Override
    public void onCreate() {
        super.onCreate();

        list=new ArrayList<Questions>();
        list.add(new Questions(" What  is loopback address of a machine?","127.0.0.10","127.10.0.1",
                "127.0.0.1","127.0.1.0","127.0.0.1",3));
        list.add(new Questions(" On which port does https runs ?","80","443",
                "444","23","443",2));
        list.add(new Questions(" No of layers in OSI model?","4","7",
                "03","06","7",2));
        list.add(new Questions(" No of software ports in a computing device?","65536","65535",
                "80","40","65536",1));
        list.add(new Questions(" Under which section goverenment has the power to monitor ," +
                " collect traffic data or information through any computer resource?","110C","315A",
                "69B","14A","69B",3));
    }
}
