import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandExe {

    public static void main(String[] args) throws Exception {
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("/usr/bin/git commit -am \"auto-commit by fmerger\"");
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
