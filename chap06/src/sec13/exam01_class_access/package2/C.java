package sec13.exam01_class_access.package2;

import sec13.exam01_class_access.package1.*;

public class C {
	// A class의 접근 제한자가 default 이므로 사용할 수 없다.
	// default 접근 제한자는 같은 package 에서만 호출할 수 있다.
	//A a;
	
	// 그래도 import 해서 사용해야 함.
	B b;
}
