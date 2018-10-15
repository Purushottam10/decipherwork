package com.decipher;

/**
 * @author purushottan
 * Model class or Pojo class
 */
public class Student {
    private String name;
    private int id;
    private int age;

    /**
     * Student Constructor for inserting records
     */
    public Student(String name, int age, int id)           {
        setId(id);
        setName(name);
        setAge(age);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {

        return id + " " + name + " " + age;
    }

}
//end class
