package main;
public class Cart {
   private Double discount;
   private Double total;
   public List<CartItem> cartItems = new ArrayList<>();
   
   public Double calculateTotal() {
      Double total = 0.0;
     for(CartItem item : cartItems){
        total += item.getPrice();
     }
      return total;
   }

}