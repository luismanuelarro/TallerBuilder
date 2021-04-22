package co.unicauca.restaurant.domain;

/**
 * @author Luis Arroyo
 * @author Daniel Navia
 */
public class Dish {

    protected double price;
    protected String compo;
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getComponentes()
    {
        return compo;
    }
}
