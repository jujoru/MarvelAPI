package es.jujoru.marvelapi.ui.model

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

fun ImageView.loadImageFromUrl(path: String,ext: String){
    Log.i("aaa","$path/standard_medium.$ext")
    Glide.with(context).
    load("https://via.placeholder.com/150").
    into(this)

}
inline fun <reified T: Activity> Context.intentFor(body: Intent.()-> Unit): Intent =
    Intent(this, T::class.java).apply(body)

inline fun <reified T: Activity> Context.startActivity(body: Intent.()-> Unit){
    startActivity(intentFor<T>(body))
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> FragmentActivity.getViewModel(crossinline factory: () -> T): T {

    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }

    return ViewModelProvider(this, vmFactory).get()
}
