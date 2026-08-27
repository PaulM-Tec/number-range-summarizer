# Number Range Summarizer
 
Implementation of the provided `NumberRangeSummarizer` interface.
 
## Problem Statement
 
Given a comma-separated list of numbers, produce a summarized representation by grouping sequential numbers into ranges.
 
Example:
 
Input:
 
1,3,6,7,8,12,13,14,15,21,22,23,24,31
 
Output:
 
1,3,6-8,12-15,21-24,31
 
## Assumptions
 
- Empty input returns an empty collection.
- Invalid values result in an IllegalArgumentException.
- Duplicate values are removed.
- Input order is preserved.
 
## Design Decisions
 
- `LinkedHashSet` is used to preserve insertion order while removing duplicates.
- Input validation follows a fail-fast approach.
- The summarization algorithm runs in O(n) time complexity.
 
## Running Tests
 
```bash
mvn test