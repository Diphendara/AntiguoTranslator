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

            for (word in getKnownWords()) {
                cleanText = cleanText.replace(word.antiguoValue, word.value)
            }

            return cleanText
        }

        private fun getKnownWords(): Array<KnowCase>
        {
            // https://cincoelementos.fandom.com/es/wiki/Lenguaje_Antiguo#Diccionario
            val knownWords = Array(14) { KnowCase("Agua", "HguH") }

            // Read the README to know why this values are like this
            knownWords[0]  = KnowCase("agua", "HiW")
            knownWords[1]  = KnowCase("argumento", "Hrugumentu")
            knownWords[2]  = KnowCase("capitulo", "Cpitoru")
            knownWords[3]  = KnowCase("mujer", "DoN")
            knownWords[4]  = KnowCase("aire", "Er")
            knownWords[5]  = KnowCase("espacio", "esPi")
            knownWords[6]  = KnowCase("fuego", "fok")
            knownWords[7]  = KnowCase("hombre", "hom")
            knownWords[8]  = KnowCase("indice", "inodex")
            knownWords[9]  = KnowCase("alkaesto", "OtoseHkL")
            knownWords[10] = KnowCase("personajes", "puerusoNtujes")
            knownWords[11] = KnowCase("abrir", "rirubo")
            knownWords[12] = KnowCase("templo", "erupmet")
            knownWords[13] = KnowCase("tierra", "tera")

            return knownWords
        }
    }
}