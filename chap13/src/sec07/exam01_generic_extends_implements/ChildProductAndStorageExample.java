package sec07.exam01_generic_extends_implements;

public class ChildProductAndStorageExample {
    public static void main(String[] args) {
        ChildProduct<Tv, String, String> product = new ChildProduct<>();

        product.setKind(new Tv());
        product.setModel("Smart TV");
        product.setCompany("Samsung");

        Storage<Tv> storage = new StorageImpl<Tv>(100);
        storage.add(new Tv(), 0);
        Tv tv = storage.get(0);

        /* 변수 미사용 주의 표시 제거 */
        System.out.println(product.getCompany() + " " + product.getModel());
        System.out.println(tv);
    }
}