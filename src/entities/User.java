package entities;

import java.util.Objects;
import java.util.Random;

public class User {
    private String name;
    private String sruname;
    private int age;
    private int id;

    public User(String name, String sruname, int age) {
        this.name = name;
        this.sruname = sruname;
        this.age = age;
        Random rnd= new Random();
        this.id = rnd.nextInt();
    }

    public String getName() {
        return name;
    }

    public String getSruname() {
        return sruname;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSruname(String sruname) {
        this.sruname = sruname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sruname='" + sruname + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && id == user.id && Objects.equals(name, user.name) && Objects.equals(sruname, user.sruname);
    }
        // se voglio cambiare il modo con cui si comparano basta scegliere il criterio
}
