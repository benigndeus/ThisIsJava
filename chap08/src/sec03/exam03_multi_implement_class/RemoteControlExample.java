package sec03.exam03_multi_implement_class;

public class RemoteControlExample {
        public static void main(String[] args) {
                SmartTelevision tv = new SmartTelevision();

                RemoteControl rc = tv;
                rc.turnON();
                rc.turnOff();
                rc.setVolume(5);

                Searchable searchable = tv;
                searchable.search("https://benigndeus.github.io");
        }
}