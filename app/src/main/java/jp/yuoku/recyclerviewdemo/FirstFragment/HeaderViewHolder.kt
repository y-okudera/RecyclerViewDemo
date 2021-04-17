package jp.yuoku.recyclerviewdemo.FirstFragment

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.yuoku.recyclerviewdemo.R

class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val headerTextView: TextView = view.findViewById(R.id.headerTextView)

    init {
        // layoutの初期設定するときはここで実装する
    }

}