package com.example.jetpack

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BiometricAuthenticationScreen()
        }
    }
}

@Composable
fun BiometricAuthenticationScreen() {
    val context = LocalContext.current
    val biometricManager = remember { BiometricManager.from(context) }
    val canAuthenticate by remember { mutableStateOf(biometricManager.canAuthenticate() == BiometricManager.BIOMETRIC_SUCCESS) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (canAuthenticate) {
            BiometricAuthenticationButton()
        } else {
            Text(text = "Biometric authentication is not available on this device.")
        }
    }
}

@Composable
fun BiometricAuthenticationButton() {
    val context = LocalContext.current as FragmentActivity
    var authenticationResult by remember { mutableStateOf("") }

    Button(
        onClick = {
            val biometricPrompt = BiometricPrompt(context, ContextCompat.getMainExecutor(context),
                object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)
                        authenticationResult = "Authentication succeeded"
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        authenticationResult = "Authentication failed"
                    }
                })

            val promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric Authentication")
                .setSubtitle("Please authenticate to continue")
                .setDeviceCredentialAllowed(true)
                .build()

            biometricPrompt.authenticate(promptInfo)
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Authenticate with Biometrics")
    }

    Text(text = authenticationResult, modifier = Modifier.padding(16.dp))
}
