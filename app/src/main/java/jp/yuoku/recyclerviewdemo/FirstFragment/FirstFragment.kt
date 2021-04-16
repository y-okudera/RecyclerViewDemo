package jp.yuoku.recyclerviewdemo.FirstFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.yuoku.recyclerviewdemo.R
import jp.yuoku.recyclerviewdemo.RecyclerAdapter

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FirstFragment : Fragment(), RecyclerViewHolder.ItemClickListener {

    private val strings = listOf(
        "Alice", "Bob", "Charlie",
        "Dave", "Eve", "Frank",
        "Grace", "Heidi", "Ivan",
        "Judy", "Kevin", "Larry",
        "Michael", "Nicholas", "Oscar",
        "Peter", "Quincy", "Robert",
        "Steve"
    )

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        // adapterとlayoutManagerを設定
        recyclerView.adapter = RecyclerAdapter(view.context, this, strings)
        recyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
    }

    override fun onItemClick(view: View, position: Int) {
        Log.d("D-LOG", "position: ${position}")
    }
}
