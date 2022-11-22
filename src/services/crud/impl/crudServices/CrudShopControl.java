package services.crud.impl.crudServices;

import models.Shop;
import services.ShopServices;
import services.impl.ShopServicesImpl;

import java.util.List;
import java.util.Scanner;

public class CrudShopControl {
    Scanner scanner = new Scanner(System.in);
    Shop shop = new Shop();
    ShopServices shopServices = new ShopServicesImpl();

    public void shopStart() {
        System.out.println("Choose action ");
        System.out.println("1. Save");
        System.out.println("2. Output all");
        System.out.println("3. Output by id");
        System.out.println("4. Edit (under development)");
        System.out.println("5. Delete by id");

        switchMethod(scanner.nextInt());

    }

    public void switchMethod(Integer n){
        switch (n){
            case 1:
                System.out.println("Enter shop name ");
                shop.setName(scanner.next());
                shopServices.save(shop);
                System.out.println("Shop saved");
                System.out.println("--------------");
                switchMethod(2);
                break;
            case 2:
                List<Shop> shopList = shopServices.findAll();
                shopList.stream().forEach(System.out::println);
                System.out.println("--------------");
                break;
            case 3:
                System.out.println("Enter id");
                System.out.println(shopServices.findById(scanner.nextLong()));
                System.out.println("--------------");
                break;
            case 4:
                System.out.println("Enter shop id to edit");
                shop.setId(scanner.nextLong());
                System.out.println("Enter shop name to edit");
                shop.setName(scanner.next());
                shopServices.update(shop);
                System.out.println("Shop updated");
                System.out.println("--------------");
                break;
            case 5:
                System.out.println("Enter id ");
                shopServices.delete(scanner.nextLong());
                System.out.println("Shop deleted");
                System.out.println("--------------");
                break;
        }
    }
}
