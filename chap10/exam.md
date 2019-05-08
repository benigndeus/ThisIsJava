# 10장 예외 처리 Exception Handling

## 확인문제

1. 예외에 대한 설명 중 틀린 것은 무엇입니까?  
  ① 예외는 사용자의 잘못된 조작, 개발자의 잘못된 코딩으로 인한 프로그램 오류를 말한다.  
  ② `RuntimeException`의 하위 예외는 컴파일러가 예외 처리 코드를 체크하지 않는다.  
  ③ 예외는 `try-catch` 블록을 사용해서 처리된다.  
  ④ 자바 표준 예외만 프로그램에서 처리할 수 있다.  

> 답 : 4  
사용자 정의 예외 또한 처리할 수 있다.

---

2. `try-catch-finally` 블록에 대한 설명 중 틀린 것은 무엇입니까?  
  ① `try {}` 블록에는 예외가 발생할 수 있는 코드를 작성한다.  
  ② `catch {}` 블록에는 `try {}` 블록에서 발생한 예외를 처리하는 블록이다.  
  ③ `try {}` 블록에서 `return`문을 사용하면 `finally {}` 블록은 실행되지 않는다.  
  ④ `catch {}` 블록은 예외의 종류별로 여러 개 작성할 수 있다.  

> 답 : 3  
~~`try {}` 블록의 `return`문에 도달하기 전에 예외가 발생할 경우에는 `finally {}` 블록이 `catch {}` 블록을 거친 다음 실행된다.~~  
`return`문이 실행되더라도 `finally {}` 블록은 실행된다.

---

3. `throws`에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 생성자나 메소드의 선언 끝 부분에 사용되어 내부에서 발생된 예외를 떠넘긴다.  
  ② `throws` 뒤에는 떠넘겨야 할 예외를 쉼표(,)로 구분해서 기술한다.  
  ③ 모든 예외를 떠넘기기 위해 간단하게 `throws Exception`으로 작성할 수 있다.  
  ④ 새로운 예외를 발생시키기 위해 사용된다.  

> 답 : 4  
새로운 예외를 발생시킬 경우에는 `throw`를 사용한다.

---

4. `throw`에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 예외를 최초로 발생시키는 코드이다.  
  ② 예외를 호출한 곳으로 떠넘기기 위해 메소드 선언부에 작성된다.  
  ③ `throw`로 발생된 예외는 일반적으로 생성자나 메소드 선언부에 `throws`로 떠넘겨진다.  
  ④ `throw` 키워드 뒤에는 예외 객체 생성 코드가 온다.  

> 답 : 2  
~~실행 중 예외가 발생될 수 있는 부분에 작성한다.~~  
예외를 호출한 곳으로 떠넘기기 위해 메소드 선언부에 작성되는 것은 `throws`이다.

---

5. 다음과 같은 메소드가 있을 때 예외를 잘못처리한 것은 무엇입니까?  

```java
public void method1() throws NumberFormatException, ClassNotFoundException {...}
```

① `try { method1(); } catch(Exception e) {}`  
② `void method2() throws Exception { method1(); }`  
③ `try { method1(); } catch(Exception e) {} catch(ClassNotFoundExeption e) {}`  
④ `try { method1(); } catch(ClassNotFoundExeption e) {} catch(NumberFormatException e) {}`

> 답 : 3  
`catch {}` 블록이 여러 개 있을 경우 순차적으로 예외 처리 코드가 실행된다. `catch(Exception e) {}` 블록은 모든 예외를 처리하므로 그 뒤에 있는 `catch(ClassNotFoundExeption e) {}` 블록은 실행되지 않는다.

---

6. 다음 코드가 실행되었을 때 출력 결과는 무엇입니까?  

【`TryCatchFinallyExample.java`】
```java
public class TryCatchFinallyExample {
        public static void main(String[] args) {
                String[] strArray = { "10", "2a" };
                int value = 0;
                for(int i=0; i<=2; i++) {
                        try {
                                value = Integer.parseInt(strArray[i]);
                        } catch(ArrayIndexOutOfBoundsException e) {
                                System.out.println("인덱스를 초과했음");
                        } catch(NumberFormatException e) {
                                System.out.println("숫자로 변환할 수 없음");
                        } finally {
                                System.out.println(value);
                        }
                }
        }
}
```

【실행결과】
```text
10
숫자로 변환할 수 없음
10
인덱스를 초과했음
10
```

---

7. 로그인 기능을 `Member` 클래스의 `login()` 메소드에서 구현하려고 합니다. 존재하지 않는 ID를 입력했을 경우 `NotExistIDException`을 발생시키고, 잘못된 패스워드를 입력했을 경우 `WrongPasswordException`을 발생시키려고 합니다. `LoginExample`의 실행 결과를 보고 빈칸을 채워보세요.

【`NotExistIDException.java`】
```java
public class NotExistIDException extends Exception {
        public NotExistIDException() {}
        public NotExistIDException(String message) {
                super(message);
        }
}
```

【`WrongPasswordException.java`】
```java
public class WrongPasswordException extends Exception {
        public WrongPasswordException() {}
        public WrongPasswordException(String message) {
                super(message);
        }
}
```

【`LoginExample.java`】
```java
public class LoginExample {
        public static void main(String[] args) {
                try {
                        login("white", "12345");
                } catch(Exception e) {
                        System.out.println(e.getMessage());
                }

                try {
                        login("blue", "54321");
                } catch(Exception e) {
                        System.out.println(e.getMessage());
                }
        }

        public static void login(String id, String password) throws NotExistIDException, WrongPasswordException {
                // id가 "blue"가 아니라면 NotExistIDException 발생시킴
                if(!id.equals("blue")) {
                        throw new NotExistIDException("아이디가 존재하지 않습니다.");
                }

                // password가 "12345"가 아니라면 WrongPasswordException 발생시킴
                if(!password.equals("12345")) {
                        throw new WrongPasswordException("패스워드가 틀립니다.");
                }
        }
}
```

【실행결과】
```text
아이디가 존재하지 않습니다.
패스워드가 틀립니다.
```