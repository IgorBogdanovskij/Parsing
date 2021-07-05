package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.DateNews
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.R
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Adapter_ViewHolder():RecyclerView.Adapter<Adapter_ViewHolder.Vh>() {

   var listNews = mutableListOf<News>()
  //private var dataNews = DateNews()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return Vh(view)
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        Log.d("my", "onViewCreated NEws: ${listNews.size}")
        //Log.d("my", "onViewCreated NEws: ${dataNews.listNews.size}")
      val news = listNews[position]
      holder.bindView(news)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

  fun setList(list:MutableList<News>){
    listNews.clear()
    listNews.addAll(list)
    notifyDataSetChanged()
  }

    class Vh(private val view: View):RecyclerView.ViewHolder(view) {
      lateinit var mImage:ImageView
      lateinit var mDescription:TextView
      lateinit var mDate:TextView

      init {
          mImage = view.findViewById(R.id.Image)
          mDescription = view.findViewById(R.id.Description)
          mDate = view.findViewById(R.id.dateNews)
        }

      fun bindView(news: News ){
          GlobalScope.launch(Dispatchers.Main) {
              mDescription.text = news.description
              Picasso.with(view.context)
                  .load(news.image)
                  .into(mImage)
              mDate.text = news.date

          }

      }
    }
}