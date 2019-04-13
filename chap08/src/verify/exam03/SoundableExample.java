package verify.exam03;

public class SoundableExample {

        private static void printSounable(Soundable soundable) {
                System.out.println(soundable.sound());
        }

        public static void main(String[] args) {
                printSounable(new Cat());
                printSounable(new Dog());
        }
}