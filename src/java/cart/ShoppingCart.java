/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

/**
 *
 * @author R-34
 */
import entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ShoppingCart {

    private List<Item> cart = new ArrayList<>();
    private double total;
    int cartsize;
    String item = "item";

    public String getItem() {

        if (cartsize > 1) {
            item = "items";

        }
        return item;
    }

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public double getTotal() {
        total = 0.0;
        for (Item item : cart) {
            total = total + (item.getQuantity() * item.getP().getProPrice());

        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCartsize() {
        return cartsize;
    }

    public void setCartsize(int cartsize) {
        this.cartsize = cartsize;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String addtocart(Product p) {
        if (cart.size() > 0) {
            for (Item item : cart) {
                if (item.getP().getProId().equals(p.getProId())) {
                    item.setQuantity(item.getQuantity() + 1);
                    return "cart";

                }
            }

        }
        Item i = new Item();
        i.setQuantity(1);
        i.setP(p);
        cart.add(i);
        System.out.println("I am hrer..");
        return "redirect to cart";

    }

    public void updateCart() {

    }

    public void removeCart(Item i) {
        for (Item item : cart) {
            if (item.equals(i)) {

                cart.remove(i);
                break;
            }
        }
    }
}
