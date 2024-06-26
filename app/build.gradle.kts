plugins {
    id("com.android.application")
    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")

}

android {
    namespace = "vn.superandroid.logo"
    compileSdk = 34

    dataBinding {
        enable = true
    }
    defaultConfig {
        applicationId = "vn.superandroid.logo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("androidx.viewpager:viewpager:1.0.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-database:21.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //CircleImageView
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    //circle indicator
    implementation ("me.relex:circleindicator:2.1.6")
    //Gson
    implementation ("com.google.code.gson:gson:2.10.1")
    //Retrofit & Network
    implementation ("com.squareup.retrofit2:retrofit:(insert latest version)")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.12.0")
    //Bottom Sheet
    implementation ("com.google.android.material:material:1.12.0")
    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
    implementation ("com.google.android.material:material:1.6.1")
    implementation ("com.google.android.material:material:1.11.0")
    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")
    implementation ("com.otaliastudios:zoomlayout:1.9.0")


    // Add the dependencies for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries
}