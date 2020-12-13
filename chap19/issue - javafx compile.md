# vscode에서 javafx 컴파일

##### ** 현재 빌드도구 사용 없이 학습을 목표로 `.class` 파일을 만들지 않는 프로젝트 환경이다.

#### 안타깝게도 javafx는 컴파일된 환경에서만 작동하므로 vscode에서 바로 실행시킬 수 없다. 현재로서 내 머리 안에서는. 따라서 컴파일하는 방법을 정리한다.

1. 프로젝트의 루트 경로로 이동해준다.
```bash
$ cd (프로젝트 경로)
```

2. `javac` 명령어로 컴파일 해준다.
```bash
$ javac --module-path "C:/Java/javafx-sdk-11.0.2/lib" --add-modules javafx.controls -encoding UTF-8 src/sec06/exam03_chatting/ServerExample.java
```
> 여러 옵션들이 있는데, 설명은 나중에 차차 하도록 하자

3. `java` 명령어로 컴파일된 `.class` 파일을 실행한다.
```bash
$ java --module-path "C:/Java/javafx-sdk-11.0.2/lib" --add-modules javafx.controls -cp src sec06.exam03_chatting.ServerExample
```
> `-cp` 옵션은 classpath를 명시해주는 것으로, class 파일이 어디서부터 존재하냐는 의미다. 2번에서 컴파일 경로를 명시하지 않았으므로 bin이 아닌 src에 생성되어 있다. 따라서 `-cp src` 로 지정했다.