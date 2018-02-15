package resoureceloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class RessourceLoader {

    public static String loadContent(String url){
        StringBuilder builder = new StringBuilder("");
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        File file = new File(loader.getResource(url).getFile());
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                builder.append(line).append("\n");
            }
            scanner.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static Properties loadProperties(String url){
        Properties properties = new Properties();
        InputStream stream = null;

        try{
            stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(url);
            properties.load(stream);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }

}
