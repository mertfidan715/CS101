public class User{

    private String name;
    private String orders;
    private String countOrders;
    private String eatenFoods;
    private int ID;
    private int numberOfOrders;
    private int age;
    private static int count = 0;

    public User(String name, int age){
        this.name = name;
        this.age = age;
        numberOfOrders = 0;
        this.ID = count;
        this.addUser();
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getOrders(){
        return this.orders;
    }
    
    public String getEatenFoods(){
        return this.eatenFoods;
    }
    
    public int getID(){
        return this.ID;
    }

    public int getNumberOfOrders(){
        return this.numberOfOrders;
    }

    public int getAge(){
        return this.age;
    }

    public static int getCount(){
        return count;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setOrders(Order order){
        if(numberOfOrders == 1){
            this.orders = order.getID() + "";
        }
        else{
            this.orders += "-"+order.getID();
        }
        
    }

    private void setCountOrders(Order order){
        if(numberOfOrders == 1){
            this.countOrders = order.getID() + "";
        }
        else{
            this.countOrders += order.getID();
        }
    }

    public void setNumberOfOrders(int numberOfOrders){
        this.numberOfOrders = numberOfOrders;
    }

    public void setEatenFoods(Order order){
        if(numberOfOrders == 1){
            this.eatenFoods = order.getOrderedFood().getName() + "";
        }
        else{
            this.orders += "-"+order.getOrderedFood().getName();
        }
    }

    public void addUser(){
        count++;
    }
    
    public boolean equals(User x){
        if (x.getName().equals(this.getName()) && x.getAge()==this.getAge() && x.getID() == this.getID()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean didEat(Food food){
        if (eatenFoods.contains(food.getName())){
            return true;
        }
        else{
            return false;
        }
    }

    public String pickOrderbyIndex(int index){
        if(index >= 1){
            return countOrders.charAt(index-1)+"";
        }
        else{
            return "";
        }    
    }

    public void addNewOrder(Order order){
        this.eatenFoods = this.eatenFoods + "-" + order.getOrderedFood().getName();
        this.numberOfOrders++;
        this.setOrders(order);
        this.setCountOrders(order);
        order.setUser(this);
    }

    public String toString(){
        return "User ID: "+this.getID()+" User Name: "+this.getName()+" Age: "+this.getAge();
    }
}