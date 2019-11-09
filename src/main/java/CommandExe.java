public class CommandExe {

    public static void main(String[] args) throws Exception {
        ProcessUtils.execute("git status");
        ProcessUtils.execute("git add .");
        ProcessUtils.execute("git commit -am \"auto-commit by fmerger\"");
        ProcessUtils.execute("git push");

    }

}
