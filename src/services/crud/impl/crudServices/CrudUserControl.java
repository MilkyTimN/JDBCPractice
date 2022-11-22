package services.crud.impl.crudServices;

import models.BaseEntity;
import models.Shop;
import models.Users;
import services.ShopServices;
import services.UsersService;
import services.impl.ShopServicesImpl;
import services.impl.UsersServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudUserControl {

    Scanner scanner = new Scanner(System.in);
    Users user = new Users();
    ShopServices shopServices = new ShopServicesImpl();
    UsersService usersService = new UsersServiceImpl();
    List<Shop> shopList = shopServices.findAllIdName();
    List<Users> usersList = new ArrayList<>();



    public void userStart(){
        System.out.println("Choose action ");
        System.out.println("1. Save");
        System.out.println("2. Output all");
        System.out.println("3. Output by id");
        System.out.println("4. Edit (under development)");
        System.out.println("5. Delete by id");

        switchMethod(scanner.nextInt());
    }


    public void switchMethod(Integer n){
        switch (scanner.nextInt()){
            case 1:
                Users users = new Users();

                System.out.println("Enter user name");
                users.setName(scanner.next());
                System.out.println("Enter user login");
                users.setLogin(scanner.next());
                System.out.println("Enter user password");
                users.setPassword(scanner.next());
                System.out.println("Choose work place:");
                shopList.forEach(BaseEntity::toStringIdName);
                users.setShop(shopServices.findById(scanner.nextLong()));
                usersService.save(users);
                System.out.println("--------------");
                break;
            case 2:
                usersList = usersService.findAll();
                usersList.forEach(System.out::println);
                System.out.println("--------------");
                break;
            case 3:
                System.out.println("Enter id");
                System.out.println(usersService.findById(scanner.nextLong()));
                System.out.println("--------------");
                break;
            case 4:
                System.out.println("Enter user id to edit");
                user.setId(scanner.nextLong());
                System.out.println("Enter shop name to edit");
                user.setName(scanner.next());
                System.out.println("Enter user login");
                user.setLogin(scanner.next());
                System.out.println("Enter user password");
                user.setPassword(scanner.next());
                System.out.println("Choose work place:");
                shopList.forEach(BaseEntity::toStringIdName);
                user.setShop(shopServices.findById(scanner.nextLong()));
                usersService.update(user);
                System.out.println("Shop updated");
                System.out.println("--------------");
                break;
            case 5:
                System.out.println("Enter id ");
                usersService.delete(scanner.nextLong());
                System.out.println("User deleted");
                System.out.println("--------------");
                break;
        }
    }
}
