package yodgorbekkomilov.edgar.footballapp.adapter


import android.os.Build

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import yodgorbekkomilov.edgar.footballapp.FootballResponse
import yodgorbekkomilov.edgar.footballapp.R
import yodgorbekkomilov.edgar.footballapp.databinding.FootballItemBinding
import yodgorbekkomilov.edgar.footballapp.ui.FootballViewModel


class FootballAdapter :
    RecyclerView.Adapter<FootballAdapter.ViewHolder>() {

   private lateinit var footballList: List<FootballResponse>

    fun updatePostList(footballList: List<FootballResponse>) {
        this.footballList = footballList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FootballAdapter.ViewHolder {
        val binding: FootballItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.football_item,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return footballList.size
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: FootballAdapter.ViewHolder, position: Int) {
        holder.bind(footballList[position])


    }


    class ViewHolder(private val binding: FootballItemBinding) : RecyclerView.ViewHolder(binding.root) {


        private val viewModel = FootballViewModel()

        fun bind(model: FootballResponse) {

            viewModel.bind(model)
            binding.viewModel = viewModel





        }

    }
}




