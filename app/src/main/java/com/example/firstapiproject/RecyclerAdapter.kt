    package com.example.firstapiproject



    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.ViewGroup
    import androidx.navigation.findNavController
    import androidx.recyclerview.widget.RecyclerView
    import com.example.firstapiproject.databinding.ItemLayoutBinding


    class RecyclerAdapter(private var playersListener: (Player) -> Unit) : RecyclerView.Adapter<RecyclerAdapter.PlayerViewHolder>() {

        inner class PlayerViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)
        var players: List<Player> = emptyList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
            val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PlayerViewHolder(binding)


        }


        override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
            val player = players[position]

            holder.binding.firstName.text = player.first_name
            holder.binding.lastName.text = player.last_name


            val weight = player.weight_pounds?.toString() ?: "-"
            val jerseyNumber = player.jersey_number ?: "-"
            val college = player.college ?: "-"
            val country = player.country ?: "-"
            val draftYear = player.draft_year ?: "-"
            val draftRound = player.draft_round ?: "-"
            val draftNumber = player.draft_number ?: "-"

            holder.itemView.setOnClickListener {
                val bundle = Bundle().apply {
                    putString("first_name", player.first_name)
                    putString("last_name", player.last_name)
                    putString("position", player.position)
                    putString("weight", weight)
                    putString("jersey_number", jerseyNumber)
                    putString("college", college)
                    putString("country", country)
                    putString("draft_year", draftYear.toString())
                    putString("draft_round", draftRound.toString())
                    putString("draft_number", draftNumber.toString())
                }

              playersListener(players[position])
            }
        }

        override fun getItemCount() = players.size
    }