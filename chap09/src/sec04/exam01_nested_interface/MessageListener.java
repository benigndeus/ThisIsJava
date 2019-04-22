package sec04.exam01_nested_interface;

import sec04.exam01_nested_interface.Button.OnClickListener;

public class MessageListener implements OnClickListener {
        @Override
        public void onClick() {
                System.out.println("Message.");
        }
}