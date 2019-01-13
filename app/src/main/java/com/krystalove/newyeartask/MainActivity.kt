package com.krystalove.newyeartask

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.Menu
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.R.array
import android.widget.ArrayAdapter
import android.support.v4.view.MenuItemCompat.getActionView
import android.widget.AdapterView
import android.widget.Spinner



lateinit var languages: ArrayList<ProgrammingLanguage>

class MainActivity : AppCompatActivity(), MyRecyclerViewAdapter.ItemClickListener, AdapterView.OnItemSelectedListener {

    override fun onItemClick(view: View, position: Int) {
        intent = Intent(this, WebViewActivity::class.java)
        Log.i("URL", languages[position].Url)
        intent.putExtra("URL",languages[position].Url)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        /*recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        val adapter = MyRecyclerViewAdapter(this, languages)
        adapter.setClickListener(this)*/
        recyclerView.also {
            it.setHasFixedSize(true)
            it.layoutManager = GridLayoutManager(this, 1)
            it.adapter = MyRecyclerViewAdapter(this, languages).also{ it.setClickListener(this) }
        }
        //recyclerView.adapter = adapter
    }
    private fun initData(){
        languages = ArrayList()
        languages.also {

            it.add(
                ProgrammingLanguage(
                    "Java",
                    "James Gosling",
                    "19 of May 1995",
                    listOf("OOP", "Structured", "Imperative", "Generic", "Reflective"),
                    getBitmap(R.drawable.java1),
                    "16.904%",
                    "https://en.wikipedia.org/wiki/Java_(programming_language)"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "C",
                    "Dennis Ritchie, Kenneth Thompson",
                    "1972",
                    listOf("Procedural", "Structured", "Imperative"),
                    getBitmap(R.drawable.c2),
                    "13.337%",
                    "https://en.wikipedia.org/wiki/C_(programming_language)"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "Python",
                    "Guido van Rossum",
                    "20 of February 1991",
                    listOf("OOP","Reflective", "Imperative", "Functional", "Aspect-oriented"),
                    getBitmap(R.drawable.python3),
                    "8.294%",
                    "https://en.wikipedia.org/wiki/Python_(programming_language)"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "C++",
                    "Bjarne Stroustrup",
                    "1983",
                    listOf("Procedural, Functional, OOP, Generic"),
                    getBitmap(R.drawable.cpp4),
                    "8.158%",
                    "https://en.wikipedia.org/wiki/C%2B%2B"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "Visual Basic. NET",
                    "Microsoft Corporation",
                    "2001",
                    listOf("Imperative", "OOP", "Structured", "Declarative", "Generic", "Even-driven"),
                    getBitmap(R.drawable.vnet5),
                    "6.459%",
                    "https://en.wikipedia.org/wiki/Visual_Basic_.NET"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "JavaScript",
                    "Brendan Eich",
                    "1995",
                    listOf("Imperative", "OOP", "Functional", "Aspect-oriented", "Generic", "Event-driven"),
                    getBitmap(R.drawable.vnet5),
                    "3.302%",
                    "https://en.wikipedia.org/wiki/JavaScript"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "C#",
                    "Anders Hejlsberg",
                    "2000",
                    listOf("OOP", "Procedural", "Functional", "Event-driven", "Generic", "Reflective"),
                    getBitmap(R.drawable.vnet5),
                    "3.284%",
                    "https://en.wikipedia.org/wiki/C_Sharp_(programming_language)"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "PHP",
                    "Rasmus Lerdof",
                    "1995",
                    listOf("OOP","Imperative"),
                    getBitmap(R.drawable.vnet5),
                    "2.680",
                    "https://en.wikipedia.org/wiki/PHP"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "SQL",
                    "Raymond Boyce, Donald Chemberlin",
                    "1974",
                    listOf("Declarative"),
                    getBitmap(R.drawable.vnet5),
                    "2.277%",
                    "https://en.wikipedia.org/wiki/SQL"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "Objective C",
                    "Brad Cox",
                    "1984",
                    listOf("Reflective","OOP"),
                    getBitmap(R.drawable.vnet5),
                    "1.781%",
                    "https://ru.wikipedia.org/wiki/Objective-C"
                )
            )
        }
    }
    private fun getBitmap(bitmapID: Int):Bitmap = BitmapFactory.decodeResource(resources, bitmapID)
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val item = menu.findItem(R.id.spinner)
        val spinner = item.actionView as Spinner
        //val paradigms = resources.getStringArray(R.array.paradigms)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.paradigms, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
        return true
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(position){

        }
    }


}
