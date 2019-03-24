package diphendara.antiguo.translator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.text.Editable
import android.text.TextWatcher

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        inputText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                antiguoTextView.text = parseText(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

    private fun parseText(inputText: String): String
    {
        var cleanText = replaceSpecialCases(inputText.toLowerCase())

        for (word in getKnownWords()) {
            if(word.value == cleanText) {
                cleanText = cleanText.replace(word.value, word.antiguoValue)
            }
        }

        return replaceConsonantsWithA(cleanText)
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
     private fun replaceSpecialCases(inputText: String): String {

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

    private fun getKnownWords(): Array<KnowWord> {

        // https://cincoelementos.fandom.com/es/wiki/Lenguaje_Antiguo#Diccionario
        val knownWords = Array(14) { KnowWord("Agua", "HguH") }

        // Read the README to know why this values are like this
        knownWords[0]  = KnowWord("agua", "HiW")
        knownWords[1]  = KnowWord("argumento", "Hrugumentu")
        knownWords[2]  = KnowWord("capitulo", "Cpitoru")
        knownWords[3]  = KnowWord("mujer", "DoN")
        knownWords[4]  = KnowWord("aire", "Er")
        knownWords[5]  = KnowWord("espacio", "esPi")
        knownWords[6]  = KnowWord("fuego", "fok")
        knownWords[7]  = KnowWord("hombre", "hom")
        knownWords[8]  = KnowWord("indice", "inodex")
        knownWords[9]  = KnowWord("alkaesto", "OtoseHkL")
        knownWords[10] = KnowWord("personajes", "puerusoNtujes")
        knownWords[11] = KnowWord("abrir", "rirubo")
        knownWords[12] = KnowWord("templo", "erupmet")
        knownWords[13] = KnowWord("tierra", "tera")

        return knownWords
    }
}
