package es.jujoru.marvelapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import es.jujoru.marvelapi.databinding.ItemCharacterBinding
import es.jujoru.marvelapi.model.Character
import es.jujoru.marvelapi.ui.model.loadImageFromUrl

class CharactersAdapter(val clickListener: CharactersListener): ListAdapter<Character, CharactersAdapter.ViewHolder>(CharactersDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root){


        fun bind(item: Character, clickListener: CharactersListener) {

            binding.character = item
            binding.itemIvHeader.loadImageFromUrl(item.thumbnail.path,item.thumbnail.extension)
            binding.clickListener = clickListener
            binding.executePendingBindings()


        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCharacterBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class CharactersDiffCallback : DiffUtil.ItemCallback<Character>() {

    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }


}

class CharactersListener(val clickListener: (item: Character) -> Unit) {
    fun onClick(item: Character) = clickListener(item)
}