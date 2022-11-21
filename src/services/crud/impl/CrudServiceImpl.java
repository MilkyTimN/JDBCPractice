package services.crud.impl;

import models.Categories;
import models.Product;
import models.Shop;
import models.Users;
import services.CategoryService;
import services.ProductService;
import services.ShopServices;
import services.UsersService;
import services.crud.CrudService;
import services.impl.CategoryServiceImpl;
import services.impl.ProductServiceImpl;
import services.impl.ShopServicesImpl;
import services.impl.UsersServiceImpl;

import java.util.Scanner;

public class CrudServiceImpl implements CrudService {

    Scanner scanner = new Scanner(System.in);
    ShopServices shopServices = new ShopServicesImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    UsersService usersService = new UsersServiceImpl();
    ProductService productService = new ProductServiceImpl();

    @Override
    public void getShopControl() {

        System.out.println("Choose action ");
        System.out.println("1. Save");
        System.out.println("2. Output all");
        System.out.println("3. Output by id");
        System.out.println("4. Edit (under development)");
        System.out.println("5. Delete by id");

        switch (scanner.nextInt()){
            case 1:
                Shop shop = new Shop();
                System.out.println("Enter shop name ");
                shop.setName(scanner.next());
                shopServices.save(shop);
                System.out.println("Shop saved");
                break;
            case 2:
                shopServices.findAll();
                break;
            case 3:
                System.out.println("Enter id");
                shopServices.findById(scanner.nextLong());
                break;
            case 4:
                System.out.println("Action 'Edit' is under development");
                break;
            case 5:
                System.out.println("Enter id ");
                shopServices.delete(scanner.nextLong());
                System.out.println("Shop deleted");
        }
    }

    @Override
    public void getCategoryControl() {
        System.out.println("Choose action ");
        System.out.println("1. Save");
        System.out.println("2. Output all");
        System.out.println("3. Output by id");
        System.out.println("4. Edit (under development)");
        System.out.println("5. Delete by id");

        switch (scanner.nextInt()){
            case 1:
                System.out.println("Enter category name");
                Categories category=new Categories();
                category.setName(scanner.next());
                categoryService.save(category);
                break;
            case 2:
                categoryService.findAll();
                break;
            case 3:
                System.out.println("Enter id");
                categoryService.findById(scanner.nextLong());
                break;
            case 4:
                System.out.println("Action 'Edit' is under development");
                break;
            case 5:
                System.out.println("Enter id ");
                categoryService.delete(scanner.nextLong());
                System.out.println("Category deleted");
        }
    }

    @Override
    public void getUserControl() {
        System.out.println("Choose action ");
        System.out.println("1. Save");
        System.out.println("2. Output all");
        System.out.println("3. Output by id");
        System.out.println("4. Edit (under development)");
        System.out.println("5. Delete by id");

        switch (scanner.nextInt()){
            case 1:
                Users users = new Users();

                System.out.println("Enter user name");
                users.setName(scanner.next());
                System.out.println("Enter user login");
                users.setLogin(scanner.next());
                System.out.println("Enter user password");
                users.setPassword(scanner.next());
                usersService.save(users);
                break;
            case 2:
                usersService.findAll();
                break;
            case 3:
                System.out.println("Enter id");
                usersService.findById(scanner.nextLong());
                break;
            case 4:
                System.out.println("Action 'Edit' is under development");
                break;
            case 5:
                System.out.println("Enter id ");
                usersService.delete(scanner.nextLong());
                System.out.println("User deleted");
        }

    }

    @Override
    public void getProductControl() {
        System.out.println("Choose action ");
        System.out.println("1. Save");
        System.out.println("2. Output all");
        System.out.println("3. Output by id");
        System.out.println("4. Edit (under development)");
        System.out.println("5. Delete by id");

        switch (scanner.nextInt()){
            case 1:
                Product product = new Product();

                System.out.println("Enter user name");
                product.setName(scanner.next());
                System.out.println("Enter product price");
                product.setPrice(scanner.nextDouble());
                System.out.println("Enter product discount");
                product.setDiscount(scanner.nextInt());
                productService.save(product);
                break;
            case 2:
                usersService.findAll();
                break;
            case 3:
                System.out.println("Enter id");
                usersService.findById(scanner.nextLong());
                break;
            case 4:
                System.out.println("Action 'Edit' is under development");
                break;
            case 5:
                System.out.println("Enter id ");
                productService.delete(scanner.nextLong());
                System.out.println("Product deleted");
        }
    }
}
