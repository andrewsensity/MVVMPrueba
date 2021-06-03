package com.santy.mvvmprueba.View.ViewPager

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.santy.mvvmprueba.R
import com.santy.mvvmprueba.View.Fragments.FavouriteFragment
import com.santy.mvvmprueba.View.Fragments.MailFragment

private val TAB_TITLES = arrayOf(
    R.string.messages,
    R.string.favourites
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val fragment:ArrayList<Fragment> = ArrayList()

        if(position == 1){
            return FavouriteFragment.newInstance(position + 1)
        }else{
            return MailFragment.newInstance(position + 1)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}