package com.finalproject.tiketku.adapter

import android.content.Context
import android.content.SharedPreferences
import android.icu.text.SimpleDateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.finalproject.tiketku.R
import com.finalproject.tiketku.databinding.ItemHariBinding
import com.finalproject.tiketku.databinding.ItemNotifBinding
import com.finalproject.tiketku.model.ListHasilPencarian
import com.finalproject.tiketku.model.notif.DataNotif
import com.finalproject.tiketku.model.onetrip.DataOneTrip
import com.finalproject.tiketku.model.roundtrip.DataRoundTrip
import com.finalproject.tiketku.model.rountrip.DataRountip
import java.util.Locale

class JadwalTanggalAdapter (private val context: Context, private val list: List<DataOneTrip>) : RecyclerView.Adapter<JadwalTanggalAdapter.ViewHolder>() {
        private var selectedCard = -1

        private var onItemClickCallback: OnItemClickCallback? = null

        fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var hari = itemView.findViewById<TextView>(R.id.tv_hari)
            var tgl = itemView.findViewById<TextView>(R.id.tv_tgl)
            val lin1 = itemView.findViewById<View>(R.id.layout_hari)

            init {
                lin1.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        selectedCard = position
                        notifyDataSetChanged()

                        /*                    onItemClickCallback?.onItemClicked(position, listClass[position])*/
                    }
                }
            }
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalTanggalAdapter.ViewHolder {
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.item_hari, parent, false)
            return ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: JadwalTanggalAdapter.ViewHolder, position: Int) {
            val currentItem = list[position]
            holder.hari.text = currentItem.hari
            holder.tgl.text = currentItem.tanggalBerangkat

            if (position == selectedCard) {
                holder.lin1.setBackgroundResource(R.drawable.curved_set_class)
                holder.hari.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.white
                    )
                )
                holder.tgl.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.white
                    )
                )
            } else {
                holder.lin1.setBackgroundResource(R.drawable.curve_set_class)
                holder.hari.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.black
                    )
                )
                holder.tgl.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.black
                    )
                )
            }

        }

        override fun getItemCount(): Int = list.size


        interface OnItemClickCallback {
            fun onItemClicked(position: Int, data: ListHasilPencarian)
        }
    }
