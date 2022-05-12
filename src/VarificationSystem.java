import java.util.Scanner;

public class VarificationSystem {

    static void valID(String str){
        //System.out.println(str);
        if (str.length() > 9 || Integer.parseInt(str.substring(0,3)) > 11 || Integer.parseInt(str.substring(3,5)) < 05 || Integer.parseInt(str.substring(3,5)) > 20 ||
                Integer.parseInt(String.valueOf(str.charAt(5))) > 3 || Integer.parseInt(String.valueOf(str.charAt(5))) < 1 || Integer.parseInt(str.substring(6)) < 1 || Integer.parseInt(str.substring(6)) > 999){
            System.out.println("INVALID ID");
        }else {
            System.out.println("VALID ID");
        }
    }

    static void validEmail(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your ID first: ");
        String str = sc.nextLine();
        if (str.length() > 9 || Integer.parseInt(str.substring(0,3)) > 11 || Integer.parseInt(str.substring(3,5)) < 05 || Integer.parseInt(str.substring(3,5)) > 20 ||
                Integer.parseInt(String.valueOf(str.charAt(5))) > 3 || Integer.parseInt(String.valueOf(str.charAt(5))) < 1 || Integer.parseInt(str.substring(6)) < 1 || Integer.parseInt(str.substring(6)) > 999){
            System.out.println("INVALID ID!!!");
        }else {
            //System.out.println("VALID ID");
            int n=0;
            System.out.println("Enter Email: ");
            String email = sc.nextLine();
            String[] bscse = email.split("@");

            for (int i=0; i < bscse.length; i++){
                if (bscse[i].contains("bscse.uiu.ac.bd") || bscse[i].contains("bseee.uiu.ac.bd")){
                    n=n+2;
                    break;
                }
            }

            int index = email.indexOf("@",0);
            int newIndex = index-6; // id shuru
            String idSixDigit = email.substring(newIndex,index);  //six digit id , main id "str"
            String idSixDigit1 = str.substring(3);

            if (n!=0 && idSixDigit.compareTo(idSixDigit1) == 0){
                System.out.println("VALID Email");

            }else {
                System.out.println("INVALID EMAIL!!!");
            }
        }
    }

    static void validPass(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the password:");
        String pass = sc.nextLine();
        int len = pass.length();
        char ch;
        boolean flag = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        if (len >= 8){
            for (int i=0; i < len; i++){
                int hax = 0;
                ch = pass.charAt(i);
                if (Character.isDigit(ch)){
                    flag = true;
                    hax++;
                }
                else if (Character.isUpperCase(ch)){
                    flag2 = true;
                    hax++;
                }
                else if (Character.isLowerCase(ch)){
                    flag3 =true;
                    hax++;
                }
                else if (pass.charAt(i) == '@' || pass.charAt(i) == '#' || pass.charAt(i) == '%' || pass.charAt(i) == '&'){
                    flag4 = true;
                    hax++;
                }
                else if (hax==0){
                    break;
                }
            }
        }
        /*else {
            System.out.println("INVALID Pass!!!");
        }*/
        if (flag && flag2 && flag3 && flag4 && pass.charAt(len-1)=='P'){
            System.out.println("Valid Password");
        }
        else {
            System.out.println("INVALID PASSWORD!!!");
        }
    }

    static void validString(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();

        if (str.contains("UIU")){
            int in = str.indexOf("UIU",0);
            int digitAfterUiu = in + 3;
            int forLastName = digitAfterUiu+1;
            int n=0;
            //System.out.println(digitAfterUiu);
            //System.out.println(in);
            String firstName = str.substring(0,in);     //shurur name
            //System.out.println(firstName);
            char ch = str.charAt(digitAfterUiu);
            //System.out.println(ch);
            if (Character.isDigit(ch)){
                //System.out.println("number to ase");
                //System.out.println(str.substring(forLastName));
                String forLast = str.substring(forLastName);   //sesher name
                for (int i = 0; i < in; i++){
                    char c = str.charAt(i);
                    if (Character.isLowerCase(c)){
                        n++;
                    }
                    else {
                        n=0;
                    }
                }
                if (forLast.equals(firstName) && n == (in)){
                    System.out.println("VALID STRING");
                }
                else {
                    System.out.println("INVALID STRING!!!");
                }
            }
            else {
                System.out.println("INVALID STRING!!!");
            }
        }
        else {
            System.out.println("INVALID STRING!!!");
        }
    }

    static void validNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        String str = sc.nextLine();
        char ch;
        int len = str.length();
        try {
            double d = Double.parseDouble(str);
            //System.out.println(d);
            for (int i=0; i< str.length(); i++){
                ch = str.charAt(i);
                if (Character.isLowerCase(ch) || Character.isUpperCase(ch) || str.charAt(len-1) == '.'){
                    System.out.println("INVALID NUMBER!!!");
                    break;
                }
                else {
                    System.out.println("VALID");
                    break;
                }
            }
        } catch (NumberFormatException x) {
            System.out.println("INVALID NUMBER!!!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the following commands to access menu:");

        while(true){
            System.out.println("1 - Validate UIU CSE ID");
            System.out.println("2 - Validate UIU CSE and EEE email address");
            System.out.println("3 - Validate a password");
            System.out.println("4 - Validate a number");
            System.out.println("5 - Validate a string");
            System.out.println("6 - EXIT\n");

            int choice = sc.nextInt();

            while (choice < 1 || choice > 6) {
                System.out.println("Enter one of these valid options: \"1\", \"2\", \"3\", \"4\", \"5\", \"6\" ");
                choice = sc.nextInt();
            }
            if (choice == 1){
                System.out.println("Enter ID: ");
                Scanner scan = new Scanner(System.in);
                String str = scan.nextLine();
                valID(str);
            }
            else if (choice == 2){
                validEmail();
            }
            else if (choice == 3){
                validPass();
            }
            else if (choice == 4){
                validNumber();
            }
            else if (choice == 5){
                validString();
            }
            else if (choice == 6){
                System.out.println("EXITING...");
                break;
            }
            System.out.println("\n-----------------ENTER A COMMAND AGAIN FOR FURTHER ACTIONS-----------------------\n");
        }
    }
}
