public class Order {
    
    private int ID;
    private Food orderedFood;
    private double portion;
    private double totalPrice = 0;
    private User user;
    private boolean discount = false;
    private static int count = 0;

    public Order(double portion, String name, double price){
        this.orderedFood = new Food(name, price);
        this.portion = portion;
        this.ID = count;
        this.addOrder();
    }

    public Order(double portion, Food orderedFood){
        this.orderedFood = orderedFood;
        this.portion = portion;
        this.ID = count;
        this.addOrder();
    }

    public boolean getDiscount(){
        return this.discount;
    }

    public User getUser(){
        return this.user;
    }

    public int getID(){
        return this.ID;
    }

    public Food getOrderedFood(){
        return this.orderedFood;
    }

    public double getPortion(){
        return this.portion;
    }

    public double getTotalPrice(){
        return this.totalPrice;
    }

    public static int getCount(){
        return count;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setDiscount(boolean discount){
        this.discount = discount;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public void setOrderedFood(Food food){
        this.orderedFood = food;
    }

    public void setPortion(double portion){
        this.portion = portion;
    }

    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    public void addOrder(){
        count++;
    }

    public boolean equals(Order order){
        if (order.getID() == this.getID()){
            return true;
        }
        else{
            return false;
        }
    }

    public void checkout(){
        if(this.getDiscount() == true){
            double result2 = (this.getPortion() * this.orderedFood.getPrice()) * 8.0 / 10.0;
            this.totalPrice = result2;
        }
        else if(this.getDiscount() == false){
            double result1 = this.getPortion() * this.orderedFood.getPrice();
            this.totalPrice = result1;
        }
    }

    public void increasePortion(int extraPortion){
        this.portion += extraPortion;
    }

    public String toString(){
        if (totalPrice == 0){
            return ">> Warning: This order is incomplete."+"\nDetails for Order "+this.getID()+":"+"\n"+" ".repeat(8)+this.orderedFood.getName()+" (x "+this.getPortion()+")"+"\n"+" ".repeat(8)+"TOTAL = "+this.totalPrice+"\n\n";
        }
        else{
            return "Details for Order "+this.getID()+":"+"\n"+" ".repeat(8)+this.orderedFood.getName()+" (x "+this.getPortion()+")"+"\n"+" ".repeat(8)+"TOTAL = "+this.totalPrice+"\n\n";
        }
    }
}
