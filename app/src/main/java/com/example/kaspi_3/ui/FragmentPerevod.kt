package com.example.kaspi_3.ui

import android.graphics.Rect
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kaspi_3.R
import com.example.kaspi_3.model.LeftMessages
import com.example.kaspi_3.model.Messages
import com.example.kaspi_3.model.RightMessage
import com.example.kaspi_3.sharedPreferences.SharedPrefencesHelper
import kotlinx.android.synthetic.main.fr_perevod.*

private const val PADDING_IN_DIPS = 8F
class FragmentPerevod : Fragment(R.layout.fr_perevod) {
    companion object {
        var messageList: MutableList<Messages> = mutableListOf<Messages>()

    }

    lateinit var pref: SharedPrefencesHelper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = SharedPrefencesHelper(activity?.baseContext)
        setupMessages()
        otpravkaBtn.setOnClickListener(mOnClickPerevodListener)
        downBtn.setOnClickListener(scrollDown)
        messageListView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) || recyclerView.scrollState == ((recyclerView.adapter?.itemCount ?:0)-1))  {
                    downBtn.visibility = View.GONE
                }
                else{
                    downBtn.visibility = View.VISIBLE
                }
            }
        })
        messageListView.addItemDecoration(object :RecyclerView.ItemDecoration(){
           val metrics:DisplayMetrics = activity?.getResources()?.getDisplayMetrics() ?: DisplayMetrics()
           val mPadding =  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, PADDING_IN_DIPS, metrics)
            val mPaddingBottom =  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10F, metrics)

            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
               outRect.left = mPadding.toInt()
               outRect.right = mPadding.toInt()
                outRect.bottom = mPaddingBottom.toInt()
            }
            })



    }
    private fun setupMessages() {
        pref.getMessage().forEach{
            messageList.addAll( it.toList().toMutableList())
        }
        val  messageAdapter = MessageAdapter(

        )
        var messageManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        messageManager.stackFromEnd = true  

        messageListView.apply {
            adapter = messageAdapter
            layoutManager = messageManager
        }

        messageAdapter.setItems(messageList)
    }
    private val mOnClickPerevodListener = View.OnClickListener {
        val input:String = inputText.text.toString()
        val MessagesPair:Pair<RightMessage,LeftMessages> = RightMessage(input) to LeftMessages(perevod(input))
        pref.addMessage(MessagesPair)
        setupMessages()




    }
    private fun perevod(str:String):String{
        var str = str.toMutableList()
        var outputtext:String = ""
        for(i in 0 until str.size){
            if(str[i] == 'а' || str[i] == 'А'){
                str[i] = 'a'
            }
            else if(str[i] == 'а' || str[i] == 'А'){
                str[i] = 'a'
            }
            else if(str[i] == 'б' || str[i] == 'Б'){
                str[i] = 'b'
            }
            else if(str[i] == 'в' || str[i] == 'В'){
                str[i] = 'v'
            }else if(str[i] == 'г' || str[i] == 'Г'){
                str[i] = 'g'
            }
            else if(str[i] == 'ғ' || str[i] == 'Ғ'){
                str[i] = 'ǵ'
            }
            else if(str[i] == 'д' || str[i] == 'Д'){
                str[i] = 'd'
            }
            else if(str[i] == 'е' || str[i] == 'Е'){
                str[i] = 'e'
            }
            else if(str[i] == 'ж' || str[i] == 'Ж'){
                str[i] = 'j'
            }
            else if(str[i] == 'з' || str[i] == 'З'){
                str[i] = 'z'
            }
            else if(str[i] == 'и' || str[i] == 'И'){
                str[i] = 'ı'
            }
            else if(str[i] == 'й' || str[i] == 'Й'){
                str[i] = 'i'
            }
            else if(str[i] == 'к' || str[i] == 'К'){
                str[i] = 'k'
            }
            else if(str[i] == 'қ' || str[i] == 'Қ'){
                str[i] = 'q'
            }
            else if(str[i] == 'л' || str[i] == 'Л'){
                str[i] = 'l'
            }
            else if(str[i] == 'м' || str[i] == 'М'){
                str[i] = 'm'
            }
            else if(str[i] == 'н' || str[i] == 'Н'){
                str[i] = 'n'
            }
            else if(str[i] == 'ң' || str[i] == 'Ң'){
                str[i] = 'ń'
            }
            else if(str[i] == 'о' || str[i] == 'О'){
                str[i] = 'o'
            }

            else if(str[i] == 'ө' || str[i] == 'Ө'){
                str[i] = 'ó'
            }

            else if(str[i] == 'п' || str[i] == 'П'){
                str[i] = 'p'
            }
            else if(str[i] == 'р' || str[i] == 'Р'){
                str[i] = 'r'
            }
            else if(str[i] == 'с' || str[i] == 'С'){
                str[i] = 's'
            }

            else if(str[i] == 'т' || str[i] == 'Т'){
                str[i] = 't'
            }

            else if(str[i] == 'у' || str[i] == 'У'){
                str[i] = 'ý'
            }
            else if(str[i] == 'ұ' || str[i] == 'Ұ'){
                str[i] = 'u'
            }
            else if(str[i] == 'ү' || str[i] == 'Ү'){
                str[i] = 'ú'
            }

            else if(str[i] == 'ф' || str[i] == 'Ф'){
                str[i] = 'f'
            }
            else if(str[i] == 'х' || str[i] == 'Х'){
                str[i] = 'h'
            }
            else if(str[i] == 'ц' || str[i] == 'Ц'){
                str[i] = 'c'
            }
            else if(str[i] ==   'ч' || str[i] == 'Ч'){
                str[i] = 'c'
            }

            else if(str[i] == 'ы' || str[i] == 'Ы'){
                str[i] = 'y'
            }

            else if(str[i] == 'і' || str[i] == 'І'){
                str[i] = 'i'
            }
            outputtext+=str[i]

        }
        return outputtext

    }
    private val scrollDown = View.OnClickListener {
        messageListView.layoutManager?.scrollToPosition((messageListView.adapter?.itemCount ?: 0)-1)
        downBtn.visibility = View.GONE
    }



    }

