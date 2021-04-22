package co.unicauca.restaurant.accces;

import co.unicauca.restaurant.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación por defecto. El framewok contenedor de CDI (Contexts and
 * Dependency Injection) carga la implementación por defecto.
 *
 * @author Luis Arroyo
 * @author Daniel Navia
 */
public class OrientalRepositoryImplArrays implements IProductRepository {

    /**
     * Por simplicidad los datos se cargan en un array.
     */
    public static List<Product> products;

    public OrientalRepositoryImplArrays() {
        products = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        products.add(new Product(1, "Arroz con verduras", 3000d,"Imagen Arroz con verduras"));
        products.add(new Product(2, "Ramen", 6000d,"Imagen Ramen"));
        products.add(new Product(3, "Pasta", 4000d,"Imagen Pasta"));
        products.add(new Product(4, "Pollo Teriyaki", 7200d,"Imagen Pollo Teriyaki"));
        products.add(new Product(5, "Cerdo a la Naranja", 8200d,"Imagen Cerdo a la Naranja"));
        products.add(new Product(6, "Res asada", 6000d,"Imagen Res asada"));

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
