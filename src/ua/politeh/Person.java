package ua.politeh;

import lombok.Getter;
import lombok.Setter;

public  class Person {
    @Setter @Getter int age;
    @Setter @Getter String name;

    @Override
    public String toString() {

        return "name = " + this.name + ", age = " + this.age;
    }
}
