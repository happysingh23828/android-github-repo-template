package dev.happysingh.core.ext

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Paint
import android.net.Uri
import android.provider.Settings
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.math.roundToInt

fun isAllValuesNull(vararg items: Int?): Boolean {
    for (item in items) {
        if (item == null) {
            return true
        }
    }
    return false
}

fun isAllValuesNull(vararg items: String?): Boolean {
    for (item in items) {
        if (item == null) {
            return true
        }
    }
    return false
}

fun isAllValuesNull(vararg items: Any?): Boolean {
    for (item in items) {
        if (item == null) {
            return true
        }
    }
    return false
}

fun Float.roundToOneDecimalPlace(): Float {
    return String.format("%.2f", this).toFloat()
}

fun Context.shareIntent(msg: String) {
    val shareIntent = Intent()
    shareIntent.action = Intent.ACTION_SEND
    shareIntent.type = "text/plain"
    shareIntent.putExtra(Intent.EXTRA_TEXT, msg)
    startActivity(Intent.createChooser(shareIntent, "Share to"))
}

fun Context.openSettings() {
    val intent = Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", packageName, null)
    )
    intent.addCategory(Intent.CATEGORY_DEFAULT)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
}

inline var AppCompatTextView.strike: Boolean
    set(visible) {
        paintFlags = if (visible) paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        else paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
    get() = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG == Paint.STRIKE_THRU_TEXT_FLAG

fun Context.openCustomizedConfirmDialog(
    msg: String,
    positiveButtonText: String,
    negativeButtonText: String,
    onYesClick: () -> Unit,
    onNoClick: () -> Unit
) {
    MaterialAlertDialogBuilder(this)
        .setMessage(msg)
        .setPositiveButton(positiveButtonText) { dialog, _ ->
            onYesClick.invoke()
            dialog.dismiss()
        }
        .setNegativeButton(negativeButtonText) { dialog, _ ->
            onNoClick.invoke()
            dialog.dismiss()
        }.show()
}

// send alpha under from 0.0f to 1.0f.
private const val RGB_MAX_VALUE = 255
fun Context.getAlphaColor(@ColorRes color: Int, alpha: Float): Int {
    return ColorUtils.setAlphaComponent(
        ContextCompat.getColor(this, color),
        RGB_MAX_VALUE.times(alpha).roundToInt()
    )
}

/**
 * This showToast fun can be called from context object
 */
fun Context.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

enum class ScreenOrientation(val value: Int) {
    PORTRAIT(Configuration.ORIENTATION_PORTRAIT),
    LANDSCAPE(Configuration.ORIENTATION_LANDSCAPE)
}

inline val ViewGroup.children: List<View>
    get() = (0 until childCount).map { getChildAt(it) }
