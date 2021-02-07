package dev.happysingh.core.ext

import android.widget.Toast
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

/**
 * This showToast fun can be called from fragment
 */
fun Fragment.showToast(message: String?) {
    Toast.makeText(this.activity, message, Toast.LENGTH_SHORT).show()
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

fun Fragment.openSelectionDialog(
    title: String,
    arrayOfString: Array<String>,
    onPositionSelect: (Int) -> Unit,
    @StyleRes style: Int = 0
) {

    MaterialAlertDialogBuilder(requireContext(), style)
        .setTitle(title)
        .setItems(arrayOfString) { dialog, which ->
            onPositionSelect.invoke(which)
            dialog.dismiss()
        }.show()
}

fun Fragment.getScreenOrientation(): ScreenOrientation {
    return when (resources.configuration.orientation) {
        ScreenOrientation.PORTRAIT.value -> ScreenOrientation.PORTRAIT
        ScreenOrientation.LANDSCAPE.value -> ScreenOrientation.LANDSCAPE
        else -> ScreenOrientation.PORTRAIT
    }
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
