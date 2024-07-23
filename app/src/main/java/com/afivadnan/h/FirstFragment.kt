package com.afivadnan.h
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    private lateinit var textViewOnPauseCount: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        textViewOnPauseCount = view.findViewById(R.id.textViewOnPauseCount)
        return view
    }

    fun updateOnPauseCount(count: Int) {
        if (this::textViewOnPauseCount.isInitialized) {
            textViewOnPauseCount.text = " $count"
        }
    }


}
