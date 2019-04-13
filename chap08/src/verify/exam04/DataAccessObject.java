package verify.exam04;

public interface DataAccessObject {

        //public은 생략해도 무방하다.
        public void select();
        public void insert();
        public void update();
        public void delete();
}