package de.eucalypto.marchtwentysquared

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_count.*

/**
 * A simple [Fragment] subclass.
 */
class CountFragment : Fragment() {

    var counter = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_count, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        counterView.text = counter.toString()

        incrementButton.setOnClickListener {
            counter += 1
            counterView.text = counter.toString()
        }

        resetButton.setOnClickListener {
            counter = 0
            counterView.text = counter.toString()
        }

        button_go_from_count_to_list.setOnClickListener {
            findNavController().navigate(R.id.action_countFragment_to_listFragment)
        }

    }

}
