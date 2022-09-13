package br.com.tiagokontarski.mustachejokes.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import br.com.tiagokontarski.mustachejokes.R


class LoadingButton : FrameLayout {

    private lateinit var button: AppCompatButton
    private lateinit var progressBar: ProgressBar
    private lateinit var text: String

    constructor(context: Context) : super(context) {
        setup(context, null);
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setup(context, attrs);
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setup(context, attrs);
    }

    @SuppressLint("CustomViewStyleable")
    private fun setup(context: Context, attrs: AttributeSet?) {

        val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.button_loading, this, true)

        val typedArray: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.TestButton, 0, 0)
        text = typedArray.getString(R.styleable.TestButton_text).toString()
        typedArray.recycle()

        button = getChildAt(0) as AppCompatButton
        button.setText(text)
        button.isEnabled = true

        progressBar = getChildAt(1) as ProgressBar
        progressBar.indeterminateDrawable.setColorFilter(
            ContextCompat.getColor(
                context,
                R.color.white
            ), PorterDuff.Mode.SRC_IN
        )
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        button.isEnabled = enabled
    }

    fun showProgress(enabled: Boolean) {
        progressBar.visibility = if (enabled) VISIBLE else GONE
        button.text = if (enabled) "" else text
    }
}