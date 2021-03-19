package es.jujoru.marvelapi.ui.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import es.jujoru.marvelapi.R
import es.jujoru.marvelapi.model.Thumbnail
import es.jujoru.marvelapi.ui.model.loadImageFromUrl
import es.jujoru.marvelapi.utils.Utils
import java.security.cert.Extension

@BindingAdapter("setImageCharacter")
fun ImageView.setImageCharacter(item: Thumbnail){
    loadImageFromUrl(item.path, item.extension)
}
@BindingAdapter("setDefaultEmpty")
fun TextView.setLocationName(textValue: String){
    if( textValue.isEmpty()){
        text = context.getString(R.string.empty_text, "Description")
    }else{
        text = textValue
    }

}