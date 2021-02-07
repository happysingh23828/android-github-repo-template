package dev.happysingh.core.ext

import android.graphics.Bitmap
import android.graphics.Matrix
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

private const val BITMAP_QUALITY = 100
fun Bitmap.toBase64(compressFormat: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG): String {
    val result: String
    val baos = ByteArrayOutputStream()
    compress(compressFormat, BITMAP_QUALITY, baos)
    baos.flush()
    baos.close()
    val bitmapBytes = baos.toByteArray()
    result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT)
    baos.flush()
    baos.close()
    return result
}

fun Bitmap.resize(w: Number, h: Number): Bitmap {
    val width = width
    val height = height
    val scaleWidth = w.toFloat() / width
    val scaleHeight = h.toFloat() / height
    val matrix = Matrix()
    matrix.postScale(scaleWidth, scaleHeight)
    if (width > 0 && height > 0) {
        return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
    }
    return this
}

fun Bitmap.saveFile(path: String, compressFormat: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG) {
    val f = File(path)
    if (!f.exists()) {
        f.createNewFile()
    }
    val stream = FileOutputStream(f)
    compress(compressFormat, BITMAP_QUALITY, stream)
    stream.flush()
    stream.close()
}

fun Bitmap.toByteArray(compressFormat: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG): ByteArray {
    val stream = ByteArrayOutputStream()
    compress(compressFormat, BITMAP_QUALITY, stream)
    return stream.toByteArray()
}
