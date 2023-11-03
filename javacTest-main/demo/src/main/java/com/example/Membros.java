package com.example;

public class Membros {
    private int memberId;
    private String firstName;
    private String lastName;
    private int age;

    public Membros(int memberId, String firstName, String lastName, int age) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Membros{" +
                "memberId=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public void adicionarLivroEmprestado(Livro livro) {
    }
}

