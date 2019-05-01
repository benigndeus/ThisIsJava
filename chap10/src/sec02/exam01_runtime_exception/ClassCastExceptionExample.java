package sec02.exam01_runtime_exception;

public class ClassCastExceptionExample {
        public static void main(String[] args) {
                Dog dog = new Dog();
                changeDog(dog);

                Cat cat = new Cat();
                changeDog(cat);
        }

        public static void changeDog(Animal animal) {
                if(animal instanceof Dog) {
                        Dog dog = (Dog) animal;
                } else {
                        System.out.println("Changing into 'Dog' is impossible.");
                }
        }
}

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}