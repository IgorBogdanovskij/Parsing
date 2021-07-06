package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.R
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

 class AdapterViewHolder(val callback:CallBack):RecyclerView.Adapter<AdapterViewHolder.Vh>() {

   interface CallBack{
       fun onClick(new:News)
   }

    var mListNews = mutableListOf<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return Vh(view)
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        Log.d("my", "onViewCreated NEws: ${mListNews.size}")
      val news = mListNews[position]
      holder.bindView(news)
    }

    override fun getItemCount(): Int {
        return mListNews.size
    }

  fun setList(list:MutableList<News>){
    mListNews.clear()
    mListNews.addAll(list)
    notifyDataSetChanged()
  }

    inner class Vh(private val view: View):RecyclerView.ViewHolder(view) {
      lateinit var mImage:ImageView
      lateinit var mTitle:TextView
      lateinit var mDate:TextView

      init {
          mImage = view.findViewById(R.id.Image)
          mTitle = view.findViewById(R.id.TitleItem)
          mDate = view.findViewById(R.id.dateNews)

          view.setOnClickListener {
              Log.d("my", "click: $adapterPosition")
              callback.onClick(mListNews[adapterPosition])
          }
        }

      fun bindView(news: News ){
          GlobalScope.launch(Dispatchers.Main) {
              mTitle.text = news.title
              Picasso.with(view.context)
                  .load(news.image)
                  .into(mImage)
              mDate.text = news.date

          }

      }
    }
}