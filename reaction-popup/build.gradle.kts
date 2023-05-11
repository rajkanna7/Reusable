import com.augusta.reusablecomponent.Configuration
import com.augusta.reusablecomponent.Dependencies.emoji

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
    id("maven-publish")
}

android {
    namespace = "com.augusta.reaction_popup"
    compileSdk = Configuration.compileSdk

    defaultConfig {
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
}

dependencies {
    emoji()
    implementation(com.augusta.reusablecomponent.Dependencies.composeUI)
    implementation(com.augusta.reusablecomponent.Dependencies.composeFoundation)
    implementation(com.augusta.reusablecomponent.Dependencies.composeMaterial)
    implementation(com.augusta.reusablecomponent.Dependencies.composeActivity)
    implementation(com.augusta.reusablecomponent.Dependencies.androidxCoreKtx)
    implementation(com.augusta.reusablecomponent.Dependencies.material)
    implementation(com.augusta.reusablecomponent.Dependencies.composeTooling)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}


afterEvaluate {
    publishing {
        publications {
            val release by publications.registering(MavenPublication::class) {
                from(components["release"])
                artifactId = "reaction-popup"
                groupId = "com.github.rajkanna7"
                version = "1.0.1"  //github release of com.github.danbrough.jitpackdemo
            }
        }
    }
}

