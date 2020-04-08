package sec06.exam03_constructor_references;

public class Member {
    private String name;
    private String id;

    public Member() {
        System.out.println("Memeber() 실행");
    }

    public Member(String id) {
        System.out.println("Memeber(String id) 실행");
        this.id = id;
    }

    public Member(String name, String id) {
        System.out.println("Memeber(String name, String id) 실행");
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public String getId() { return id; }
}