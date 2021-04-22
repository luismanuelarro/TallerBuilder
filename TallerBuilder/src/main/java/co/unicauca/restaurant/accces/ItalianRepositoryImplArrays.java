package co.unicauca.restaurant.accces;

import co.unicauca.restaurant.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Luis Arroyo
 * @author Daniel Navia
 */
public class ItalianRepositoryImplArrays implements IProductRepository {

    public static List<Product> products;

    public ItalianRepositoryImplArrays() {
        products = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        products.add(new Product(1, "Arroz blanco", 3500d,"Imagen Arroz blanco"));
        products.add(new Product(2, "Arroz italiano", 5000d,"Imagen Arroz italiano"));
        products.add(new Product(3, "Pasta italiana", 4000d,"Imagen Pasta italiana"));
        products.add(new Product(4, "Bistecca alla fiorentina", 4300d,"Imagen Bistecca alla fiorentina"));
        products.add(new Product(5, "ossobuco", 8000d,"Imagen ossobuco"));
        products.add(new Product(6, "Abbacchio", 10000d,"Imagen Abbacchio"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Integer id) {
        for (Product prod : products) {
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    @Override
    public boolean create(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            //Ya existe
            return false;
        }
        products.add(newProduct);
        return true;
    }

    @Override
    public boolean update(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            prod.setName(newProduct.getName());
            prod.setPrice(newProduct.getPrice());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        for (Product prod : products) {
            if (prod.getId() == id) {
                products.remove(prod);
                return true;
            }
        }
        return false;
    }
}
