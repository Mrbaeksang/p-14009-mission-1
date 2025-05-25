package com.back.domain.wiseSaying.entity;

public class WiseSaying {

    int id;
    String content;
    String author;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId(){
        return id;
    }

    public String getContent(){
        return content;
    }

    public String getAuthor(){
        return author;
    }

    @Override
    public String toString(){
        return  "아이디: " + id + "\n명언: " + content + "\n작가: " + author;
    }
}
