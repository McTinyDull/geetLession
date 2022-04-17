package com.will.geetbang.lesson7.multi1;

public enum Type {
    MASTER("master",0),SLAVE("slave",1);

    private final String name;
    private final int id;

    Type(String name,int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
