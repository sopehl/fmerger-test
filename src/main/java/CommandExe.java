public class CommandExe {

    public static void main(String[] args) throws Exception {
       ProcessUtils.execute("git status");
       ProcessUtils.execute("git add .");
       ProcessUtils.execute("git commit -m fmerger");
       ProcessUtils.execute("git push https://github.com/sopehl/fmerger-test.git refs/heads/master:refs/heads/master");
       ProcessUtils.execute("git tag");
       ProcessUtils.execute("git push https://github.com/sopehl/fmerger-test.git refs/heads/master:refs/heads/master");

        System.out.println(System.getProperty("fmerger.final.name"));
    }

}
