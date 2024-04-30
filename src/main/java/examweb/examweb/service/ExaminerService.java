package examweb.examweb.service;

import examweb.examweb.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
