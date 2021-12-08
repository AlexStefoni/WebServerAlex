package Server;

import Server.config.ConfigUtils;

public class TestMain {
    public static void main(String[] args){

        int sum1=0;
        int sum2=0;
        for(int i=100 ;i<10000;i++)
        {
            if(ConfigUtils.checkPort(i)) sum1++;
            else sum2++;
        }
        System.out.println(sum1+"/"+sum1+sum2 + "true");
        System.out.println(sum2+"/"+sum1+sum2 + "false");






    }
}
