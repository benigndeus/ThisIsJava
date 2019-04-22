package sec04.exam01_nested_interface;

import sec04.exam01_nested_interface.Button.OnClickListener;

public class CallListener implements OnClickListener{
        @Override
        public void onClick() {
                System.out.println("Call.");
        }
}