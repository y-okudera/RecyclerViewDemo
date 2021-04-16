package jp.yuoku.recyclerviewdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.yuoku.recyclerviewdemo.FirstFragment.RecyclerViewHolder

class RecyclerAdapter(private val context: Context, private val itemClickListener: RecyclerViewHolder.ItemClickListener, private val itemList:List<String>) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var recyclerView : RecyclerView? = null

    // RecyclerViewがこのAdapterの監視を開始したときにコールされる
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    // RecyclerViewがこのAdapterの監視を停止したときにコールされる
    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        this.recyclerView = null

    }

    // 指定された位置にデータを表示するためにRecyclerViewによってコールされる。
    // このメソッドはRecyclerView.ViewHolder.itemViewのレイアウトに値を反映させる。
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.let {
            it.itemTextView.text = itemList[position]
            it.itemImageView.setImageResource(R.mipmap.ic_launcher)
        }
    }

    // データの件数
    override fun getItemCount(): Int {
        return itemList.size
    }

    // 使用するViewHolderを返す
    // 複数の種類のセルを使用する場合は、getItemViewType(position: Int): IntでpositionごとにVIEWTYPE（int）を決めて
    // それでswitchして、返却するViewHolderを決めれば良い
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val layoutInflater = LayoutInflater.from(context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)

        listItem.setOnClickListener { view ->
            recyclerView?.let {
                itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }

        return RecyclerViewHolder(listItem)
    }
}