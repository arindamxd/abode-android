package com.arindam.abode.utils.widgets

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.arindam.abode.R

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

class CustomFontTextView : TextView {

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        attrs?.run {
            val a = context.obtainStyledAttributes(this, R.styleable.CustomFontTextView)
            val fontName = a.getString(R.styleable.CustomFontTextView_custom_font)

            try {
                if (fontName != null) {
                    val myTypeface = Typeface.createFromAsset(context.assets, "fonts/$fontName")
                    typeface = myTypeface
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            a.recycle()
        }
    }
}
