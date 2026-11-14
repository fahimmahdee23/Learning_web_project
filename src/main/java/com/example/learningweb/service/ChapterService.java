
package com.example.learningweb.service;

import com.example.learningweb.model.Chapter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterService {

    private final List<Chapter> chapters = new ArrayList<>();

    public ChapterService() {

        chapters.add(new Chapter(
                1,
                "Chapter 1",
                "Introduction to the subject",
                List.of("Introduction", "Basic Concepts", "Definitions")
        ));

        chapters.add(new Chapter(
                2,
                "Chapter 2",
                "Understanding fundamental principles",
                List.of("Fundamental Principles", "Important Terms", "Examples")
        ));

        chapters.add(new Chapter(
                3,
                "Chapter 3",
                "Exploring advanced concepts",
                List.of("Advanced Concepts", "Applications", "Problem Solving")
        ));

        chapters.add(new Chapter(
                4,
                "Chapter 4",
                "Revision and practical applications",
                List.of("Applications", "Important Questions", "Summary")
        ));
    }

    public List<Chapter> getAllChapters() {
        return chapters;
    }

    public Chapter getChapterByNumber(int number) {

        for (Chapter chapter : chapters) {

            if (chapter.getChapterNumber() == number) {
                return chapter;
            }
        }

        return null;
    }
}
