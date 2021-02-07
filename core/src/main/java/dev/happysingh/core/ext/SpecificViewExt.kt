package dev.happysingh.core.ext

import android.graphics.Paint
import android.text.method.ReplacementTransformationMethod
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ScrollView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

fun AppCompatTextView.underLine() {
    paint.flags = paint.flags or Paint.UNDERLINE_TEXT_FLAG
    paint.isAntiAlias = true
}

fun AppCompatTextView.deleteLine() {
    paint.flags = paint.flags or Paint.STRIKE_THRU_TEXT_FLAG
    paint.isAntiAlias = true
}

fun AppCompatTextView.bold(isBold: Boolean = true) {
    paint.isFakeBoldText = isBold
    paint.isAntiAlias = true
}

var AppCompatEditText.value: String
    get() = text.toString()
    set(value) = setText(value)

fun AppCompatEditText.uppercase() {
    transformationMethod = object : ReplacementTransformationMethod() {
        private val lower = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        private val upper = charArrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

        override fun getOriginal() = lower

        override fun getReplacement() = upper
    }
}

fun AppCompatEditText.lowercase() {
    transformationMethod = object : ReplacementTransformationMethod() {
        private val lower = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        private val upper = charArrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

        override fun getOriginal() = upper

        override fun getReplacement() = lower
    }
}

var RadioGroup.checkedIndex: Int
    get() = (0 until childCount).firstOrNull { (getChildAt(it) as RadioButton).isChecked } ?: -1
    set(value) {
        if (value !in 0 until childCount) {
            children.map { it as RadioButton }.filter { it.isChecked }
                .forEach { it.isChecked = false }
        } else {
            (getChildAt(value) as RadioButton).isChecked = true
        }
    }

private const val HALF_ALPHA = 0.5f
private const val NO_ALPHA = 1f
fun AppCompatButton.disableAlpha() {
    this.isClickable = false
    this.isEnabled = false
    this.alpha = HALF_ALPHA
}

fun AppCompatButton.enableWithDefaultAlpha() {
    this.isClickable = true
    this.isEnabled = true
    this.alpha = NO_ALPHA
}

fun AppCompatTextView.disableAlpha() {
    this.isClickable = false
    this.isEnabled = false
    this.alpha = HALF_ALPHA
}

fun AppCompatTextView.enableWithDefaultAlpha() {
    this.isClickable = true
    this.isEnabled = true
    this.alpha = NO_ALPHA
}

fun AppCompatEditText.disableAlpha() {
    alpha = HALF_ALPHA
    isFocusable = false
    isFocusableInTouchMode = false
}

fun AppCompatEditText.enableWithDefaultAlpha() {
    alpha = NO_ALPHA
    isFocusable = true
    isFocusableInTouchMode = true
}

fun ScrollView.scrollToBottom() {
    val lastChild = getChildAt(childCount - 1)
    val bottom = lastChild.bottom + paddingBottom
    val delta = bottom - (scrollY + height)
    smoothScrollBy(0, delta)
}
