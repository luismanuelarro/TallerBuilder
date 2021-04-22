package co.unicauca.restaurant.accces;

import co.unicauca.restaurant.domain.Product;
import java.util.List;

/**
 * Interface de los servicios del repositorio
 *
 * @author Luis Arroyo
 * @author Daniel Navia
 */
public interface IProductRepository {

    List<Product> findAll();

    Product findById(Integer id);

    boolean create(Product newProduct);

    boolean update(Product newProduct);

    boolean delete(Integer id);
}
