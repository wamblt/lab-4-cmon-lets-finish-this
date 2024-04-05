plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.protobuf") version "0.9.4"
}

android {
    namespace = "com.example.lab_4_cmon_lets_finish_this"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.lab_4_cmon_lets_finish_this"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("com.google.protobuf:protobuf-kotlin-lite:3.21.7")

}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.21.7"
    }
    // Generates the java Protobuf-lite code for the Protobufs in this project. See
    // https://github.com/google/protobuf-gradle-plugin#customizing-protobuf-compilation // for more information.
    generateProtoTasks {
        all().forEach {
                task ->
            task.builtins {
// For when the sources are defined in src/<directory>/kotlin
                create("kotlin") {
                    option("lite")
                }
// For when the sources are defined in src/<directory>/java
                create("java") {
                    option("lite")
                }
            }
        }
    }
}
