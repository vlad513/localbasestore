package com.vladv.localbasestore.presentation.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vladv.domain.model.ModelRecord
import com.vladv.localbasestore.R
import com.vladv.localbasestore.databinding.ItemBinding

import java.util.ArrayList


class AdapterMain(
) : RecyclerView.Adapter<AdapterMain.RepozHolder>() {
    private val repozList = ArrayList<ModelRecord?>()

    class RepozHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemBinding.bind(itemView)


        @SuppressLint("SimpleDateFormat", "SetTextI18n")
        fun bind(item: ModelRecord?) = with(binding) {
            tvNumberRecord.text ="numberRecord: " +  item?.numberRecord.toString()
            tvValue.text ="value: " +  item?.value.toString()
            tvTimeStamp.text = "timestamp: "+ item?.timestamp.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepozHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return RepozHolder(view)
    }

    override fun onBindViewHolder(holder: RepozHolder, position: Int) {
        holder.bind(repozList[position])
    }

    override fun getItemCount(): Int {
        return repozList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addRepoz(it: List<ModelRecord?>) {
        repozList.clear()
        repozList.addAll(it)
        notifyDataSetChanged()
    }
}