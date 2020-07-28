package Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProUtil {
    Properties Pro;

    public ProUtil(String filePath) {
        Pro = getProElement(filePath);
    }

    private Properties getProElement(String filePath) {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(filePath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            properties.load(bufferedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    public String getP(String key) {
        String value;
        if (Pro.containsKey(key)) {
            value = Pro.getProperty(key);
            return value;
        }
        return "错误的关键字";
    }

    public int size() {
        int size = Pro.size();
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
    }

    public static List readListFromFile(String filePath){
        List list = new ArrayList();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line=bufferedReader.readLine()) != null ){
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
