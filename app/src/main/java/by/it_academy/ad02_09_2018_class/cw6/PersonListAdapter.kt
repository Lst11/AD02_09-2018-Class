package by.it_academy.ad02_09_2018_class.cw6

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PersonListAdapter : RecyclerView.Adapter<PersonListAdapter.Holder>() {

    private var listData: List<Person> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): Holder {
        var view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_person, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.e("AAA", "onBindViewHolder")
        val person = listData[position]
        holder.nameTextView.setText(person.name ?: "")
        holder.surnameTextView.setText(person?.surname ?: "")
        holder.vi
    }


    inner class Holder : RecyclerView.ViewHolder {
        var nameTextView: TextView
        var surnameTextView: TextView


        constructor(view: View) : super(view) {
            nameTextView = view.findViewById(R.id.name)
            surnameTextView = view.findViewById(R.id.name)
        }
    }

}