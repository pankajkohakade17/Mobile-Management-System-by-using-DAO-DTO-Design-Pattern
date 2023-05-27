package Mobile1;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    static Scanner sc1=new Scanner(System.in);
    public static void main(String[] args) {
        boolean status=true;
        while (status){
            System.out.println("SELECT MODE OF OPERATION");
            System.out.println("1: ADD NEW MOBILE\n2: SEARCH MOBILE\n3: DELETE MOBILE");
            int ch= sc1.nextInt();
            switch (ch){
                case 1:
                    addMobile();
                    break;
                case 2:
                    System.out.println("1: SEARCH MOBILE BY COMPANY");
                    System.out.println("2: SEARCH MOBILE BY PRICE");
                    System.out.println("3: SEARCH MOBILE BY RAM");
                    System.out.println("4: SEARCH MOBILE BY CAMERA");
                    int choice= sc1.nextInt();
                    if (choice==1){
                        searchMobileByCompany();
                    } else if (choice==2) {
                        searchMobileByPrice();
                    } else if (choice==3) {
                        searchMobileByRam();
                    }
                    else if (choice==4){
                        searchMobileByCamera();
                    }
                    else {
                        System.out.println("INVALID CHOICE");
                    }
                    break;
                case 3:
                    deleteMobile();
                    break;
                default:
                    status=false;
            }
        }
    }
    private static void deleteMobile() {
        System.out.println("ENTER MODEL NO");
        int modelNo=sc1.nextInt();
        MobileDAO d5=new MobileDAO();
        int count=d5.deleteMobile(modelNo);
        System.out.println(count+" MOBILE DELETED SUCCESSFULLY");
    }
    private static void searchMobileByCamera() {
        System.out.println("ENTER START MP");
        double startMP= sc1.nextDouble();
        System.out.println("ENTER END MP");
        double endMP= sc1.nextDouble();
        MobileDAO d4=new MobileDAO();
        ArrayList<MobileDTO> mobilelist=d4.searchMobileByCamera(startMP,endMP);
        System.out.println("MODELNO\tMODELNAME\t\tCOMPANY\t\tRAM\t\tCAMERA\t\tPRICE");
        System.out.println("==============================================================");
        for (MobileDTO d1:mobilelist){
            System.out.println(d1);
        }
    }
    private static void searchMobileByRam() {
        System.out.println("SELECT RAM");
        System.out.println(2+"GB\t"+4+"GB\t"+6+"GB\t"+8+"GB");
        int ram= sc1.nextInt();
        MobileDAO d2=new MobileDAO();
        ArrayList<MobileDTO> mobilelist=d2.searchMobileByRam(ram);
        System.out.println("MODELNO\tMODELNAME\t\tCOMPANY\t\tRAM\t\tCAMERA\t\tPRICE");
        System.out.println("===============================================================");
        for (MobileDTO dt1:mobilelist){
            System.out.println(dt1);
        }
    }

    private static void searchMobileByPrice() {
        System.out.println("ENTER START PRICE");
        double startPrice= sc1.nextDouble();
        System.out.println("ENTER END PRICE");
        double endPrice= sc1.nextDouble();

        MobileDAO d2=new MobileDAO();
        ArrayList<MobileDTO> mobilelist=d2.searchMobileByPrice(startPrice,endPrice);
        System.out.println("MODELNO\tMODELNAME\t\tCOMPANY\t\tRAM\t\tCAMERA\t\tPRICE");
        System.out.println("==================================================================");
        for (MobileDTO d:mobilelist){
            System.out.println(d);
        }
    }
    private static void searchMobileByCompany() {
        System.out.println("ENTER COMPANY NAME");
        String name=sc1.next();
        MobileDAO d1=new MobileDAO();
        ArrayList<MobileDTO> mobilelist =d1.searchMobileByCompany(name);
        System.out.println("MODEL NAME");
        System.out.println("============");
        for (MobileDTO d:mobilelist){
            System.out.println(d.getModelName());
        }
    }
    private static void addMobile() {
        System.out.println("ENTER MODEL NO");
        int modelNo= sc1.nextInt();
        System.out.println("ENTER MODEL NAME");
        String modelName= sc1.next();
        System.out.println("ENTER MOBILE COMPANY");
        String company=sc1.next();
        System.out.println("ENTER RAM");
        int ram= sc1.nextInt();
        System.out.println("ENTER CAMERA");
        int camera= sc1.nextInt();
        System.out.println("ENTER MOBILE PRICE");
        double price=sc1.nextDouble();

        MobileDTO m=new MobileDTO();
        m.setModelNo(modelNo);
        m.setModelName(modelName);
        m.setCompany(company);
        m.setRam(ram);
        m.setCamera(camera);
        m.setPrice(price);

        MobileDAO m1=new MobileDAO();
        int result=m1.addMobile(m);
        System.out.println(result+" MOBILE ADDED SUCCESSFULLY");
    }
}
