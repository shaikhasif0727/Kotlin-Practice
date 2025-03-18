package com.gaming.kotlinpracticeproject

// Existing interface
interface MediaPlayer{
    fun play(audioType:String,fileName:String)
}

// Adapter with different interface
class AdvancedMediaPlayer {
    fun playVlc(fileName: String){
        println("Playing VLC file:$fileName")
    }

    fun playMp4(fileName: String){
        println("Playing Mp4 file:$fileName")
    }
}

class MediaAdapter(private val advancedPlayer: AdvancedMediaPlayer): MediaPlayer{
    override fun play(audioType: String, fileName: String) {
        when(audioType){
            "vlc" -> advancedPlayer.playVlc(fileName)
            "mp4" -> advancedPlayer.playMp4(fileName)
            else -> println("Unsupported audio type")
        }
    }

}

// Usage
fun main(){
    val advancedPlayer = AdvancedMediaPlayer()
    val mediaPlayer = MediaAdapter(advancedPlayer)
    mediaPlayer.play("vlc","movie.vlc")
}