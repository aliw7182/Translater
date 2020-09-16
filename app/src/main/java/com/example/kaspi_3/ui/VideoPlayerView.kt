package com.example.kaspi_3.ui

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.SeekBar
import androidx.core.view.isVisible
import com.example.kaspi_3.R
import kotlinx.android.synthetic.main.view_video.view.*

class VideoPlayerView
@JvmOverloads constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {

    private var isSeekBarVisible = false
    private lateinit var runnable: Runnable
    private val handlerView: Handler? = null

    init {
        inflate(context, R.layout.view_video, this)
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.VideoPlayerView,
                defStyleAttr,
                0
            )
            isSeekBarVisible = typedArray.getBoolean(
                R.styleable.VideoPlayerView_isSeekBarVisible,
                isSeekBarVisible
            )
            seekBar.isVisible = isSeekBarVisible
            typedArray.recycle()
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                videoView.seekTo(seekBar?.progress ?: 0)
                videoView.start()
            }
        })
    }

    fun play(url: String) {
        videoView.setVideoPath(url)
        videoView.setOnErrorListener { mediaPlayer, i, i2 ->
            mediaPlayer
            false
        }
        videoView.start()
        videoView.setOnPreparedListener {
            seekBar.max = it.duration
            listenPlayerTrack()
        }
    }

    private fun listenPlayerTrack(){
        runnable = Runnable {
            seekBar.progress = videoView.currentPosition
            handlerView?.postDelayed(runnable, 100)
        }
        handlerView?.postDelayed(runnable, 100)
    }

    private fun destroy(){
        handlerView?.removeCallbacks(runnable)
    }
}