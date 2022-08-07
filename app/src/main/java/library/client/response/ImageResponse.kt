package library.client.response

import android.graphics.Bitmap

interface ImageResponse {
    fun returnImage(cover: Bitmap?)
    fun returnImage(output: Bitmap?, table: String?)
}