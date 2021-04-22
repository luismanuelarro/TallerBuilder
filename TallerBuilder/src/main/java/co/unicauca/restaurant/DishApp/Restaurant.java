package co.unicauca.restaurant.DishApp;

import co.unicauca.restaurant.services.DishDirector;
import co.unicauca.restaurant.domain.Dish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Luis Arroyo
 * @author Daniel Navia
 */
public class Restaurant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        DishDirector director;
        Dish myDish;
        int opc;
        do {
            System.out.println("1. Menu oriental ");
            System.out.println("2. Menu italiano ");
            System.out.println("3. Salir");
            System.out.println("Que menu deseas ");
            opc = Integer.parseInt(entrada.readLine());
            switch (opc) {
                case 1:
                    director = new DishDirector(new OrientalDishBuilder());
                    director.create();
                    myDish = director.getDish();
                    System.out.println("El almuerzo esta compuesto por: " + myDish.getComponentes());
                    System.out.println("El precio del plato es: " + myDish.getPrice());
                    break;
                case 2:
                    director = new DishDirector(new ItalianDishBuilder());
                    director.create();
                    myDish = director.getDish();
                    System.out.println("El almuerzo esta compuesto por: " + myDish.getComponentes());
                    System.out.println("El precio del plato es: " + myDish.getPrice());
                    break;
            }

        } while (opc != 3);

    }
}
