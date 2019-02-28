package sec15.exam01_annotation;

import java.lang.reflect.*;

public class PrintAnnotationExample {

	public static void main(String[] args) {

		Method[] declaredMethods = Service.class.getDeclaredMethods();
		/* **************
		 * Class에 적용된 Annotation 정보를 얻으려면 java.lang.Class를 이용하면 되지만,
		 * Field, Constructor, Method에 적용된 정보를 얻으려면 java.lang.reflect package를 import.
		 * 여기서는 Method Annotation 정보가 필요하므로 위와 같이 사용한다.
		 * getDeclaredMethods() : Method에 직접 적용된 모든 Annotation을 Method Array로 리턴한다.
		 * ************** */
		
		for(Method method : declaredMethods) {
			if(method.isAnnotationPresent(PrintAnnotation.class)) {
				PrintAnnotation printAnnotation = 
						method.getAnnotation(PrintAnnotation.class);
				
				// Method Name Print
				System.out.println("[" + method.getName() + "]");
				
				// Division Line Print
				for(int i=0; i<printAnnotation.number(); i++) {
					System.out.print(printAnnotation.value());
				}
				System.out.println();
				
				
				// 예외처리 및 invoke는 나중에 학습.
				try {
					// Method Call
					method.invoke(new Service());
				} catch (Exception e) {}
				System.out.println();
				
				/*
				System.out.println(method.getName() + " : ");
				System.out.println("value = " + printAnnotation.value());
				System.out.println("number = " + printAnnotation.number());
				System.out.println();
				*/
				
				/*
				System.out.println(method.getName() + "에는 적용되어 있음.");
			} else {
				System.out.println(method.getName() + "에는 적용되어 있지 않음.");
				*/
			}
		}
	}
}
