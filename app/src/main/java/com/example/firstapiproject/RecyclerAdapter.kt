    package com.example.firstapiproject


    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.TextView
    import androidx.recyclerview.widget.RecyclerView

    class RecyclerAdapter(
        private var players: List<Player>,
        private val onItemClick: (Player) -> Unit
    ) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val itemFirst: TextView = itemView.findViewById(R.id.first_name)
            val itemLast: TextView = itemView.findViewById(R.id.last_name)

            init {
                itemView.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        onItemClick(players[position])
                    }
                }
            }
        }

        fun updatePlayers(newPlayers: List<Player>) {
            players = newPlayers
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val player = players[position]
            holder.itemFirst.text = player.first_name
            holder.itemLast.text = player.last_name
        }

        override fun getItemCount(): Int = players.size
    }