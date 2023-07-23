package com.dkgtech.dmovie.adapter

import android.content.Context
import android.net.Uri
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dkgtech.dmovie.databinding.WhatsStreamIndiaRowBinding
import com.dkgtech.dmovie.model.DataModel
import com.dkgtech.dmovie.model.TitleModel

class RecyclerWhatsStreamIndiaAdapter(val context: Context, val listData: List<TitleModel>) :
    RecyclerView.Adapter<RecyclerWhatsStreamIndiaAdapter.ViewHolder>() {
    class ViewHolder(val binding: WhatsStreamIndiaRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            WhatsStreamIndiaRowBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            Glide.with(context).load(Uri.parse(listData[position].primaryImage.imageUrl))
                .into(imgPoster)
            txtTitle.text = listData[position].titleText.text
        }
    }
}