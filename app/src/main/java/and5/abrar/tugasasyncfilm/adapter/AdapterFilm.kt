package and5.abrar.tugasasyncfilm.adapter

import and5.abrar.tugasasyncfilm.R
import and5.abrar.tugasasyncfilm.model.ResponseFilmItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_film.view.*

class AdapterFilm(): RecyclerView.Adapter<AdapterFilm.ViewHolder>() {

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    private var listdatafilm : List<ResponseFilmItem>? = null
    fun setDataFilm(film : List<ResponseFilmItem>){
        this.listdatafilm = film
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewitem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film,parent, false)
        return ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listdatafilm!![position].image)
            .into(holder.itemView.gambarFilm)
        holder.itemView.judulFilm.text = listdatafilm!![position].title
        holder.itemView.tanggalFilm.text = listdatafilm!![position].releaseDate
        holder.itemView.sutradara.text = listdatafilm!![position].director
    }

    override fun getItemCount(): Int {
        if (listdatafilm==null){
            return  0
        }else{
            return  listdatafilm!!.size
        }
    }

}