package com.gabrieldev.classes;

/**
 *
 * @author gabrieldev
 */

public class Student {
    
    private int id;
    private String nome;

    public Student() {
    }

    public Student(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    
}
