# 9장 중첩 클래스와 중첩 인터페이스 Nested Class&Interface

## 확인문제

1. 중첩 멤버 클래스에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 인스턴스 멤버 클래스는 바깥 클래스의 객체가 있어야 사용될 수 있다.  
  ② 정적 멤버 클래스는 바깥 클래스의 객체가 없어도 사용될 수 있다.  
  ③ 인스턴스 멤버 클래스 내부에는 바깥 클래스의 모든 필드와 메소드를 사용할 수 있다.  
  ④ 정적 멤버 클래스 내부에는 바깥 클래스의 인스턴스 필드를 사용할 수 있다.  

> 답 : 4  
정적 멤버 클래스는 바깥 클래스의 정적 필드만 사용할 수 있다.  
바깥 클래스의 객체가 있어야 존재하는 필드는 정적 클래스 내부에 둘 수 없다.  
  
---

2. 로컬 클래스에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 로컬 클래스는 메소드 내부에 선언된 클래스를 말한다.  
  ② 로컬 클래스는 바깥 클래스의 모든 필드와 메소드를 사용할 수 있다.  
  ③ 로컬 클래스는 static 키워드를 이용해서 정적 클래스로 만들 수 있다.  
  ④ final 특성을 가진 매개 변수나 로컬 변수만 로컬 클래스 내부에서 사용할 수 있다.  

> 답 : 3  
로컬 클래스는 static 키워드를 이용하여 정적 클래스로 만들 수 없다.  
  
---

3. 익명 객체에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 익명 객체는 클래스를 상속하거나 인터페이스를 구현해야만 생성될 수 있다.  
  ② 익명 객체는 필드, 매개 변수, 로컬 변수의 초기값으로 주로 사용된다.  
  ③ 익명 객체에는 생성자를 선언할 수 있다.  
  ④ 부모 클래스나 인터페이스에 선언된 필드와 메소드 이외에 다른 필드와 메소드를 선언할 수 있지만, 익명 객체 내부에서만 사용 가능하다.  

> 답 : 3  
한 번만 생성할 건데 뭐하러 생성자를 선언하냐~  
익명 객체는 기본 생성자를 사용한다.  
  
---

4. 다음과 같이 Car 클래스 내부에 Tire와 Engine이 멤버 클래스로 선언되어 있습니다. NestedClassExample에서 멤버 클래스의 객체를 생성하는 코드를 작성해보세요.  

【Car.java】
```java
public class Car {
        class Tire {}
        static class Engine {}
}
```

【NestedClassExample.java】
```java
public class NestedClassExample {
        public static void main(String[] args) {
                Car myCar = new Car();

                Car.Tire tire = myCar.new Tire();

                //Car.Engine engine = Car.new Engine(); 틀렸다.
                Car.Engine engine = new Car.Engine();
        }
}
```
  
---

5. AnonymousExample 클래스의 실행 결과를 보고 Vehicle 인터페이스의 익명 구현 객체를 이용해서 필드, 로컬 변수의 초기값과 메소드의 매개값을 대입해보세요.  

【Vehicle.java】
```java
public interface Vehicle {
        public void run();
}
```

【Anonymous.java】 익명 구현 클래스와 객체 생성
```java
public class Anonymous {
        Vehicle field = new Vehicle() {
                @Override
                public void run() {
                        System.out.println("자전거가 달립니다.");
                }
        };

        void method1() {
                Vehicle localVar = new Vehicle() {
                        @Override
                        public void run() {
                                System.out.println("승용차가 달립니다.");
                        }
                };
                localVar.run();
        }

        void method2(Vehicle v) {
                v.run();
        }
}
```

【AnonymousExample.java】 익명 구현 클래스와 객체 생성
```java
public class AnonymousExample {
        public static void main(String[] args) {
                Anonymous anony = new Anonymous();
                anony.field.run();
                anony.method1();
                anony.method2(
                        new Vehicle() {
                                @Override
                                public void run() {
                                        System.out.println("트럭이 달립니다.");
                                }
                        }
                );
        }
}
```
  
---

6. 다음 Chatting 클래스는 컴파일 에러가 발생합니다. 원인이 무엇입니까?  

【Chatting.java】
```java
public class Chatting {
        void startChat(String chatId) {

                // ① String nickName = chatId;
                String nickName = null;
                nickName = chatId;
                // ①

                Chat chat = new Chat() {
                        @Override
                        public void start() {
                                while(true) {
                                        String inputData = "안녕하세요";
                                        String message = "[" + nickName + "]" + inputData;
                                        sendMessage(message);
                                }
                        }
                };
                chat.start();
        }

        class Chat {
                void start() {}
                void sendMessage(String message) {}
        }
}
```

> ~~while문 안의 sendMessage() 메소드를 사용하기 위해서는 start() 메소드와 같이 익명 구현 객체 내부에서 재정의를 해야 한다.~~ 틀림. 그래도 sendMessage()메소드는 호출이 되나...?  
> local variable이 선언되면 final 특성을 가지므로 ①과 같이 수정해야 한다.  