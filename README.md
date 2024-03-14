# jetpack
Android con biometrics

There is a issue in the androidmanifest about Jetpack Theme, just replace with this

android:theme="@style/Theme.AppCompat.Light"



- add the permissions
    uses-permission android:name="android.permission.INTERNET" 
    uses-permission android:name="android.permission.POST_NOTIFICATIONS" 


just to mention this is made with Gradle not Groovy

1. Add Dependencies:

Make sure to include the necessary dependencies in your build.gradle file:
implementation "androidx.biometric:biometric:1.2.0-alpha04"
implementation "androidx.activity:activity-ktx:1.3.0-alpha02"
implementation "androidx.fragment:fragment-ktx:1.4.0-alpha02"


2. Request Biometric Authentication Permission:

In your AndroidManifest.xml file, ensure you have the necessary permissions:
  uses-permission android:name="android.permission.USE_BIOMETRIC"


3. Implement Biometric Authentication Logic:

just check the MainActivity.kt

