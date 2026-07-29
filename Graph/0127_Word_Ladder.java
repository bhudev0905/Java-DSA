/*
 * Problem: 127. Word Ladder
 * Difficulty: Medium
 * Topic: Principal, Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
 * Link: https://leetcode.com/problems/word-ladder/description/
 *
 * Approach: BFS traversal
 *
 * Time Complexity: O(N * L * 26) where N is the number of words in the wordList and L is the length of each word
 * Space Complexity: O(N * L) where N is the number of words in the wordList and L is the length of each word
 */


class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<Pair>();
        Set<String> st = new HashSet<>(wordList);

        st.remove(beginWord);
        q.add(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            String word = q.peek().word;
            int steps = q.peek().steps;

            q.remove();

            if (word.equals(endWord))
                return steps;

            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();
                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if (st.contains(newWord)) {
                        st.remove(newWord);
                        q.add(new Pair(newWord, steps + 1));
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }
}