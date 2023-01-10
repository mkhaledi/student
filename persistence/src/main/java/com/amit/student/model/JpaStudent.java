package com.amit.student.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
//defining class name as Table name
@Table
public class JpaStudent {
    //mark id as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    //defining name as column name
    @Column
    private String name;
    //defining age as column name
    @Column
    private int age;
    //defining email as column name
    @Column
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private int id;

        private String name;

        private int age;

        private String email;

        private Builder() {
            //
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setName(@NotNull String name) {
            this.name = name;
            return this;
        }

        public Builder setIdEmail(@NotNull String email) {
            this.email = email;
            return this;
        }
        public JpaStudent build() {
            JpaStudent student = new JpaStudent();
            student.id = this.id;
            student.name = this.name;
            student.age = this.age;
            student.email = this.email;
            return student;
        }
    }

    public Student toCore(){
        return Student.builder().setId(this.id).setAge(this.age).setIdEmail(this.email).setName(this.name).build();
    }

    public static JpaStudent fromCore(Student s){
        return JpaStudent.builder().setId(s.getId()).setAge(s.getAge()).setIdEmail(s.getEmail()).setName(s.getName()).build();
    }
}
