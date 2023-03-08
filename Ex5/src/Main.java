public class Main {
    public static void main(String[] args) {
        String sla = "sla";
        System.out.println(sla.length());
        String contrario="";
        for(int i=(sla.length()-1);i>=0;i--){
            contrario=contrario+sla.charAt(i);
        }
        System.out.println(contrario);
    }
}
