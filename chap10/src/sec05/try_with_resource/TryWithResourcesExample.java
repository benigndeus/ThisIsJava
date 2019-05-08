package sec05.try_with_resource;

public class TryWithResourcesExample {
        public static void main(String[] args) {
                try(FileInputStream fis = new FileInputStream("file.txt")) {
                        fis.read();
                        throw new Exception();
                } catch (Exception e) {
                        System.out.println("Exception processing code executed.");
                }
        }
}