package jp.yuoku.recyclerviewdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.yuoku.recyclerviewdemo.FirstFragment.HeaderViewHolder
import jp.yuoku.recyclerviewdemo.FirstFragment.RecyclerViewHolder

class RecyclerAdapter(private val context: Context, private val itemClickListener: RecyclerViewHolder.ItemClickListener, private val itemList:List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var recyclerView: RecyclerView? = null

    enum class ViewTypes(val id: Int) {
        HEADER(0),
        CELL(1)
    }

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
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (position) {
            0 -> {
                holder.let {
                    it as HeaderViewHolder
                    it.headerTextView.text = itemList[position]
                }
            }
            else -> {
                holder.let {
                    it as RecyclerViewHolder
                    it.itemTextView.text = itemList[position]
                    it.itemImageView.setImageResource(R.mipmap.ic_launcher)
                }
            }
        }
    }

    // データの件数
    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ViewTypes.HEADER.id
            else -> ViewTypes.CELL.id
        }
    }

    // 使用するViewHolderを返す
    // 複数の種類のセルを使用する場合は、getItemViewType(position: Int): IntでpositionごとにVIEWTYPE（int）を決めて
    // それでswitchして、返却するViewHolderを決めれば良い
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(context)

        when (viewType) {
            ViewTypes.HEADER.id -> {
                val listHeaderItem = layoutInflater.inflate(R.layout.list_header_item, parent, false)

                listHeaderItem.setOnClickListener { view ->
                    recyclerView?.let {
                        itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
                    }
                }

                return HeaderViewHolder(listHeaderItem)
            }
            ViewTypes.CELL.id -> {
                val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
                listItem.setOnClickListener { view ->
                    recyclerView?.let {
                        itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
                    }
                }
                return RecyclerViewHolder(listItem)
            }
            else -> {
                // 例外のタイプは、とりあえずCELL Typeとして扱う
                
                val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
                listItem.setOnClickListener { view ->
                    recyclerView?.let {
                        itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
                    }
                }
                return RecyclerViewHolder(listItem)
            }
        }
    }
}