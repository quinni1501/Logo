// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.3.0" apply false
    // ...
    // Add the dependency for the Google services Gradle plugin
    id("com.google.gms.google-services") version "4.4.1" apply false

}
buildscript {
    dependencies {
        // Add this line
        classpath ("com.google.gms:google-services:4.3.10")
        classpath ("com.android.tools.build:gradle:7.3.0")
    }
}