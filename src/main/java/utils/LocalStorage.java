package utils;

import java.util.Map;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

public class LocalStorage {

    public static String getValueFromLocalStorage(String keyValue) {
        Map<String, String> allStorageData = jsExecute("return {...localStorage}");
        for (String key : allStorageData.keySet()) {
            if (key.contains(keyValue)) {
                System.out.println("Current key: " + key);
                return allStorageData.get(key);
            }
        }
        return null;
    }
}
