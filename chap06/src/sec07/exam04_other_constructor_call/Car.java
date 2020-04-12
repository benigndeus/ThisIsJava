package sec07.exam04_other_constructor_call;

public class Car {
    // Field
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    Car() {}

    Car(String model) {
        
        /*this.model = model;
        this.color = null;
        this.maxSpeed = 0;*/
        
        this(model, null, 0);
        // 주석을 제외하고 this생성자 호출은 생성자 선언시 첫줄에 작성되어야 한다.
    }

    Car(String model, String color) {
        
        /*this.model = model;
        this.color = color;
        this.maxSpeed = 0;*/
        
        this(model, color, 0);
    }

    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
