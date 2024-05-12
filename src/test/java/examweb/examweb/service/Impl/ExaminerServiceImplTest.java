package examweb.examweb.service.Impl;

import examweb.examweb.exception.IncorrectQuestionAmountException;
import examweb.examweb.exception.QuestionNotException;
import examweb.examweb.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static examweb.examweb.service.Impl.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldThrowIncorrectQuestionAmountException() {
        when(questionService.getAll())
                .thenReturn(MOCK_QUESTIONS);
        assertThatExceptionOfType(IncorrectQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));

        assertThatExceptionOfType(IncorrectQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(MOCK_QUESTIONS.size() + 1));
    }

    @Test
    public void shouldReturnRandomQuestion(){
        when(questionService.getAll())
                .thenReturn(MOCK_QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(
                QUESTION_1,
                QUESTION_2,
                QUESTION_3,
                QUESTION_4
        );
        int questionAmount = MOCK_QUESTIONS.size()-2;

        assertThat(examinerService.getQuestions(questionAmount))
                .hasSize(questionAmount);

    }
}