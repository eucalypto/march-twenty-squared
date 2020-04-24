package de.eucalypto.marchtwentysquared.ui.experts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import de.eucalypto.marchtwentysquared.R
import de.eucalypto.marchtwentysquared.model.Expert
import kotlinx.android.synthetic.main.fragment_expert_list.*

/**
 * A simple [Fragment] subclass.
 */
class ExpertListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expert_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        expert_list_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
            val dummyExpertList = getDummyExpertList()
            adapter =
                ExpertAdapter(
                    dummyExpertList
                )

            // Adds a line separator between items in RecyclerView
            addItemDecoration(
                DividerItemDecoration(
                    expert_list_recycler_view.context,
                    (layoutManager as LinearLayoutManager).orientation
                )
            )
        }

    }

    private fun getDummyExpertList(): MutableList<Expert> {
        val dummyExpertList = mutableListOf(
            Expert("John", "Doe", "123"),
            Expert(
                "Boaty",
                "McBoatface",
                "124"
            )
        )

        fun getAvatar(num: Int): Int {
            return when (num.rem(7)) {
                1 -> R.drawable.avatar01
                2 -> R.drawable.avatar02
                3 -> R.drawable.avatar03
                4 -> R.drawable.avatar04
                5 -> R.drawable.avatar05
                6 -> R.drawable.avatar06
                else -> R.drawable.avatar07
            }
        }
        for (i in 1..100) {
            dummyExpertList.add(
                Expert(
                    "Boaty$i",
                    "McBoatface$i",
                    "12$i",
                    getAvatar(i)
                )
            )
        }

        return dummyExpertList
    }

}
