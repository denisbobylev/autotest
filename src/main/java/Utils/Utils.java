package Utils;

import core.Configuration;

public class Utils {

    public static String getFileImage(String fileName) {
        return Configuration.USER_DIR + "/src/main/resources/image/" + fileName;
    }

}
