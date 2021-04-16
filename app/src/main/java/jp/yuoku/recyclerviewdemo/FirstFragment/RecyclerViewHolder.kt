package jp.yuoku.recyclerviewdemo.FirstFragment

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.yuoku.recyclerviewdemo.R

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // 独自に作成したListener
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val itemTextView: TextView = view.findViewById(R.id.textView)
    val itemImageView: ImageView = view.findViewById(R.id.imageView)

    init {
        // layoutの初期設定するときはここで実装する
    }

}