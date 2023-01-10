package com.amit.student.model;

import org.jetbrains.annotations.NotNull;

public class Student {

    private int id;

    private String name;

    private int age;

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

        public Student build() {
            Student student = new Student();
            student.id = id;
            student.name = name;
            student.age = age;
            student.email = email;
            return student;
        }
    }
}
