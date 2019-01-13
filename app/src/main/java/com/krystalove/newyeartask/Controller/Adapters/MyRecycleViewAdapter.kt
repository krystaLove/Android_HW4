package com.krystalove.newyeartask.Controller.Adapters

import android.content.Context
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import com.krystalove.newyeartask.Model.ProgrammingLanguage
import com.krystalove.newyeartask.R
import com.krystalove.newyeartask.View.MainActivity
import java.util.*
import kotlin.collections.ArrayList


class MyRecyclerViewAdapter (context: Context, data: ArrayList<ProgrammingLanguage>) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>(), Filterable{

    private var mLanguagesData = ArrayList<ProgrammingLanguage>(0)
    private var mLanguagesDataFiltered = ArrayList<ProgrammingLanguage>()
    private val mInflater: LayoutInflater
    private var mClickListener: ItemClickListener? = null

    init {
        this.mInflater = LayoutInflater.from(context)
        for(it: ProgrammingLanguage in data) Collections.sort(it.paradigm)
        this.mLanguagesData = data
        this.mLanguagesDataFiltered = mLanguagesData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(mLanguagesDataFiltered.size==0) return
        val language = mLanguagesDataFiltered[position]
        holder.name.text = language.name
        holder.author.text = language.author
        holder.release.text = language.releaseDate
        holder.paradigm.text = language.paradigm.joinToString (", ")
        holder.rating.text = language.rating
        holder.logo.setImageBitmap(language.logo)
    }

    override fun getItemCount(): Int = mLanguagesDataFiltered.size

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        internal var logo:ImageView
        internal var name:TextView
        internal var author:TextView
        internal var release:TextView
        internal var paradigm:TextView
        internal var rating:TextView

        init {
            name = itemView.findViewById(R.id.language)
            author = itemView.findViewById(R.id.author)
            release = itemView.findViewById(R.id.release)
            paradigm = itemView.findViewById(R.id.paradigm)
            rating = itemView.findViewById(R.id.rating)
            logo = itemView.findViewById(R.id.logo)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        }
    }
    inner class ViewHolder2 internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        internal var logo:ImageView
        internal var name:TextView
        internal var author:TextView
        internal var release:TextView
        internal var paradigm:TextView
        internal var rating:TextView

        init {
            name = itemView.findViewById(R.id.language_2)
            author = itemView.findViewById(R.id.author_2)
            release = itemView.findViewById(R.id.release_2)
            paradigm = itemView.findViewById(R.id.paradigm_2)
            rating = itemView.findViewById(R.id.rating_2)
            logo = itemView.findViewById(R.id.logo_2)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        }
    }

    internal fun setClickListener(itemClickListener: MainActivity) {
        this.mClickListener = itemClickListener
    }

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    mLanguagesDataFiltered = mLanguagesData
                } else {
                    val filteredList = ArrayList<ProgrammingLanguage>()
                    for (it in mLanguagesData) {
                        if (it.paradigmMap[charString]==true)
                            filteredList.add(it)
                    }
                    mLanguagesDataFiltered = filteredList
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = mLanguagesDataFiltered
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
                mLanguagesDataFiltered = filterResults.values as ArrayList<ProgrammingLanguage>
                notifyDataSetChanged()
            }
        }
    }


}