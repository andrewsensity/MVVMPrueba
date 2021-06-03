package com.santy.mvvmprueba.View.Fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santy.mvvmprueba.Model.MailModel
import com.santy.mvvmprueba.R
import com.santy.mvvmprueba.ViewModel.RecyclerView.RecyclerViewAdapter
import com.santy.mvvmprueba.ViewModel.RecyclerView.RecyclerViewAdapterF

class FavouriteFragment : Fragment() {

    private lateinit var adapter: RecyclerViewAdapterF
    val listData: ArrayList<MailModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favourite, container, false)
        buildDisplayData()
        initRecyclerView(view)
        return view
    }

    //desde aqui borrar
    private fun initRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewFavourites)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = RecyclerViewAdapterF(listData, this)
        recyclerView.adapter = adapter

        //Swipe
        val itemSwipe = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                showDialog(viewHolder)
            }
        }

        val swap = ItemTouchHelper(itemSwipe)
        swap.attachToRecyclerView(recyclerView)
    }

    private fun showDialog(viewHolder: RecyclerView.ViewHolder){
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Delete Item")
        builder.setMessage("Are you sure want to delete item.")
        builder.setPositiveButton("Confirm"){dialog, which ->
            val position = viewHolder.adapterPosition
            listData.removeAt(position)
            adapter.notifyItemRemoved(position)
        }
        builder.setNegativeButton("Cancel"){dialog, which ->
            val position = viewHolder.adapterPosition
            adapter.notifyItemChanged(position)
        }
        builder.show()
    }
    //hasta aqui

    private fun buildDisplayData(){
        listData.add(MailModel("Jorge Rausch", "Oye ¿Qué significa la cocina para ti?\n" +
                "Durante este año he recibido miles de comentarios de personas que la cocina se les ha " +
                "convertido en un completo dolor de cabeza ya que nuestra rutina cambió completamente. " +
                "Eres tú de los que: ¿Te estresas por la cocina? ¿Te quita mucho tiempo? ¿Cocinas simplemente " +
                "porque tienes que comer o alimentar a tu familia? ¿Estás en modo automático cocinando todas " +
                "las semanas lo mismo?", R.drawable.star_favorite, R.drawable.colombia, R.drawable.star_favorite))
        listData.add(MailModel("Beatriz Araque", "Comienza el mes con mucha diversión al aire libre en el Parque Arví\n +" +
                "¡Hola Carlos! \n" +
                "Muchos encuentran en la naturaleza un escape a la rutina, salir de la monotonía y disfrutar " +
                "de espacios diferentes, por eso hemos preparado  una agenda llena de actividades y diversión " +
                "al aire libre para que vivas los mejores momentos en el bosque en compañía de tus seres queridos" +
                ". ", R.drawable.star_favorite, R.drawable.china, R.drawable.star_favorite))
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        @JvmStatic
        fun newInstance(sectionNumber: Int): FavouriteFragment {
            return FavouriteFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    fun onItemClickListener(dataModel: MailModel) {
        val fragment: Fragment = SwipeFragment.newInstance(dataModel.message!!)
        val transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.hide(activity?.supportFragmentManager!!.findFragmentByTag("message_fragment")!!)
        transaction.add(R.id.frame_container2, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}