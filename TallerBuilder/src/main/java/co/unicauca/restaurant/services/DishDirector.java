package co.unicauca.restaurant.services;

import co.unicauca.restaurant.domain.Dish;

/**
 * Define el proceso de construcción de un Plato a la Carta
 * @author Luis Arroyo
 * @author Daniel Navia
 */
public class DishDirector {

    private DishBuilder builder;

    public DishDirector(DishBuilder builder) {
        this.builder = builder;
    }

    public Dish getDish() {
        return builder.getDish();
    }

    public void create() {
        boolean masPartes = true;
        builder.init();
        builder.setCore();
        while (masPartes) {
            masPartes = builder.addPart();
        }
        builder.setSize();
    }
}
