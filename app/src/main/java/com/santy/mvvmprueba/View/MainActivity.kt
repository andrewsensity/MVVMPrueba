package com.santy.mvvmprueba.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.santy.mvvmprueba.APIService
import com.santy.mvvmprueba.R
import com.santy.mvvmprueba.View.Fragments.FavouriteFragment
import com.santy.mvvmprueba.View.Fragments.FavouriteFragment.Companion.newInstance
import com.santy.mvvmprueba.View.Fragments.MailFragment
import com.santy.mvvmprueba.View.ViewPager.SectionsPagerAdapter
import com.santy.mvvmprueba.ViewModel.MailModel
import com.santy.mvvmprueba.databinding.ActivityMainBinding
import com.santy.mvvmprueba.databinding.CardviewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val messageViewModel: MailModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mailFragment = MailFragment.newInstance(1)
        val favouriteFragment = FavouriteFragment.newInstance(2)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, mailFragment, "messages_fragment")
        transaction.commit()

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager? = findViewById(R.id.viewPager)
        viewPager?.adapter = sectionsPagerAdapter
        val tabs: TabLayout? = binding.tabs
        tabs?.setupWithViewPager(viewPager)

        /*messageViewModel.messageModel.observe(this, Observer { currentModel ->
            var binding: CardviewBinding = CardviewBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.tvMessage.text = currentModel.message
            binding.tvTitle.text = currentModel.title
            binding.imgCircleBlue.setImageResource(R.drawable.circle_indicator)
            binding.imgFlags.setImageResource(R.drawable.russia)
            binding.imgCircleBlue.setImageResource(R.drawable.circle_indicator)

            binding.llMessage.setOnClickListener {
                //messageViewModel.randomMessage()
                startActivity(Intent(this, DetailActivity::class.java))
            }
        })*/
    }
}