package numberrangesummarizer;


import java.util.Collection;


/**

 * Implement this Interface to produce a comma delimited list of numbers,

 * grouping the numbers into a range when they are sequential.

 */

public interface NumberRangeSummarizer {


    Collection<Integer> collect(String input);


    String summarizeCollection(Collection<Integer> input);

}
