package dev.happysingh.core.ext

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

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

fun Activity.clearWindowBackground() =
    window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

fun Activity.steepStatusBar() {
    window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
}


/**
 * This showToast fun can be called from fragment
 */
fun Fragment.showToast(message: String?) {
    Toast.makeText(this.activity, message, Toast.LENGTH_SHORT).show()
}

/**
 * This showToast fun can be called from Activity
 */
fun AppCompatActivity.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * This showToast fun can be called from context object
 */
fun Context.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * This showSnackBar fun can be called from fragment
 */
fun Fragment.showSnackBar(message: String) {
    val mParentView = requireActivity().window.decorView.rootView
    if (mParentView != null) {
        Snackbar.make(mParentView, message, Snackbar.LENGTH_LONG).show()
    }
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

/**
 * This showSnackBar fun can be called from any view
 */
fun View.showSnackBar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}