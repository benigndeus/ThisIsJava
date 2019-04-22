package sec05.exam02_anonymous_implements;

public class Anonymous {
        RemoteControl field = new RemoteControl() {
                @Override
                public void turnOn() {
                        System.out.println("Turn on the TV.");
                }

                @Override
                public void turnOff() {
                        System.out.println("Turn off the TV.");
                }
        };

        void method1() {
                RemoteControl localVar = new RemoteControl() {
                        @Override
                        public void turnOn() {
                                System.out.println("Turn on the Audio.");
                        }
        
                        @Override
                        public void turnOff() {
                                System.out.println("Turn off the Audio.");
                        }
                };
                localVar.turnOn();
                localVar.turnOff();
        }

        void method2(RemoteControl rc) {
                rc.turnOn();
                rc.turnOff();
        }
}