
import entities.User;
import functionalInterfaces.StringModify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        User aldo =new User("Aldo", "Baglio",20);
        User giovanni =new User("giovanni", "Storti",30);
        User giacomo =new User("giacomo", "Poretti",40);

        //Functional interfaces----------------------

        StringModify wrapper = str ->
        {
         return   "---" + str + "---";
        };
        System.out.println(wrapper.modify("ciao"));
        StringModify inverter = str -> {
            String[] splitted =str.split("");
            String inverted="";
            for(int i=splitted.length-1;i>=0;i--){
                inverted+= splitted[i];
            }
            return inverted;
        };

        System.out.println(inverter.modify("ciao"));

        //predicates------

        Predicate<Integer> isMoreThanZero= num -> {
            return num>0;
        };
        Predicate<Integer> isMoreThan1000= num -> {
            return num>1000;
        };
        System.out.println(isMoreThanZero.test(40));

        //supplier-------

        Supplier<Integer> integerSupplier=()->{
            Random rnd= new Random();
            return rnd.nextInt(1,101);
        };
        Supplier<User> userSupplier=()->{
           return new User("nome","congnome",integerSupplier.get());
        };
        List<Integer> intList= new ArrayList<>();
        List<User> userList= new ArrayList<>();
        for (int i=0;i<100;i++){
            intList.add(integerSupplier.get());
            userList.add(userSupplier.get());
        }
        System.out.println(intList);
//        intList.forEach(integer -> System.out.println(integer));

//        userList.stream().map()



//        STREAMS--------------- servono per applicare le operazioni
//        MAP---FILTER ECC..

//        FILTER---

        Predicate<Integer> isMoreThan10= num -> num>10;
        Predicate<Integer> isLessThan20= num -> num<20;
        List<Integer> filteredInt= new ArrayList<>();
//        intList.stream().filter(num->num<20); //cosi e' ancora uno stream non si puo stampare

        intList.stream().filter(num->(num>10&&num<20)).forEach(num->System.out.println(num));//senza predicate
        intList.stream().filter(isMoreThan10.and(isLessThan20)).forEach(num->filteredInt.add(num));
        //lo stream va sempre chiuso, il foreach lo chiude
        System.out.println(filteredInt);

        userList.stream().map(user -> user.getName()).forEach(era->System.out.println(era));
//        userList.stream().forEach(user ->System.out.println(user.getName()));


        List<Integer> etaDegli= userList.stream().map(user -> user.getAge()).filter(isLessThan20).toList();
        //inserire tutto in una lista si chiude lo stream con tolist()!
        System.out.println("questa e l'eta "+etaDegli);


//        Reduce--------------------

        int totalAge= userList.stream().map(elem->elem.getAge()).reduce(0,(partialSum,currentElem)->partialSum+currentElem);
        System.out.println(totalAge+"total age");


        //controllo sugli elementi

       boolean a= userList.stream().allMatch(user -> user.getAge()>=18);// con allMatch ritrona ture se sono tutti mmaggiorenni o false in caso contrario
        System.out.println(a);

        if(userList.stream().anyMatch(user -> user.getAge()>=80)){
                System.out.println("c'e almeno qualcuno con piu di 80 anni");//con anyMatch controllo se almeno uno super la condizione
        }else{
            System.out.println("non c'e nessun con piu di 80 anni");
        }

        LocalDate today= LocalDate.now();//torna oggi
        System.out.println(today);


    }



}