package com.example.myapplication12.adapters

import Definitions
import Meanings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication12.R



class DictAdapter(private val dataSet: List<Meanings>) :
    RecyclerView.Adapter<DictAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val partOfSpeechTV: TextView
        val definitionsLV:ListView

        init {
            // Define click listener for the ViewHolder's View.
            partOfSpeechTV = view.findViewById(R.id.partOfSpeech)
            definitionsLV = view.findViewById(R.id.definitions)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.definition_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.partOfSpeechTV.text = dataSet[position].partOfSpeech

        var listOfDefinitions:ArrayList<String> = ArrayList()
        //loop through the list of definitions and add them to the list of definitions
        var definition:List<Definitions> = dataSet[position].definitions
        for(i in definition){
            var str:String = (definition.indexOf(i)+1).toString()+". "+i.definition
            listOfDefinitions.add(str)
        }


        //set the list of definitions to the list view using array adapter
        viewHolder.definitionsLV.adapter =
            ArrayAdapter(viewHolder.definitionsLV.context, android.R.layout.simple_list_item_1, listOfDefinitions)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
