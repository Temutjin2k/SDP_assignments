public class main {
    public interface Creature{
        void speak();
    }

    public static class Human implements Creature{
        private String name;
        private String group;
        public Human(String name, String group){
            this.name = name;
            this.group = group;
        }

        public void speak(){
            System.out.println("Hello my name is " + this.name);
            System.out.println("I'm from group " + this.group);
        }
    }

    public static void main(String[] args) {
        Creature temutjin = new Human("Temutjin Koszhanov", "SE-2308");
        temutjin.speak();
    }
}
