import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    static Properties prop = new Properties();

    public static void main(String[] args) throws IOException {
        readPropertiesFile();
        writePropertiesFile();
        readPropertiesFile();
    }

    public static void readPropertiesFile() throws IOException {


        try {

            InputStream input = new FileInputStream("src/main/resources/config.properties");

            prop.load(input);
            System.out.println(prop.getProperty("browser"));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void writePropertiesFile() throws IOException {
        OutputStream output = new FileOutputStream("src/main/resources/config.properties");
        prop.setProperty("result","pass");
        prop.store(output,"abcd1");
    }

}
