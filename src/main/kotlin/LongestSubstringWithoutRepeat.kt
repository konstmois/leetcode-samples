import java.util.*
import kotlin.collections.HashSet
import kotlin.math.max

// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class LongestSubstringWithoutRepeat {

    fun lengthOfLongestSubstring1(s: String): Int {
        var windowStart = 0
        var windowEnd = 0
        var result = 0
        val contentsOfWindow = HashSet<Char>()
        while (windowEnd < s.length) {
            if (contentsOfWindow.contains(s[windowEnd])) {
                contentsOfWindow.remove(s[windowStart])
                windowStart++
            } else {
                contentsOfWindow.add(s[windowEnd])
                windowEnd++
                result = Math.max(contentsOfWindow.size, result)
            }

        }
        return result

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

