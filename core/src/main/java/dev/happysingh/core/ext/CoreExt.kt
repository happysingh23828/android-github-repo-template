package dev.happysingh.core.ext

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Paint
import android.net.Uri
import android.provider.Settings
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dev.happysingh.core.R

enum class ScreenOrientation(val value: Int) {
    PORTRAIT(Configuration.ORIENTATION_PORTRAIT),
    LANDSCAPE(Configuration.ORIENTATION_LANDSCAPE)
}

fun AppCompatActivity.addFragment(layoutId: Int, fragment: Fragment) {
    this.supportFragmentManager.beginTransaction().add(layoutId, fragment).commit()
}

fun AppCompatActivity.replaceFragment(layoutId: Int, fragment: Fragment) {
    this.supportFragmentManager.beginTransaction().replace(layoutId, fragment).commit()
}

fun AppCompatActivity.addFragmentWithBackStack(layoutId: Int, fragment: Fragment, tag: String) {
    this.supportFragmentManager.beginTransaction().add(layoutId, fragment)
        .addToBackStack(tag).commit()
}

fun Fragment.addFragment(layoutId: Int, fragment: Fragment) {
    this.requireFragmentManager().beginTransaction().add(layoutId, fragment).commit()
}

fun Fragment.addChildFragment(layoutId: Int, fragment: Fragment) {
    this.childFragmentManager.beginTransaction().add(layoutId, fragment).commit()
}


fun Fragment.addFragmentBackStack(layoutId: Int, fragment: Fragment, tag: String) {
    this.fragmentManager?.beginTransaction()?.add(layoutId, fragment)?.addToBackStack(tag)
        ?.commit()
}

fun Fragment.replaceFragment(layoutId: Int, fragment: Fragment) {
    this.requireFragmentManager().beginTransaction().replace(layoutId, fragment).commit()
}

fun Fragment.replaceChildFragment(layoutId: Int, fragment: Fragment) {
    if (isAdded) {
        this.childFragmentManager.beginTransaction().replace(layoutId, fragment)
            .commitAllowingStateLoss()
    }
}


fun Fragment.replaceFragmentBackStack(layoutId: Int, fragment: Fragment, tag: String) {
    this.requireFragmentManager().beginTransaction().replace(layoutId, fragment).addToBackStack(tag)
        .commit()
}


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
    shareIntent.putExtra(Intent.EXTRA_TEXT, msg);
    startActivity(Intent.createChooser(shareIntent, "Share to"))
}


fun Fragment.getScreenOrientation(): ScreenOrientation {
    return when (resources.configuration.orientation) {
        ScreenOrientation.PORTRAIT.value -> ScreenOrientation.PORTRAIT
        ScreenOrientation.LANDSCAPE.value -> ScreenOrientation.LANDSCAPE
        else -> ScreenOrientation.PORTRAIT
    }
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

fun AppCompatActivity.getScreenOrientation(): ScreenOrientation {
    return when (resources.configuration.orientation) {
        ScreenOrientation.PORTRAIT.value -> ScreenOrientation.PORTRAIT
        ScreenOrientation.LANDSCAPE.value -> ScreenOrientation.LANDSCAPE
        else -> ScreenOrientation.PORTRAIT
    }
}

inline var AppCompatTextView.strike: Boolean
    set(visible) {
        paintFlags = if (visible) paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        else paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
    get() = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG == Paint.STRIKE_THRU_TEXT_FLAG

fun AppCompatActivity.openConfirmDialog(
    msg: String,
    onYesClick: () -> Unit,
    onNoClick: () -> Unit
) {
    MaterialAlertDialogBuilder(this)
        .setMessage(msg)
        .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
            onYesClick.invoke()
            dialog.dismiss()
        }
        .setNegativeButton(getString(R.string.no)) { dialog, _ ->
            onNoClick.invoke()
            dialog.dismiss()
        }.show()
}

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

fun Fragment.openSelectionDialog(
    title: String,
    arrayOfString: Array<String>,
    onPositionSelect: (Int) -> Unit,
    @StyleRes style : Int = 0
) {

    MaterialAlertDialogBuilder(requireContext(),style)
        .setTitle(title)
        .setItems(arrayOfString) { dialog, which ->
            onPositionSelect.invoke(which)
            dialog.dismiss()
        }.show()
}

fun AppCompatActivity.openSelectionDialog(
    title: String,
    arrayOfString: Array<String>,
    onPositionSelect: (Int) -> Unit,
    @StyleRes style : Int = 0
) {

    MaterialAlertDialogBuilder(this,style)
        .setTitle(title)
        .setItems(arrayOfString) { dialog, which ->
            onPositionSelect.invoke(which)
            dialog.dismiss()
        }.show()
}

