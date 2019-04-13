package sec02.exam02_constant_field;

public interface RemoteControl {
	
	/* Even if you do not add 'public static final',
	you can see that it is automatically applied as a constant.
	The interface must specify the initial value when declaring a field. */
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	/* You can not use static blocks in an interface.
	static {
		
	}
	*/
}
