# jetpack
Android con Jetpack Compose

 - Open firebase console and register a new app

 - Switch to the Project view in Android Studio to see
   your project root directory.

 - Move your downloaded google-services.json file
   into your module (app-level) root directory.

- To make the google-services.json config values accessible to Firebase SDKs, you need the Google services Gradle plug-in.

- Add the plug-in as a dependency to your project-level build.gradle.kts file:
  Root-level (project-level) Gradle file (<project>/build.gradle.kts): 

  id("com.google.gms.google-services") version "4.4.1" apply false

- add the dependencies 
- Then, in your module (app-level) build.gradle.kts file, add both the google-services plug-in and any Firebase SDKs that you want to use in your app:

  gradle - app/plugins
  id("com.google.gms.google-services")

  then add the dependencies in the gradle/app
  implementation("com.google.firebase:firebase-messaging-ktx:23.4.1")
  
  and before the unit testing dependencies add these ones
  implementation(platform("com.google.firebase:firebase-bom:32.7.3"))
  implementation("com.google.firebase:firebase-analytics")

  

- Sync the gradle,run the app and check the Firebase console


  do not forget to add the required permissions in the android manifest.xml

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />


  if you want to try the push notifications go to your app and check if notifications are enabled and thats it
 
  go to the firebase console and create a new push notification