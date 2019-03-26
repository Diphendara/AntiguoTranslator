package diphendara.antiguo.translator.parsers

import diphendara.antiguo.translator.dataObjects.KnowCase

class Antiguo2Text {
    companion object {
        fun parseNumber(inputText: String): String
        {
            val number: Long = inputText.toLong()
            val quotient = number / 10
            val remainder = number % 10

            return if (quotient.compareTo(0) == 0) {
                remainder.toString()
            } else {
                parseNumber(quotient.toString()) + remainder.toString()
            }
        }

        fun parseText(inputText: String): String
        {
            val cleanText = replaceKnownWords(inputText)

            return replaceCapitalConsonants(cleanText)
        }

        private fun replaceCapitalConsonants(inputText: String): String
        {
            val capitalChars = "BCDFGHJKLMPRSTVWXYZ"

            var cleanText = inputText

            capitalChars.toCharArray().forEachIndexed { index, element ->
                cleanText = cleanText.replace(element.toString(), element.toLowerCase()+"a")
            }

            return cleanText
        }

        private fun replaceKnownWords(inputText: String): String
        {
            var cleanText = inputText

            for (word in KnowCase.getKnownWords()) {
                cleanText = cleanText.replace(word.antiguoValue, word.value)
            }

            return cleanText
        }
    }
}