package Util;

import java.io.*;
import java.util.*;

public class ProsUtil {
    Map<String,String> map = new HashMap();

    public ProsUtil(String filePath) {
        readMapFromFile(filePath);
    }

    public String getP(String key) {
        String value;
        System.out.println(map.get(key));
        if (map.containsKey(key)) {
            value = map.get(key);
            return value;
        }
        return "错误的关键字";
    }

    public int size() {
        int size = map.size();
        return size;
    }

    public static void main(String[] args) {
        /*ProUtil proUtil = new ProUtil("E:/courseClick/src/main/resources/evaluate.properties");
        String username = proUtil.getP("eva2");
        System.out.println(username);*/
        /*List<String> list = readListFromFile("E:/courseClick/src/main/resources/evaluate.properties");
        for(String s:list){
            System.out.println(s);
        }*/

        ProsUtil prosUtil = new ProsUtil("E:/courseClick/src/main/resources/evaluate.properties");
        System.out.println(prosUtil.getP("evaa1"));
//        System.out.println(prosUtil.getP("eva1"));
    }

    public Map<String,String> readMapFromFile(String filePath){

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line=bufferedReader.readLine()) != null ){
                if("".equals(line) || line.startsWith("#") || !line.contains("=")){
                    continue;
                }
                String[] ss = line.split("=");
                map.put(ss[0],ss[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


}
