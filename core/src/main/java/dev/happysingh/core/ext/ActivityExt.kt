package dev.happysingh.core.ext

import android.app.Activity
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dev.happysingh.core.R

fun AppCompatActivity.disableScreenCapture(buildType: String) {
    this.window.setFlags(
        WindowManager.LayoutParams.FLAG_SECURE,
        WindowManager.LayoutParams.FLAG_SECURE
    )
}

fun Activity.hideInputMethod() =
    run {
        val inputMethodManager: InputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        window.peekDecorView()
            ?.let {
                inputMethodManager.hideSoftInputFromWindow(
                    window.peekDecorView().windowToken,
                    0
                )
            }
    }

fun Activity.showInputMethod(v: EditText) =
    run {
        val inputMethodManager: InputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        v.requestFocus()
        inputMethodManager.showSoftInput(v, InputMethodManager.SHOW_FORCED)
    }

/**
 * This showToast fun can be called from Activity
 */
fun AppCompatActivity.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * This showSnackBar fun can be called from Activity
 */
fun AppCompatActivity.showSnackBar(message: String) {
    val mParentView = this.window.decorView.rootView
    if (mParentView != null) {
        Snackbar.make(mParentView, message, Snackbar.LENGTH_LONG).show()
    }
}

fun AppCompatActivity.openSelectionDialog(
    title: String,
    arrayOfString: Array<String>,
    onPositionSelect: (Int) -> Unit,
    @StyleRes style: Int = 0
) {

    MaterialAlertDialogBuilder(this, style)
        .setTitle(title)
        .setItems(arrayOfString) { dialog, which ->
            onPositionSelect.invoke(which)
            dialog.dismiss()
        }.show()
}

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

fun AppCompatActivity.getScreenOrientation(): ScreenOrientation {
    return when (resources.configuration.orientation) {
        ScreenOrientation.PORTRAIT.value -> ScreenOrientation.PORTRAIT
        ScreenOrientation.LANDSCAPE.value -> ScreenOrientation.LANDSCAPE
        else -> ScreenOrientation.PORTRAIT
    }
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
