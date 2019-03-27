package diphendara.antiguo.translator.parsers

class ParseNumber {
    companion object {
        fun parseNumber(inputText: String, base: Int): String
        {
            val number: Long = inputText.toLong()
            val quotient = number / base
            val remainder = number % base

            return if (quotient.compareTo(0) == 0) {
                remainder.toString()
            } else {
                parseNumber(quotient.toString(), base) + remainder.toString()
            }
        }
    }
}
