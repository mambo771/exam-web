package examweb.examweb.service.Impl;

import examweb.examweb.model.Question;

import java.util.Collection;
import java.util.Set;

public class TestConstants {
    public static final Question QUESTION_1 = new Question("question1", "answer1");
    public static final Question QUESTION_2 = new Question("question2", "answer2");
    public static final Question QUESTION_3 = new Question("question3", "answer3");
    public static final Question QUESTION_4 = new Question("question4", "answer4");
    public static final Question QUESTION_5 = new Question("question5", "answer5");
    public static final Collection<Question> MOCK_QUESTIONS = Set.of(
            QUESTION_1,
            QUESTION_2,
            QUESTION_3,
            QUESTION_4
    );


}
