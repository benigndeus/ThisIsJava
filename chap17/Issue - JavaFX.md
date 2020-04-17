# Issue - JavaFX

## vscode에서 JavaFX를 사용할 때 발생할 수 있는 이슈

### JavaFX 관련 API를 사용하면 빨간 밑줄이 그어지지만 실행은 잘 되는 상태

현재 정확한 이유는 모르지만 `.classpath` 파일을 수정하면 간단하게 해결할 수 있다.

&lt;default&gt;

```xml
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
    <classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8"/>
    <classpathentry kind="src" path="src"/>
    <classpathentry kind="output" path="bin"/>
</classpath>

```

&lt;update&gt;

```xml
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
    <classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8">
        <!-- <attributes>
            <attribute name="maven.pomderived" value="true"/>
        </attributes> -->
        <accessrules>
            <accessrule kind="accessible" pattern="javafx/**"/>
            <accessrule kind="accessible" pattern="com/sun/javafx/**"/>
        </accessrules>
    </classpathentry>
    <classpathentry kind="src" path="src"/>
    <classpathentry kind="output" path="bin"/>
</classpath>

```

위에서 주석처리된 부분은 maven을 사용하지 않아서 조치했는데, 주석처리해도 잘 실행되어 그냥 두었다.

---

### `.fxml`을 작성할 툴이 vscode에 없어 디버깅을 하기 힘들 경우

아무래도 eclipse를 사용하지 않는 이상 특별한 방법은 없는 듯 하다.

다만, SceneBuilder 프로그램으로 약간 조절해주면 알아서 디버깅을 해주긴 한다. 더미 코드들이 달라붙긴 하지만...:grinning:
