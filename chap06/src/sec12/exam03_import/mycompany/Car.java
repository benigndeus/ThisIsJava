package sec12.exam03_import.mycompany;

import sec12.exam03_import.hankook.*;
import sec12.exam03_import.hankook.Tire;
import sec12.exam03_import.hyundai.*;
import sec12.exam03_import.kumho.*;

public class Car {
	
	Engine engine = new Engine();
	SnowTire tire1 = new SnowTire();
	BigWidthTire tire2 = new BigWidthTire();
	
	Tire tire3 = new Tire();
	
	sec12.exam03_import.kumho.Tire tire4 = 
			new sec12.exam03_import.kumho.Tire();

}
