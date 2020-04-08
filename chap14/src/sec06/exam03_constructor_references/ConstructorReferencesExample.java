package sec06.exam03_constructor_references;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferencesExample {
    public static void main(String[] args) {
        Function<String,Member> function1 = Member :: new;
        Member member1 = function1.apply("angel");

        BiFunction<String,String,Member> function2 = Member :: new;
        Member member2 = function2.apply("신천사", "angel");

        Supplier<Member> function3 = Member :: new;
        Member member3 = function3.get();

        System.out.println(member1 + "\n" + member2 + "\n" + member3);
    }
}