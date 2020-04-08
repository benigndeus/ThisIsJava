package sec02.exam02_generic_type;

public class BoxExample {
    public static void main(String[] args) {
        Box<String> box1 = new Box<String>();

        box1.set("hello");
        String str = box1.get();

        Box<Integer> box2 = new Box<Integer>();

        box2.set(7);
        int value = box2.get();

        /* 변수 미사용 주의 표시 없애기 */
        System.out.println(str);
        System.out.println(value);
    }
}