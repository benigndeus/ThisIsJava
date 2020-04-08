package sec04.exam01_generic_method;

public class BoxingMethodExample {
    public static void main(String[] args) {
        /* 명시적으로 구체적 타입을 지정 */
        Box<Integer> box1 = Util.<Integer>boxing(100);
        int value = box1.get();

        /* 매개값을 보고 구체적 타입을 추정 → 실제로 이렇게 쓰일 때가 많음 */
        Box<String> box2 = Util.boxing("홍길동");
        String strValue = box2.get();

         /* 변수 미사용 주의 표시 없애기 */
         System.out.println(value + " " + strValue);
    }
}