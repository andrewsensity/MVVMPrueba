package com.santy.mvvmprueba.View.Fragments

import android.app.AlertDialog
import android.content.Context
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

class MailFragment : Fragment(), RecyclerViewAdapter.ClickListener {

    private lateinit var adapter: RecyclerViewAdapter
    private val listData: ArrayList<MailModel> = ArrayList()
    private lateinit var contex: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mail, container, false)
        initRecyclerView(view)
        buildDisplayData()
        return view
    }

    private fun initRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        adapter = RecyclerViewAdapter(listData, this)
        recyclerView.layoutManager = LinearLayoutManager(activity)
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
        listData.add(MailModel("Ministerio TIC", "helloooo", R.drawable.star_favorite, R.drawable.england, R.drawable.star_favorite))
        listData.add(MailModel("Maria Juliana Rincón", "helloooo", R.drawable.star_favorite, R.drawable.france, R.drawable.star_favorite))
        listData.add(MailModel("Recordatorio de contraseña", "helloooo", R.drawable.star_favorite, R.drawable.france, R.drawable.star_favorite))
        listData.add(MailModel("Meetup", "helloooo", R.drawable.star_favorite, R.drawable.greece, R.drawable.star_favorite))
        listData.add(MailModel("Extracto Tarjeta", "helloooo", R.drawable.star_favorite, R.drawable.italy, R.drawable.star_favorite))
        listData.add(MailModel("Talent", "helloooo", R.drawable.star_favorite, R.drawable.netherlands, R.drawable.star_favorite))
        listData.add(MailModel("IoT medellín", "helloooo", R.drawable.star_favorite, R.drawable.portugal, R.drawable.star_favorite))
        listData.add(MailModel("Territorium", "helloooo", R.drawable.star_favorite, R.drawable.russia, R.drawable.star_favorite))
        listData.add(MailModel("Territorium", "helloooo", R.drawable.star_favorite, R.drawable.sweden, R.drawable.star_favorite))
    }


    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        @JvmStatic
        fun newInstance(sectionNumber: Int): MailFragment {
            return MailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onItemClickListener(mailModel: MailModel) {
        val fragment: Fragment = SwipeFragment.newInstance(mailModel.message!!)
        val transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.hide(activity?.supportFragmentManager!!.findFragmentByTag("message_fragment")!!)
        transaction.add(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}


/*private fun getData(){
    //listImages.addAll(MailProvider.random())
    val message = listOf(
        MailModel(
            message = "It’s not a bug. It’s an undocumented feature!",
            title = "Anonymous",
            star = 1,
            flags = 1,
            circle = 1
        ),
        MailModel(
            message = "“Software Developer” – An organism that turns caffeine into software",
            title = "Anonymous",
            star = 1,
            flags = 1,
            circle = 1

        ),
        MailModel(
            message = "If debugging is the process of removing software bugs, then programming must be the process of putting them in",
            title = "Edsger Dijkstra",
            star = 1,
            flags = 1,
            circle = 1
        ),
        MailModel(
            message = "A user interface is like a joke. If you have to explain it, it’s not that good.",
            title = "Anonymous",
            star = 1,
            flags = 1,
            circle = 1
        ),
        MailModel(
            message = "I don’t care if it works on your machine! We are not shipping your machine!",
            title = "Vidiu Platon",
            star = 1,
            flags = 1,
            circle = 1
        ),
        MailModel(
            message = "Measuring programming progress by lines of code is like measuring aircraft building progress by weight.",
            title = "Bill Gates",
            star = 1,
            flags = 1,
            circle = 1
        ),
        MailModel(
            message = "My code DOESN’T work, I have no idea why. My code WORKS, I have no idea why.",
            title = "Anonymous",
            star = 1,
            flags = 1,
            circle = 1
        ),
        MailModel(
            message = "Things aren’t always #000000 and #FFFFFF",
            title = "Anonymous",
            star = 1,
            flags = 1,
            circle = 1),
        MailModel(
            message = "Talk is cheap. Show me the code.",
            title = "Linus Torvalds",
            star = 1,
            flags = 1,
            circle = 1),
        MailModel(
            message = "Software and cathedrals are much the same — first we build them, then we pray.",
            title = "Anonymous",
            star = 1,
            flags = 1,
            circle = 1
        ),
        MailModel(
            message = "¿A que esperas?, suscríbete.",
            title = "AristiDevs",
            star = 1,
            flags = 1,
            circle = 1)
    )

}*/

//Optional
/*   private fun getRetrofit(): Retrofit {
       return Retrofit.Builder()
           //.baseUrl("")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
   }*/
/*
    private fun courutine(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getMessages()
            val list = call.body()

            val message = list?.message
            listImages[1]
            adapter.notifyDataSetChanged()
        }
    }*/