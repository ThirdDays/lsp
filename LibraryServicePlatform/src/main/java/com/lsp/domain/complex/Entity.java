package com.lsp.domain.complex;

public class Entity <T>{
    private String id;
    private T object;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Admins{" +
                "id='" + id + '\'' +
                ", object=" + object +
                '}';
    }
}
