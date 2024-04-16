package surf.project.surftask02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import surf.project.surftask02.databinding.LaunchListItemBinding

class LaunchAdapter : ListAdapter<Launch, LaunchAdapter.ItemHolder>(ItemComparator()) {
    class ItemHolder(private val binding: LaunchListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(launch: Launch) = with(binding) {
            idImage.setImageResource(launch.idImage)
            name.text = launch.name
            name2.text = launch.name2
            date.text = launch.date
        }

        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    LaunchListItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<Launch>() {
        override fun areItemsTheSame(oldItem: Launch, newItem: Launch): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Launch, newItem: Launch): Boolean {
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