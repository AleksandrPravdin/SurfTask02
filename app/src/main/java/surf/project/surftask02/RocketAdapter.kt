package surf.project.surftask02

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.R
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import surf.project.surftask02.databinding.LaunchListItemBinding
import surf.project.surftask02.databinding.RocketListItemBinding

class RocketAdapter : ListAdapter<Rocket, RocketAdapter.ItemHolder>(ItemComparator()) {
    class ItemHolder(private val binding: RocketListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(rocket: Rocket) = with(binding) {
            idImage.setImageResource(rocket.idImage)
            name.text = rocket.name
            name2.text = rocket.name2
            if(name2.text=="ACTIVE"){
                name2CV.setCardBackgroundColor(
                    Color.GREEN
                )

            }
        }

        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    RocketListItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<Rocket>() {
        override fun areItemsTheSame(oldItem: Rocket, newItem: Rocket): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Rocket, newItem: Rocket): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }
}