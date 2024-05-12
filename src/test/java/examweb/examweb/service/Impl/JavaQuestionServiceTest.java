package examweb.examweb.service.Impl;

;
import examweb.examweb.exception.QuestionNotException;
import examweb.examweb.service.QuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static examweb.examweb.service.Impl.TestConstants.*;
import static org.assertj.core.api.Assertions.*;


class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    private final int MOCK_QUESTION_SIZE = 3;
    @BeforeEach
    public void beforeEach() {
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        questionService.add(QUESTION_3);
    }

    @Test
    public void shouldAddQuestion() {
        int beforeCount = questionService.getAll().size();
        assertThat(questionService.add(QUESTION_4))
                .isEqualTo(QUESTION_4)
                .isIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount + 1);

    }

    @Test
    public void shouldRemoveQuestion() {
        int beforeCount = questionService.getAll().size();
        assertThat(questionService.remove(QUESTION_1))
                .isEqualTo(QUESTION_1)
                .isNotIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount - 1);

    }

    @Test
    public void shouldThrowQuestionNotFoundException() {
        assertThatExceptionOfType(QuestionNotException.class)
                .isThrownBy(() -> questionService.remove(QUESTION_5));
    }

    @Test
    public void shouldGetAllQusestions() {
        assertThat(questionService.getAll())
                .hasSize(MOCK_QUESTION_SIZE)
                .containsExactlyInAnyOrder(
                        QUESTION_1,
                        QUESTION_2,
                        QUESTION_3
                );
    }
    @Test
    public void shouldReturnRandomQuestion(){
        assertThat(questionService.getRandomQuestion())
                .isNotNull()
                .isIn(questionService.getAll());
    }
}
