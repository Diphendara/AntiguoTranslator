package diphendara.antiguo.translator.parsers

import diphendara.antiguo.translator.dataObjects.KnowCase
import diphendara.antiguo.translator.dataObjects.RegexReplace

class Text2Antiguo {
    companion object {
        fun parseText(inputText: String): String
        {
            var cleanText = replaceSpecialCases(inputText.toLowerCase())

            cleanText = replaceKnownWords(cleanText)

            return replaceConsonantsWithA(cleanText)
        }

        private fun replaceKnownWords(inputText: String): String
        {
            var cleanText = inputText

            for (word in KnowCase.getKnownWords()) {
                cleanText = cleanText.replace(word.value, word.antiguoValue)
            }

            return cleanText
        }

        private fun replaceConsonantsWithA(inputText: String): String
        {
            var textToChange = inputText
            val vowelA = "H"

            while (textToChange.indexOf('a') > -1) {
                val index: Int = textToChange.indexOf('a')

                if(index == 0) {
                    textToChange = vowelA + textToChange.substring(1)
                    continue
                }

                val prevChar = textToChange[index-1]

                if("eiou".indexOf(prevChar) > 0 ) {
                    textToChange = textToChange.substring(0, index) + vowelA + textToChange.substring(index+1)
                    continue
                }

                textToChange = textToChange.substring(0, index-1) + prevChar.toUpperCase() + textToChange.substring(index+1)
            }

            return textToChange
        }

        //For this method can be added a lot of more special cases
        private fun replaceSpecialCases(inputText: String): String
        {

            var cleanText: String = inputText

            val regexArray = arrayOf(
                RegexReplace(Regex("[àáäã]"), "a"),
                RegexReplace(Regex("[èéë]"), "e"),
                RegexReplace(Regex("[ìíï]"), "i"),
                RegexReplace(Regex("[òóöõ]"), "o"),
                RegexReplace(Regex("[ùúü]"), "u"),
                RegexReplace(Regex("[ÿý]"), "y"),
                RegexReplace(Regex("ñ"), "n"),
                RegexReplace(Regex("ç"), "c")
            )

            for (regexObj in regexArray) {
                val regex = regexObj.regex
                cleanText = regex.replace(cleanText, regexObj.replace)
            }

            return cleanText
        }

    }
}