# jetpack
Retrofit and GSOM


- Add the dependencies in the gradle app

implementation ("com.squareup.retrofit2:retrofit:2.9.0")
implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
implementation ("com.google.code.gson:gson:2.8.7")

- add the permisisions on the android manifest

   uses-permission android:name="android.permission.INTERNET"
   uses-permission android:name="android.permission.POST_NOTIFICATIONS"

- create a model response
- create a network Client
- create a protocol/interface
- add the method in the viewmodel in this case was added in the mainActivity named getInfo()