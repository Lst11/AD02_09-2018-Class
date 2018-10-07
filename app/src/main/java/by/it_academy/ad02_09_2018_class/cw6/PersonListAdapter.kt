package by.it_academy.ad02_09_2018_class.cw6

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PersonListAdapter(val onItemClick: (Person) -> Unit) : RecyclerView.Adapter<PersonListAdapter.Holder>() {

    private var listData: List<Person> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

//    var onItemClick: OnItemClick? = null - не нужна, потому что заменили объявление в конструкторе


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
        holder.itemView.setOnClickListener {
            //it - переменная (View), на которую нажали
//            onItemClick?.onItemClick(person) - изменили на строку ниже после объявления
            onItemClick(person)
        }
    }
//    ** при различных дизайнах для items
//    override fun getItemViewType(position" Int): Int{ }

    inner class Holder : RecyclerView.ViewHolder {
        var nameTextView: TextView
        var surnameTextView: TextView


        constructor(view: View) : super(view) {
            nameTextView = view.findViewById(R.id.name)
            surnameTextView = view.findViewById(R.id.name)
        }
    }

    interface OnItemClick {
        fun onItemClick(person: Person)
    }

}