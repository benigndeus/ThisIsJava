package sec04.exam01_nested_interface;

public class ButtonExample {
        public static void main(String[] args) {
                Button btn = new Button();

                btn.setOnClickListener(new CallListener());
                btn.touch();

                btn.setOnClickListener(new MessageListener());
                btn.touch();

                btn.setOnClickListener(new Button.OnClickListener() {
                        @Override
                        public void onClick() {
                                System.out.println("Take a picture.");
                        }
                });
                btn.touch();
        }
}