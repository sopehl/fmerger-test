import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessUtils {

    public static void execute(String command) throws Exception {
        String s = "";
        Process p = Runtime.getRuntime().exec(command);
        System.out.println("Executing: " + command);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
        while ((s = br.readLine()) != null)
            System.out.println("line: " + s);
        p.waitFor();
        p.destroy();
    }

}
