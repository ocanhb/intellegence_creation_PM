@file:Suppress("UNUSED_VARIABLE")

package com.example.creation.screens.Profile

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.activity.result.contract.ActivityResultContracts.TakePicturePreview
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var bitmapImage by remember { mutableStateOf<Bitmap?>(null) }

    // Galeri: pilih file
    val pickImageLauncher = rememberLauncherForActivityResult(GetContent()) { uri: Uri? ->
        imageUri = uri
    }

    // Kamera: ambil foto
    val takePictureLauncher = rememberLauncherForActivityResult(TakePicturePreview()) { bitmap: Bitmap? ->
        bitmapImage = bitmap
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Upload Foto Profil",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(onClick = { pickImageLauncher.launch("image/*") }) {
                    Text("Pilih dari Galeri")
                }

                Button(onClick = { takePictureLauncher.launch() }) {
                    Text("Ambil Foto")
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            when {
                imageUri != null -> {
                    Image(
                        painter = rememberAsyncImagePainter(imageUri),
                        contentDescription = "Foto dari galeri",
                        modifier = Modifier.size(200.dp)
                    )
                }

                bitmapImage != null -> {
                    Image(
                        bitmap = bitmapImage!!.asImageBitmap(),
                        contentDescription = "Foto dari kamera",
                        modifier = Modifier.size(200.dp)
                    )
                }

                else -> {
                    Text("Belum ada foto dipilih", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}
