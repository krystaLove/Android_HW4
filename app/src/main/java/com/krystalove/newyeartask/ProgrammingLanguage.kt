package com.krystalove.newyeartask

import android.graphics.Bitmap

class ProgrammingLanguage(val name:String, val author:String, val releaseDate:String,
                          val paradigm:List<String>,val logo: Bitmap,
                          val rating: String, val Url:String){
    val paradigmMap = mutableMapOf<String, Boolean>()
    init {
        paradigmMap["Aspect-oriented"] = paradigm.contains("Aspect-oriented")
        paradigmMap["Declarative"] = paradigm.contains("Declarative")
        paradigmMap["Event-driven"] = paradigm.contains("Event-driven")
        paradigmMap["Functional"] = paradigm.contains("Functional")
        paradigmMap["Generic"] = paradigm.contains("Generic")
        paradigmMap["Imperative"] = paradigm.contains("Imperative")
        paradigmMap["OOP"] = paradigm.contains("OOP")
        paradigmMap["Procedural"] = paradigm.contains("Procedural")
        paradigmMap["Reflective"] = paradigm.contains("Reflective")
        paradigmMap["Structured"] = paradigm.contains("Structured")
    }

}