package builder.nutrition;

public class NutritionFacts {
    private final int servings;//обязательный атрибут
    private final int cslories;// дополнительный атрибут
    private final int fat;// дополнительный атрибут

    public static class Biulder{

        private final int servings; //обязательный атрибут
        private int cslories = 0;// дополнительный атрибут
        private int fat = 0;// дополнительный атрибут

        public Biulder(int servings){
            this.servings = servings;
        }

        public Biulder cslories(int val){
            cslories = val;
            return this;
        }

        public Biulder fat(int val){
            fat = val;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }


    }

    private NutritionFacts(Biulder biulder){
        servings = biulder.servings;
        cslories = biulder.cslories;
        fat = biulder.fat;
    }

    public static void main(String[] args) {

        NutritionFacts beaf = new NutritionFacts.Biulder(10).cslories(898).fat(45).build();
        //создаётся Builder с нужными пораметнами, который создёт нужный нам объект
        NutritionFacts cocaCola = new NutritionFacts.Biulder(3).cslories(456).fat(22).build();

    }

}
