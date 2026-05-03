package com.Zxyy.model;

import lombok.Data;


public class MainTemplateConfig {
    private String author;
    private boolean loop;

    // 手动添加 setter 方法
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    // 可选：添加 getter 方法
    public String getAuthor() {
        return author;
    }

    public boolean isLoop() {
        return loop;
    }

}
