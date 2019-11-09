import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandExe {

    public static void main(String[] args) throws Exception {
        String s;

        Process p;
        try {
            p = Runtime.getRuntime().exec("git push");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
