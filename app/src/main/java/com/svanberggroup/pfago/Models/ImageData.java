package com.svanberggroup.pfago.Models;

import java.io.Serializable;

public class ImageData implements Serializable {
    private String path;
    private String text;

    public ImageData(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
