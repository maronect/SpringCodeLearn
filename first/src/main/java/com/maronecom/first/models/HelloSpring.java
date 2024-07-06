package com.maronecom.first.models;

public class HelloSpring {
    private final long id;
    private final String content;

    public HelloSpring(long id, String content ){
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    
}
