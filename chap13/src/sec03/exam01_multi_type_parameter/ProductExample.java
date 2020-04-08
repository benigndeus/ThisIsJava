package sec03.exam01_multi_type_parameter;

public class ProductExample {
    public static void main(String[] args) {
        Product<Tv,String> product1 = new Product<Tv,String>();
        product1.setKind(new Tv());
        product1.setModel("Smart TV");

        Tv tv = product1.getKind();
        String tvModel = product1.getModel();

        /* Java7부터 다이아몬드 연산자(<>)를 사용하여 Generic를 Compiler가 자동으로 설정해준다. */
        Product<Car,String> product2 = new Product</* Here! */>();
        product2.setKind(new Car());
        product2.setModel("디젤");
        Car car = product2.getKind();
        String carModel = product2.getModel();

        /* 변수 미사용 주의 표시 없애기 */
        System.out.println(tv + " " + tvModel);
        System.out.println(car + " " + carModel);
    }
}