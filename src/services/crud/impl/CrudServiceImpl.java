package services.crud.impl;

import models.*;
import services.*;
import services.crud.CrudService;
import services.crud.impl.crudServices.CrudShopControl;
import services.crud.impl.crudServices.CrudUserControl;
import services.impl.*;
import java.util.List;
import java.util.Scanner;

public class CrudServiceImpl implements CrudService {

    Scanner scanner = new Scanner(System.in);
    CategoryService categoryService = new CategoryServiceImpl();
    UsersService usersService = new UsersServiceImpl();
    ProductService productService = new ProductServiceImpl();
    CrudShopControl crudShopControl = new CrudShopControl();
    CrudUserControl crudUserControl = new CrudUserControl();
    ShopServices shopServices = new ShopServicesImpl();
    Users user = new Users();

    @Override
    public void getShopControl() {
        crudShopControl.shopStart();
    }

    //TODO
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
        crudUserControl.userStart();
    }

    //TODO
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

    //TODO
    @Override
    public void getCheckProductControl() {

    }
}
