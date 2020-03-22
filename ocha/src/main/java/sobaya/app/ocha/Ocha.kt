package sobaya.app.ocha

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.SeekBar
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.airbnb.lottie.LottieAnimationView

class Ocha @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.ocha_view, this, true)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.Ocha)
        val max = ta.getInt(R.styleable.Ocha_maxFrame, 100)
        val res = ta.getResourceId(R.styleable.Ocha_rawRes, 0)

        findViewById<LottieAnimationView>(R.id.animationView).apply {
            setAnimation(res)
            setMaxFrame(max)
        }
        findViewById<SeekBar>(R.id.seekBar).apply {
            setMax(max)
        }
    }

    fun setFrame(frame: Int) {
        val seek = findViewById<SeekBar>(R.id.seekBar)
        seek.progress = frame
    }

    fun getFrame(): Int {
        val seek = findViewById<SeekBar>(R.id.seekBar)
        return seek.progress
    }
}

@BindingAdapter("frame")
fun Ocha.setFrame(frame: Int) {
    setFrame(frame)
}

@InverseBindingAdapter(attribute = "frame")
fun Ocha.getFrame() = getFrame()

@BindingAdapter("frameAttrChanged")
fun Ocha.setListener(listener: InverseBindingListener?) {
    findViewById<SeekBar>(R.id.seekBar).setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            findViewById<LottieAnimationView>(R.id.animationView).frame = progress
            listener?.onChange()
        }
        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    })

}
