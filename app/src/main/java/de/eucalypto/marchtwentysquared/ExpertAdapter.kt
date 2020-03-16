package de.eucalypto.marchtwentysquared

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_expert.view.*

class ExpertAdapter(private val expertList: MutableList<Expert>) :
    RecyclerView.Adapter<ExpertAdapter.ViewHolder>() {

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(expert: Expert) {
            view.apply {
                expertFirstNameTextView.text = expert.firstName
                expertLastNameTextView.text = expert.lastName
                expertEmailTextView.text = expert.email
                expertPhoneTextView.text = expert.phone
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expert, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = expertList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(expertList[position])
    }

}
