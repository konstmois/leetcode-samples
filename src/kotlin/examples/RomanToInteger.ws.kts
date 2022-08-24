// 13 https://leetcode.com/problems/roman-to-integer/
class Solution {
    val numbers = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    val previousSubstract = mapOf(
        'V' to 'I',
        'X' to 'I',
        'L' to 'X',
        'C' to 'X',
        'D' to 'C',
        'M' to 'C'
    )

    fun romanToInt(s: String): Int {
        val chars = s.toCharArray()
        var result = 0
        var previous: Char? = null
        for (i in s.indices) {
            result+=numbers[chars[i]]!!
            if (chars[i] != 'I' && previous == previousSubstract[chars[i]]) {
                result-=2*numbers[previous]!!
            }
            previous = chars[i]
        }
        return result
    }
}