package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.jetpack.ui.theme.JetpackTheme

//ComponentActivity

//old
//AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("welcome to my jetpack")
                }
            }
        }
    }




   private var canAuthenticate = false
   private lateinit var promptInfo: BiometricPrompt.PromptInfo
   fun setupAuth() {
       if(androidx.biometric.BiometricManager.from(this).canAuthenticate(
               androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG or
                       androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL) == androidx.biometric.BiometricManager.BIOMETRIC_SUCCESS) {

               canAuthenticate = true
               promptInfo = BiometricPrompt.PromptInfo.Builder()
                   .setTitle("Auth biométrica")
                   .setSubtitle("Autenticate utilizando el sensor biométrico")
                   .setAllowedAuthenticators(androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG or
                   androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL)
                   .build()

       }
   }


   fun authenticate(auth: (auth: Boolean) -> Unit) {
       if (canAuthenticate) {
           BiometricPrompt(this, ContextCompat.getMainExecutor(this),
               object : BiometricPrompt.AuthenticationCallback() {

                   override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                       super.onAuthenticationSucceeded(result)

                       auth(true)
                   }
           }).authenticate(promptInfo)
       } else {
           auth(true)
       }
   }






}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackTheme {
        Greeting("Android")
    }
}