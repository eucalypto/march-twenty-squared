package de.eucalypto.marchtwentysquared.ui.experts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import de.eucalypto.marchtwentysquared.R
import de.eucalypto.marchtwentysquared.model.Expert
import kotlinx.android.synthetic.main.fragment_expert_list.*


class ExpertListFragment : Fragment() {

    private val expertListRef = Firebase.firestore.collection("experts").orderBy("lastName")
    private lateinit var expertListListenerRegistration: ListenerRegistration

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expert_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val expertList: MutableList<Expert> = mutableListOf()
        setupExpertListListener(expertList)

        expert_list_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ExpertAdapter(expertList)

            // Adds a line separator between items in RecyclerView
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    (layoutManager as LinearLayoutManager).orientation
                )
            )
        }

    }

    private fun setupExpertListListener(expertList: MutableList<Expert>) {
        expertListListenerRegistration =
            expertListRef.addSnapshotListener { expertListSnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    Log.w(tag, "listen:error", firebaseFirestoreException)
                    return@addSnapshotListener
                }
                expertList.clear()
                expertListSnapshot?.documents?.forEach { expertSnapshot ->
                    val expert = expertSnapshot.toObject(Expert::class.java) ?: return@forEach
                    expertList.add(expert)
                }
                expert_list_recycler_view.adapter?.notifyDataSetChanged()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        expertListListenerRegistration.remove()
    }

}
