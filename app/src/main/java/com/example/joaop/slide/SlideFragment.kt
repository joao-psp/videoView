package com.example.joaop.slide

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView

class SlideFragment: Fragment() {

    private var slideTitles: IntArray = intArrayOf(
            R.string.l1,
            R.string.l2,
            R.string.l3,
            R.string.l4)

    private var slideVideos: IntArray = intArrayOf(
            R.raw.teste_1,
            R.raw.teste_2,
            R.raw.teste_3,
            R.raw.teste_4)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.slide_layout, container, false)
        val title = view.findViewById<TextView>(R.id.txt_title)
        val videoView = view.findViewById<VideoView>(R.id.video_view)

        val args = arguments
        val position:Int
        if(args == null){
            position = 0
        }else{
            position = args.getInt("position")
        }

        title.text = context?.resources?.getString(slideTitles[position])

        videoView.setVideoPath("android.resource://" + context?.packageName + "/"+slideVideos[position])
        videoView.setOnCompletionListener{
            videoView.start()
        }
        videoView.start()


        return view
    }

    companion object {

        fun newInstance(position: Int): SlideFragment {

            val args = Bundle()
            args.putInt("position", position)
            val frag = SlideFragment()
            frag.arguments = args
            return frag

        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {

        super.setUserVisibleHint(isVisibleToUser)
        val vid = view?.findViewById<VideoView>(R.id.video_view)
        if (!isVisibleToUser) {
            vid?.pause()
        }else{
            vid?.start()
        }
    }

    fun onPauseFragment(){
        val vid = view?.findViewById<VideoView>(R.id.video_view)
        vid?.resume()
        vid?.start()
    }

    fun onResumeFragment() {
        val vid = view?.findViewById<VideoView>(R.id.video_view)
        vid?.start()
    }

}