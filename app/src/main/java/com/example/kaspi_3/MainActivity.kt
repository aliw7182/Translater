package com.example.kaspi_3

import android.content.SharedPreferences
import android.drm.DrmStore
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.kaspi_3.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fr_perevod.*
import kotlinx.android.synthetic.main.toolbar_main.*
import java.lang.reflect.Field

private const val KEY_SAVE = "KEY_SAVE"
class MainActivity : AppCompatActivity() {
    companion object{
        const val PREF_SETTING = "PREF_SETTING"
    }
    lateinit var pref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setCustomView(R.layout.toolbar_main)
        pref = getSharedPreferences(PREF_SETTING, MODE_PRIVATE)
        navbar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navbar.selectedItemId = R.id.perevod
//        PerevodBtn.setOnClickListener(mOnClickPerevodButton)

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item ->
        when(item.itemId){
            R.id.favorite -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container,FragmentFavorite())
                    .commit()
                toolbar_title.setText("Unaǵandar tіzіmі")
                return@OnNavigationItemSelectedListener true

            }
            R.id.group -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, FragmentShape())
                    .commit()
                toolbar_title.setText("Audary")

                return@OnNavigationItemSelectedListener true
            }
            R.id.user ->{
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, FragmentUser())
                    .commit()
                toolbar_title.setText("Jeke paraq")
                return@OnNavigationItemSelectedListener true

            }
            R.id.perevod ->{
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container,FragmentPerevod())
                    .commit()
                toolbar_title.setText("Кириллица - Latynsha")
                return@OnNavigationItemSelectedListener true
            }
            R.id.search ->{
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, FragmentSearch())
                    .commit()
                toolbar_title.setText("Qyzyqty kontent")
                return@OnNavigationItemSelectedListener true
            }

        }
        return@OnNavigationItemSelectedListener false

    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.context_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.copy ->{

                return true
            }
            R.id.share -> {
                return true
            }
            R.id.delete -> {
                return true
            }
            R.id.addFavorite -> {
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        try {
            val field: Field = menu.javaClass.getDeclaredField("mOptionalIconsVisible")
            field.setAccessible(true)
            field.setBoolean(menu, true)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return super.onPrepareOptionsMenu(menu)
    }



    }



