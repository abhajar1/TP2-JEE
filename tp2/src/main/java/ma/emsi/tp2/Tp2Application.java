package ma.emsi.tp2;

import ma.emsi.tp2.entities.Product;
import ma.emsi.tp2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;



@SpringBootApplication
public class Tp2Application implements CommandLineRunner{
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }
    @Override
    public void run(String... args) {
        System.out.println("Spring Boot application started. CommandLineRunner executed.");
        productRepository.save(new Product(null,"Computer",4300,3));
        productRepository.save(new Product(null,"Printer",1200,4));
        productRepository.save(new Product(null,"Smart Phone",3200,32));
        // ajout nv produit
       Product p1 = productRepository.save(new Product(null,"Laptop",12000,10));
        // suppression nv produit
       productRepository.delete(p1);
        // Consulter produits
        List<Product> products = productRepository.findAll();
        products.forEach(p-> {
            System.out.println(p.toString());
        });
        // recherche d un produit

        Product product = productRepository.findById(Long.valueOf(1))
                .orElse(null);
        if (product == null) {
            System.out.println("Product with ID 1 not found."); }
        else {

            //Product product1=productRepository.findById(Long.valueOf(1)).get();
            System.out.println("******************");
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getQuantity());
            System.out.println("*********************");
        }
        System.out.println("--- FIND BY NAME CONTAINING");
        List<Product> productList= productRepository.findByNameContaining("C");
        productList.forEach(p-> {
            System.out.println(p);
        });

        System.out.println("SEARCH ");
        System.out.println("----------------------");
        List<Product> productList2= productRepository.search("%C%");
        productList.forEach(p2-> {
            System.out.println(p2);
        });
        System.out.println("----------------------");
        System.out.println("SEARCH BY PRICE");
        List<Product> productList3= productRepository.searchByPrice(3000);
        productList.forEach(p2-> {
            System.out.println(p2);
        });


    }

}
