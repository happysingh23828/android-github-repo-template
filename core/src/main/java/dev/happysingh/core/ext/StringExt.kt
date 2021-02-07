package dev.happysingh.core.ext

import android.os.Build
import android.text.Editable
import android.text.Html
import android.text.Spanned
import android.text.TextUtils
import java.util.regex.Pattern

fun String?.isValid(): Boolean {
    return this != null && this.isNotEmpty() && this.isNotBlank()
}

fun String?.isNotValid(): Boolean {
    return !this.isValid()
}

fun String.space(string: String?): String {
    return this.plus(" ${string ?: ""}")
}

fun String.newLineWithBullet(): String {
    return "".plus("\n \n").plus("\u25cf  ").plus(this)
}

fun String.toBoldHtml(): String {
    return "<b>".plus(this).plus("</b>")
}

fun String.toSpannedHtml(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(this)
    }
}

fun String.toFormattedInt(): String {
    return if (this.contains(".00")) {
        this.toDouble().toInt().toString()
    } else
        this.toDouble().toString()
}

private val emailRegex = Pattern.compile(
    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"
)

fun String.isEmail(): Boolean {
    return this.isValid() && emailRegex.matcher(this.trimEnd().trimStart()).matches()
}

private const val MIN_LENGTH_PHONE = 7
private const val MAX_LENGTH_PHONE = 13
fun String.isPhoneNumber(): Boolean {
    val minLength = MIN_LENGTH_PHONE
    val maxLength = MAX_LENGTH_PHONE
    return this.isValid() && IntRange(minLength, maxLength).contains(this.trimEnd().trimStart().length)
}

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

fun String.toHtmlString(): Spanned {
    return Html.fromHtml(this)
}

fun String?.fromHtmlToPlainText(): String? {

    return if (this != null) {
        val text = this.replace("\n", "<br>")
        val spanned = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(text)
        }

        val chars = CharArray(spanned.length)
        TextUtils.getChars(spanned, 0, spanned.length, chars, 0)
        return String(chars)
    } else {
        null
    }
}
