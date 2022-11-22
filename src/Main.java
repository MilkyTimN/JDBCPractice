import dao.DbHelper;
import dao.impl.DbHelperImpl;
import services.crud.CrudService;
import services.crud.impl.CrudServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CrudService crudService = new CrudServiceImpl();

        while (true) {
            System.out.println("Choose action ");
            System.out.println("1. Service ");
            System.out.println("2. Operation  ");

            if (scanner.nextInt() == 1) {
                System.out.println("Choose service ");
                System.out.println("1. Shops");
                System.out.println("2. Users");
                System.out.println("3. Categories");
                System.out.println("4. Products");

                switch (scanner.nextInt()) {
                    case 1:
                        crudService.getShopControl();
                        break;
                    case 2:
                        crudService.getUserControl();
                        break;
                    case 3:
                        crudService.getCategoryControl();
                        break;
                    case 4:
                        crudService.getProductControl();
                        break;

                }
                System.out.println("Continue?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                if (scanner.nextInt() == 2){
                    break;
                }
            }
        }
    }
}
