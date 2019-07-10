package tibbo.grep;

public class Main {
    public static void main(String[] args){
        Grep stringGrep = GrepHelper.getInstance(0);

        stringGrep.contains("tibbo", "this is first tibbo string");
    }
}
