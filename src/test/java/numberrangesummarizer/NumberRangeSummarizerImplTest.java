package numberrangesummarizer;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberRangeSummarizerImplTest {

    @Test
    void shouldCollectValidNumbers() {

        NumberRangeSummarizer summarizer =
                new NumberRangeSummarizerImpl();

        Collection<Integer> result =
                summarizer.collect("1,3,6,7,8");

        assertEquals(5, result.size());
    }

    @Test
    void shouldRemoveDuplicates() {

        NumberRangeSummarizer summarizer =
                new NumberRangeSummarizerImpl();

        Collection<Integer> result =
                summarizer.collect("1,1,2,2,3");

        assertEquals(3, result.size());
    }

    @Test

    void shouldThrowExceptionForInvalidInput() {

        NumberRangeSummarizer summarizer =

                new NumberRangeSummarizerImpl();

        assertThrows(

                IllegalArgumentException.class,

                () -> summarizer.collect("1,2,abc,4")

        );

    }

    @Test

    void shouldReturnEmptyCollectionForEmptyInput() {

        NumberRangeSummarizer summarizer =

                new NumberRangeSummarizerImpl();

        Collection<Integer> result =

                summarizer.collect("");

        assertEquals(0, result.size());

    }

    @Test
    void shouldSummarizeOfficialRequirementExample() {

        NumberRangeSummarizer summarizer =
                new NumberRangeSummarizerImpl();

        Collection<Integer> numbers =
                summarizer.collect(
                        "1,3,6,7,8,12,13,14,15,21,22,23,24,31"
                );

        String result =
                summarizer.summarizeCollection(numbers);

        assertEquals(
                "1,3,6-8,12-15,21-24,31",
                result
        );
    }

    @Test
    void shouldSummarizeSingleValue() {

        NumberRangeSummarizer summarizer =
                new NumberRangeSummarizerImpl();

        Collection<Integer> numbers =
                summarizer.collect("1");

        String result =
                summarizer.summarizeCollection(numbers);

        assertEquals("1", result);
    }

    @Test
    void shouldSummarizeCompleteRange() {

        NumberRangeSummarizer summarizer =
                new NumberRangeSummarizerImpl();

        Collection<Integer> numbers =
                summarizer.collect("1,2,3,4,5");

        String result =
                summarizer.summarizeCollection(numbers);

        assertEquals("1-5", result);
    }

    @Test
    void shouldSummarizeNonSequentialValues() {

        NumberRangeSummarizer summarizer =
                new NumberRangeSummarizerImpl();

        Collection<Integer> numbers =
                summarizer.collect("1,3,5,7");

        String result =
                summarizer.summarizeCollection(numbers);

        assertEquals("1,3,5,7", result);
    }

}