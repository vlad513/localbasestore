package com.vladv.localbasestore.presentation.dialog.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vladv.domain.model.ModelProbe
import com.vladv.localbasestore.R
import com.vladv.localbasestore.databinding.ItemDialogBinding
import java.util.ArrayList


class AdapterDialog(

) : RecyclerView.Adapter<AdapterDialog.RepozHolder>() {
    private val repozList = ArrayList<ModelProbe?>()

    class RepozHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemDialogBinding.bind(itemView)


        @SuppressLint("SimpleDateFormat", "SetTextI18n")
        fun bind(item: ModelProbe?) = with(binding) {
            tvName.text = item?.name
            tvTitle.text = item?.alias
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepozHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dialog, parent, false)
        return RepozHolder(view)
    }

    override fun onBindViewHolder(holder: RepozHolder, position: Int) {
        holder.bind(repozList[position])
    }

    override fun getItemCount(): Int {
        return repozList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addRepoz(it: List<ModelProbe?>) {
        repozList.clear()
        repozList.addAll(it)
        notifyDataSetChanged()
    }
}