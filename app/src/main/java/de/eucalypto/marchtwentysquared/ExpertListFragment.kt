package de.eucalypto.marchtwentysquared

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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

        button_go_from_expert_list_to_count.setOnClickListener {
            findNavController().navigate(R.id.action_expertListFragment_to_countFragment)
        }

        expert_list_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
            val dummyExpertList = mutableListOf(
                Expert("John", "Doe", "john.doe@test.com", "123"),
                Expert("Boaty", "McBoatface", "mcboatface@est.com", "124")
            )
            for (i in 1..100) {
                dummyExpertList.add(
                    Expert(
                        "Boaty$i",
                        "McBoatface$i",
                        "mcboatface$i@test.com",
                        "12$i"
                    )
                )
            }
            adapter = ExpertAdapter(dummyExpertList)
        }

    }

}
