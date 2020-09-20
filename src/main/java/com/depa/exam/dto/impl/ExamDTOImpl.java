package com.depa.exam.dto.impl;

import com.depa.exam.dto.CategoryDTO;
import com.depa.exam.dto.ExamDTO;
import com.depa.exam.model.exam.Exam;
import com.depa.exam.model.exam.ExamType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ExamDTOImpl implements ExamDTO {
    private ObjectId id;
    private String name;
    private String description;
    private List<QuestionDTOImpl> questions;
    private List<CategoryDTOImpl> categories;
    private Date startAt;
    private Date endAt;
    private ExamType type = ExamType.TRADITIONAL;

    public ExamDTOImpl(Exam exam) {
        this.id = exam.getId();
        this.name = exam.getName();
        this.description = exam.getDescription();
        this.questions = new ArrayList<>();
        this.categories = exam.getCategories();

        if (exam.getQuestions() != null) {
            exam.getQuestions().forEach(field -> {
                this.questions.add(new QuestionDTOImpl(field));
            });
        }
    }

    @Override
    public Exam toExam() {
        return new Exam(this);
    }

}
