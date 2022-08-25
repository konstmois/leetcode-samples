import java.util.*
// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class LongestSubstringWithoutRepeat {

    fun lengthOfLongestSubstring1(s: String): Int {
        var result = LinkedList<Char>()
        var size = 0
        for (i in s.indices) {
            val currentChar: Char = s[i]
            val temp = LinkedList<Char>()
            var finish = false
            if (result.isNotEmpty()) {
                do {
                    val currentInWindow = result[0]
                    temp.add(result.removeFirst())
                    if (currentInWindow == currentChar) {
                        finish = true
                    } else if (result.isEmpty()) {
                        finish = true
                        result = temp
                    }
                } while (!finish)
            }
            result.add(currentChar)
            if (size < result.size) {
                size = result.size
            }
        }
        return size
    }

    fun lengthOfLongestSubstring2(s: String): Int {
        var result = LinkedList<Char>()
        var size = 0
        for (i in s.indices) {
            val currentChar: Char = s[i]
            if (result.contains(currentChar)) {
                var toRemove = result[0]
                do {
                    toRemove = result.removeFirst()
                } while (toRemove != currentChar)
            }
            result.add(currentChar)
            if (size < result.size) {
                size = result.size
            }
        }
        return size;
    }

}

