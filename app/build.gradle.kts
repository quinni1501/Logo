plugins {
    id("com.android.application")
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
    implementation(platform("com.google.firebase:firebase-bom:33.0.0"))

    // When using the BoM, you don't specify versions in Firebase library dependencies

    // Add the dependency for the Firebase SDK for Google Analytics
    implementation("com.google.firebase:firebase-analytics")
    implementation ("com.google.firebase:firebase-database:20.0.5")
    implementation ("com.google.firebase:firebase-core:21.1.1")
    implementation ("com.google.android.material:material:1.6.1")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("androidx.viewpager:viewpager:1.0.0")
    implementation (platform ("com.google.firebase:firebase-bom:31.1.0"))
    implementation ("com.google.firebase:firebase-database")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
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
    //Zoom Layout
    implementation ("com.otaliastudios:zoomlayout:1.9.0")
}