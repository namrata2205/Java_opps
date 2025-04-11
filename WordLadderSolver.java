// 7. Word Ladder Solver using BFS
import java.util.*;
class WordLadderSolver 
{
    // Returns the length of the shortest transformation sequence
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) 
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) 
            {
                String current = queue.poll();
                char[] wordChars = current.toCharArray();
                for (int j = 0; j < wordChars.length; j++) 
                {
                    char originalChar = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) 
                    {
                        wordChars[j] = c;
                        String newWord = String.valueOf(wordChars);
                        if (newWord.equals(endWord)) return level + 1;
                        if (wordSet.contains(newWord)) 
                        {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    wordChars[j] = originalChar;
                }
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) 
    {
        WordLadderSolver solver = new WordLadderSolver();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result = solver.ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation sequence length: " + result);
    }
}
