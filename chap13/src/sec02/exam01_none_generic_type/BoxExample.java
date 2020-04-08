package sec02.exam01_none_generic_type;

public class BoxExample {
    public static void main(String[] args) {
        Box box = new Box();

        box.set("홍길동");
        String name = (String)box.get();

        /* 변수 미사용 주의 표시 없애기 */
        System.out.println(name);

        box.set(new Apple());
        Apple apple = (Apple)box.get();

        /* 변수 미사용 주의 표시 없애기 */
        System.out.println(apple);
    }
}