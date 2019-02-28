package sec15.exam01_annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
	/* **************
	 * @Target : Annotation이 적용될 대상을 지정할 때 사용.
	 * ElementType : java.lang.annotation.ElementType 열거 상수로 정의되어 있다. -> need import it for using.
	 * ElementType.METHOD : 여기서는 Method에만 Annotation을 적용한다.
	 * ************** */

@Retention(RetentionPolicy.RUNTIME)
	/* **************
	 * "Annotation 유지 정책"
	 * 사용 용도에 따라 @AnnotationName을 어느 범위까지 유지할 것인지 지정해야 한다.
	 * 소스 상에서만 유지	||	컴파일된 클래스까지 유지	||	Runtime 시에도 유지
	 * 		SOURCE			||			CLASS				||		*RUNTIME		(여기서는 RUNTIME 사용)
	 * RetentionPolicy : java.lang.annotation.RetentionPolicy 열거 상수로 정의되어 있다. -> need import it for using.
	 * Retention [명] 1. (어떤 것을 잃지 않는) 보유[유지]  2. (액체·열기 등이 빠져나가지 않는) 정체[잔류]  3. 기억(력)
	 * Reflection : 리플렉션. 런타임 시에 클래스의 메타 정보를 얻는 기능.
	 * 	[명] [C] (어떤 것에 대한) 설명[묘사]
	 * 	1. Class가 가지고 있는 Field를 알고자 할 때.
	 * 	2. 어떤 Method를 가지고 있는지.
	 * 	3. 적용된 Annotation이 무엇인지.
	 * ************** */

public @interface PrintAnnotation {
	/* **************
	 * public : Access Modifier(접근제한자).
	 * @interface : Interface의 일종으로 Annotation에는 @를 붙인다.
	 * PrintAnnotation : Annotation name.
	 * ************** */
	
	String value() default "-";
	int number() default 15;

}
