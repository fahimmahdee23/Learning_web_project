
package com.example.learningweb.model;

import java.util.List;

public class Chapter {

    private int chapterNumber;
    private String chapterTitle;
    private String description;
    private List<String> notes;

    public Chapter(int chapterNumber, String chapterTitle,
                   String description, List<String> notes) {

        this.chapterNumber = chapterNumber;
        this.chapterTitle = chapterTitle;
        this.description = description;
        this.notes = notes;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getNotes() {
        return notes;
    }
}
