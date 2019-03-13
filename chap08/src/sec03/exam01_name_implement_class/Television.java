package sec03.exam01_name_implement_class;

public class Television implements RemoteControl {
        private int volume;

        @Override
        public void turnON() {
                System.out.println("TV를 켭니다.");
        }

        @Override
        public void turnOff() {
                System.out.println("TV를 끕니다.");
        }
        
        @Override
        public void setVolume(int volume) {
                if(volume > RemoteControl.MAX_VOLUME) {
                        this.volume = RemoteControl.MAX_VOLUME;
                } else if(volume < RemoteControl.MIN_VOLUME) {
                        this.volume = RemoteControl.MIN_VOLUME;
                } else {
                        this.volume = volume;
                }
                System.out.println("현재 TV 볼륨 : " + this.volume);
        }
}