package verify.exam04;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty  name;
    private SimpleIntegerProperty kor;
    private SimpleIntegerProperty math;
    private SimpleIntegerProperty eng;

    public Student() {
        this.name = new SimpleStringProperty ();
        this.kor  = new SimpleIntegerProperty();
        this.math = new SimpleIntegerProperty();
        this.eng  = new SimpleIntegerProperty();
    }

    public Student(String name, int korean, int math, int english) {
        this.name = new SimpleStringProperty (name);
        this.kor  = new SimpleIntegerProperty(korean);
        this.math = new SimpleIntegerProperty(math);
        this.eng  = new SimpleIntegerProperty(english);
    }

    public String getName() { return this.name.get(); }
    public int    getKor()  { return this.kor.get();  }
    public int    getMath() { return this.math.get(); }
    public int    getEng()  { return this.eng.get();  }

    public void setName(String name) { this.name.set(name); }
    public void setKor (int kor)     { this.kor.set(kor);   }
    public void setMath(int math)    { this.math.set(math); }
    public void setEng (int eng)     { this.eng.set(eng);   }
}