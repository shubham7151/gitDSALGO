package gitDSALGO.leetcode;

import java.util.HashMap;
import java.util.Map;

public class O11_Most_Offen_IP {
    
    /*
     * "10.0.0.1 - log entry 1 11", "10.0.0.1 - log entry 2 213", "10.0.0.2 - log entry 1 11", "10.0.0.2 - log entry 2 213", "10.0.0.2 - log entry 133132"
     */

    public static String mostFrequentIp(String[] s){
        // String[] arr = s.split(","); // 10.0.0.1 - log entry 1 11, 10.0.02 - log entry 1 11
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i<s.length;i++){
            String temp = s[i].split("-")[0].trim();
            if(hm.containsKey(temp)){
                hm.put(temp, hm.get(temp)+1);
            }else{
                hm.put(temp, 1);
            }
        }
        int max = 0;
        String maxIP = "";
        for(Map.Entry<String, Integer> t  : hm.entrySet() ){
            if(t.getValue() > max){
                max = t.getValue();
                maxIP = t.getKey();
            }
        }

        return maxIP;
        
    }

    public static void main(String[] args) {
        String[] s = {"10.0.0.1 - log entry 1 11", "10.0.0.1 - log entry 2 213", "10.0.0.2 - log entry 1 11", "10.0.0.2 - log entry 2 213", "10.0.0.2 - log entry 133132"};
        System.out.println(mostFrequentIp(s));
    }
}
