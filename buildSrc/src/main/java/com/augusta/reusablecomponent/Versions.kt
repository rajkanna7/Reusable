package com.augusta.reusablecomponent

import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {
    internal const val ANDROID_GRADLE_PLUGIN = "7.3.1"
    internal const val GRADLE_NEXUS_PUBLISH_PLUGIN = "1.1.0"
    internal const val KOTLIN = "1.8.10"

    internal const val MATERIAL = "1.8.0"
    internal const val ANDROIDX_CORE_KTX = "1.10.0"

    internal const val COMPOSE = "1.4.1"
    const val COMPOSE_COMPILER = "1.4.3"
    internal const val ANDROIDX_ACTIVITY = "1.7.0"

    internal const val COLOR_PICKER = "1.0.0"


    const val kotlin = "1.8.10"
    const val gradle = "7.4.0"
    const val junit5Gradle = "1.7.1.1"
    const val junit5 = "5.7.1"
    const val coroutines = "1.6.4"
    const val ktx = "1.9.0"
    const val ktxFragment = "1.5.6"
    const val ktxViewModel = "2.6.1"
    const val ktxLifecycleRuntime = "2.6.1"
    const val androidXJunit = "1.1.2"
    const val espresso = "3.3.0"
    const val appCompat = "1.7.0-alpha02"
    const val material = "1.4.0"
    const val material3 = "1.1.0-alpha07"
    const val ktlint = "10.0.0"
    const val dagger = "2.38"
    const val compose = "1.4.4"
    const val composejunit = "2.0.9"
    const val composeUI = "1.4.0-rc01"
    const val composeConstraint = "1.0.0-alpha08"
    const val composeActivity = "1.3.0-rc02"
    const val composeViewModel = "2.6.0-alpha05"
    const val orbit = "4.3.2"
    const val emoji = "0.15.0"
    const val lottie = "5.2.0"
    const val pagger = "0.27.1"
    const val exoPlayer = "2.18.2"
    const val coil = "2.1.0"
}



object Dependencies {
    const val androidGradlePlugin =
        "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
    const val gradleNexusPublishPlugin =
        "io.github.gradle-nexus:publish-plugin:${Versions.GRADLE_NEXUS_PUBLISH_PLUGIN}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"

    const val material = "com.google.android.material:material:${Versions.MATERIAL}"
    const val androidxActivityKtx = "androidx.activity:activity-ktx:${Versions.ANDROIDX_ACTIVITY}"
    const val androidxCoreKtx = "androidx.core:core-ktx:${Versions.ANDROIDX_CORE_KTX}"

    const val composeUI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.COMPOSE}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.ANDROIDX_ACTIVITY}"
    const val composeJunit = "androidx.compose.ui:ui-test-junit4:${Versions.ANDROIDX_ACTIVITY}"
    const val composeMainfest = "androidx.compose.ui:ui-test-manifest:1.2.0"
    const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    const val jUnit = "junit:junit:4.13.2"
    const val extJunit = "androidx.test.ext:junit:1.1.5"
    const val expresso = "androidx.test.espresso:espresso-core:3.5.1"


    const val colorPicker = "com.github.skydoves:colorpicker-compose:${Versions.COLOR_PICKER}"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.dagger}"

    fun DependencyHandler.kotlin() {
        implementation(Libs.Jetbrains.kotlinStdlib)
    }

    fun DependencyHandler.baseAndroid() {
        implementation(Libs.AndroidX.coreKtx)
        implementation(Libs.AndroidX.fragmentKtx)
        implementation(Libs.AndroidX.vmKtx)
        implementation(Libs.AndroidX.lifecycleRuntimeKtx)
        implementation(Libs.AndroidX.appCompat)
        implementation(Libs.Google.material)
//    implementation(Libs.AndroidX.material3)
    }

    fun DependencyHandler.dependencyInjection() {
        implementation(Libs.Google.dagger)
        implementation(Libs.Google.hilt)
        kapt(Libs.Google.Annotation.dagger)
        kapt(Libs.Google.Annotation.hilt)
    }

    fun DependencyHandler.emoji() {
        implementation(Libs.Reaction.emojipopup)
    }

    fun DependencyHandler.coil() {
        implementation(Libs.Coil.coilCompose)
        implementation(Libs.Coil.coilVideo)
        implementation(Libs.Coil.coilGif)
    }

    fun DependencyHandler.exoplayer() {
        implementation(Libs.Exoplayer.core)
        implementation(Libs.Exoplayer.playerUi)
        implementation(Libs.Exoplayer.mediasession)
    }

    fun DependencyHandler.accompanist() {
        implementation(Libs.accompanist.pagger)
        implementation(Libs.accompanist.pagerIndicators)
        implementation(Libs.accompanist.permissions)
        implementation(Libs.accompanist.navigationAnimation)
    }
    fun DependencyHandler.orbit() {
        implementation(Libs.Orbit.orbitCore)
        implementation(Libs.Orbit.orbitCompose)
        implementation(Libs.Orbit.orbitViewModel)
        implementation(Libs.Orbit.orbitTest)
    }

    fun DependencyHandler.compose() {
        implementation(Libs.AndroidX.Compose.ui)
        implementation(Libs.AndroidX.Compose.uiTooling)
        implementation(Libs.AndroidX.Compose.foundation)
        implementation(Libs.AndroidX.Compose.material)
        implementation(Libs.AndroidX.Compose.constraint)
        implementation(Libs.AndroidX.Compose.materialIconsCore)
        implementation(Libs.AndroidX.Compose.materialIconsExtended)
        implementation(Libs.AndroidX.Compose.activity)
        implementation(Libs.AndroidX.Compose.lottie)
        implementation(Libs.AndroidX.Compose.viewModel)
        implementation(Libs.AndroidX.Compose.navigation)
        implementation(Libs.AndroidX.Compose.material3)
        implementation(Libs.AndroidX.Compose.paging)
//    androidTestImplementation(Libs.AndroidX.Compose.AndroidTest.uiTest)
    }

    fun DependencyHandler.coroutines() {
        implementation(Libs.Jetbrains.Coroutines.core)
        implementation(Libs.Jetbrains.Coroutines.android)
    }

    fun DependencyHandler.test() {
        testImplementation(Libs.Jetbrains.Coroutines.Test.coroutines)
        testImplementation(Libs.JUnit.jupiter)
        testImplementation(Libs.JUnit.jupiterParams)
        testRuntimeOnly(Libs.JUnit.Runtime.jupiterEngine)
    }

    fun DependencyHandler.androidTest() {
        androidTestImplementation(Libs.AndroidX.AndroidTest.junit)
        androidTestImplementation(Libs.AndroidX.AndroidTest.espresso)
    }


}



