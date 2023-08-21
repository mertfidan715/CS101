public class Food {
    
    private String name;
    private String ingredients;
    private int calories;
    private String type;
    private double price;

    public Food(String name, double price){
        this.name = name;
        this.price = price;
        ingredients = "";
        calories = 0;
        price = 0;
    }

    public Food(String name, String ingredients, int calories, String type, double price){
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
        this.type = type;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public String getIngredients(){
        return this.ingredients;
    }

    public String getType(){
        return this.type;
    }

    public int getCalories(){
        return this.calories;
    }

    public double getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIngredients(String ingredients){
        this.ingredients = ingredients;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setCalories(int calories){
        this.calories = calories;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public boolean equals(Food food){
        if (food.getName().equals(this.getName()) && food.getIngredients().equals(this.getIngredients())){
            return true;
        }
        else{
            return false;
        }
    }

    public void addNewIngredients(String newIngredient){
        this.ingredients += ", " + newIngredient;
    }

    public boolean doesContain(String ingredient){
        if (this.ingredients.contains(ingredient)){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return this.getName()+" is a "+this.getType()+" dish.\n"+"It includes "+this.getIngredients()+".\n"+"Single portion contains "+this.getCalories()+" calories."+"\nSingle serving cost = "+this.getPrice()+"\n";
    }
}
