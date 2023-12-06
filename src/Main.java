import Entitites.Customer;
import Entitites.Order;
import Entitites.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> productList= new ArrayList<>();
        List<Customer> customerList= new ArrayList<>();
        List<Order> oredrList= new ArrayList<>();

        Customer mario= new Customer("Mario",2);


        productList.add(new Product("harry potter e la pietra filosofale","Books",120));
        productList.add(new Product("Halo Reach","Books",80));
        productList.add(new Product("toys","Baby",140));
        productList.add(new Product("biberon","Baby",15));
        productList.add(new Product("playstation","Boys",500));
        productList.add(new Product("gaming pc","Boys",2000));
        productList.add(new Product("XboxSerieX","Boys",2000));

        oredrList.add(new Order("evaded",mario,productList));
        oredrList.add(new Order("evaded",mario,productList));
        oredrList.add(new Order("evaded",mario,productList));
        oredrList.add(new Order("evaded",mario,productList));

//            es1
        booksFilter(productList);
//        es2
        babyCategory(productList);
//        es2 corretto
        babyCategory2(oredrList);
//        es3
        discountBoys(productList);









    }


    //methods

    public static void booksFilter(List<Product> list){
        System.out.println("i prodotti con cateogoria Books e prezzo superiore a 200 sono:");
        list.stream().filter(product -> (product.getCategory().equals("Books")&&(product.getPrice()>100))).forEach(elem->System.out.println(elem));
    }
    public static void babyCategory(List<Product> list){
        System.out.println("i prodotti con cateogoria Baby");
        list.stream().filter(product -> (product.getCategory().equals("Baby"))).forEach(elem->System.out.println(elem));
    }
    public static void babyCategory2(List<Order> list){
        System.out.println("i prodotti con cateogoria Baby esguito nel modo giusto");
        list.stream().forEach(elem->elem.getProdutcs().stream().forEach(prod->{if (prod.getCategory().equals("Baby")){System.out.println(prod);}}));
    }
    public static void discountBoys(List<Product> list){
        System.out.println("Prodotti boys scontati");
        List<Product> discountedBoysLisy= list.stream().filter(product -> (product.getCategory().equals("Boys"))).toList();
        discountedBoysLisy.stream().forEach(elem->elem.setPrice(elem.getPrice()*0.9));
        discountedBoysLisy.forEach(elem->System.out.println(elem));
    }




}