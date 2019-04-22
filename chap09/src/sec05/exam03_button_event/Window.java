package sec05.exam03_button_event;

public class Window {
        Button button1 = new Button();
        Button button2 = new Button();

        Button.OnClickListener listener = new Button.OnClickListener() {
                @Override
                public void onClick() {
                        System.out.println("Call.");
                }
        };

        Window () {
                button1.setOnClickListener(listener);

                button2.setOnClickListener(new Button.OnClickListener() {
                        @Override
                        public void onClick() {
                                System.out.println("Send a messagge.");
                        }
                });
        }
}