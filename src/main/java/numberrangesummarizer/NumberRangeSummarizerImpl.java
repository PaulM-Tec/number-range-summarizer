package numberrangesummarizer;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the NumberRangeSummarizer interface
 *
 * Assumptions:
 * - Empty input returns an empty collection.
 * - Invalid values result in IllegalArgumentException.
 * - Duplicate values are removed while preserving input order.
 */
public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {

        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        if (input.trim().isEmpty()) {
            return new LinkedHashSet<>();
        }

        // Preserve insertion order while automatically removing duplicates
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();

        String[] tokens = input.split(",");

        for (String token : tokens) {

            token = token.trim();

            // Convert each token to an Integer and fail fast if an invalid value is encountered
            try {

                Integer number = Integer.parseInt(token);

                numbers.add(number);

            } catch (NumberFormatException e) {

                throw new IllegalArgumentException(
                        "Invalid number: " + token, e);

            }
        }

        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        if (input == null || input.isEmpty()) {
            return "";
        }

        List<Integer> numbers = new ArrayList<>(input);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {

            int start = numbers.get(i);

            int end = start;

            // Continue extending the range while numbers remain sequential
            while (i + 1 < numbers.size()
                    && numbers.get(i + 1) == numbers.get(i) + 1) {

                end = numbers.get(i + 1);

                i++;
            }

            // Output either a single value or a range
            if (start == end) {
                result.append(start);
            } else {
                result.append(start)
                        .append("-")
                        .append(end);
            }

            if (i < numbers.size() - 1) {
                result.append(",");
            }
        }

        return result.toString();

    }
}