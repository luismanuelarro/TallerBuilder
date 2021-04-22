/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.builder;

import co.unicauca.restaurant.DishApp.ItalianDish;
import co.unicauca.restaurant.DishApp.ItalianDishBuilder;
import co.unicauca.restaurant.DishApp.OrientalDish;
import co.unicauca.restaurant.DishApp.OrientalDishBuilder;
import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.domain.Product;
import co.unicauca.restaurant.domain.Size;
import co.unicauca.restaurant.services.DishBuilder;
import co.unicauca.restaurant.services.DishDirector;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

/**
 * @author Luis Arroyo
 * @author Daniel Navia
 */
public class DishTest {

    public DishTest() {

    }

    /**
     * Test para el plato Oriental
     *
     * @throws java.text.ParseException
     */
    @Test
    public void Oriental() throws ParseException {
        System.out.println("Oriental Dish");
        //Elementos del plato
        OrientalDish platoOriental;
        platoOriental = new OrientalDish(0.0);
        platoOriental.setBase(new Product(1, "Arroz con verduras", 3000d, "Imagen Arroz con verduras"));
        platoOriental.addOption(new Product(5, "Cerdo a la Naranja", 8200d, "Imagen Cerdo a la Naranja"));
        platoOriental.setSize(Size.DOUBLE);

        DishBuilder orientalBuilder = new OrientalDishBuilder();
        orientalBuilder.setDish(platoOriental);

        DishDirector director = new DishDirector(orientalBuilder);
        //director.create();
        Dish dish = director.getDish();
        assertEquals(22400, dish.getPrice());
    }

    /**
     * Test para el plato Italian
     *
     * @throws java.text.ParseException
     */
    @Test
    public void Italian() throws ParseException {
        System.out.println("Italian Dish");
        //Elementos del palto
        ItalianDish platoItalian;
        platoItalian = new ItalianDish(0.0);
        platoItalian.setBase(new Product(2, "Arroz italiano", 5000d, "Imagen Arroz italiano"));
        platoItalian.addOption(new Product(4, "Bistecca alla fiorentina", 4300d, "Imagen Bistecca alla fiorentina"));
        platoItalian.addOption(new Product(5, "ossobuco", 8000d, "Imagen ossobuco"));
        platoItalian.setSize(Size.PERSONAL);
        DishBuilder ItalianBuilder = new ItalianDishBuilder();
        ItalianBuilder.setDish(platoItalian);

        DishDirector director = new DishDirector(ItalianBuilder);

        Dish dish = director.getDish();
        assertEquals(17300, dish.getPrice());

        //Cambiano el tamaño 
        platoItalian.setSize(Size.FAMILY);
        ItalianBuilder.setDish(platoItalian);
        dish = director.getDish();
        assertEquals(51900, dish.getPrice());

    }
}
