package diphendara.antiguo.translator.dataObjects

class KnowCase(var value: String, var antiguoValue: String) {

    companion object {
        fun getKnownWords(): Array<KnowCase>
        {
            // https://cincoelementos.fandom.com/es/wiki/Lenguaje_Antiguo#Diccionario
            val knownWords = Array(14) { KnowCase("Agua", "HguH") }

            // Read the README to know why this values are like this
            knownWords[0] = KnowCase("agua", "HiW")
            knownWords[1] = KnowCase("argumento", "Hrugumentu")
            knownWords[2] = KnowCase("capitulo", "Cpitoru")
            knownWords[3] = KnowCase("mujer", "DoN")
            knownWords[4] = KnowCase("aire", "Er")
            knownWords[5] = KnowCase("espacio", "esPi")
            knownWords[6] = KnowCase("fuego", "fok")
            knownWords[7] = KnowCase("hombre", "hom")
            knownWords[8] = KnowCase("indice", "inodex")
            knownWords[9] = KnowCase("alkaesto", "OtoseHkL")
            knownWords[10] = KnowCase("personajes", "puerusoNtujes")
            knownWords[11] = KnowCase("abrir", "rirubo")
            knownWords[12] = KnowCase("templo", "erupmet")
            knownWords[13] = KnowCase("tierra", "tera")

            return knownWords
        }
    }
}

