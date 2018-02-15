package resoureceloader;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {

    private Properties defaultSettings = new Properties();

    private Map<String, Properties> propertiesMap = new HashMap<String, Properties>();

    public PropertiesLoader(){
        defaultSettings = RessourceLoader.loadProperties("settings/default.properties");
        store();
    }

    private void store(){
        propertiesMap.put("defaultSettings", defaultSettings);
    }

    public String getProperty(String prop, String key){
        return propertiesMap.get(prop).getProperty(key);
    }


}
