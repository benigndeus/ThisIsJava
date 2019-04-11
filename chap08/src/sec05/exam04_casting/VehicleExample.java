package sec05.exam04_casting;

public class VehicleExample {
        public static void main(String[] args) {
                Vehicle vehicle = new Bus();

                vehicle.run();
                //vehicle.checkFare();
                /* ──────────────────────────────────────────── *
                 │ Vehicle interface에는 checkFare()가 정의되어 │
                 │ 있지 않기 때문에 checkFare()를 사용하기      │
                 │ 위해서는 Bus 자료형을 가진 변수에            │
                 │ Casting 하여 method를 사용한다.              │
                 * ──────────────────────────────────────────── */

                Bus bus = (Bus) vehicle;

                bus.run();
                bus.checkFare();
        }
}