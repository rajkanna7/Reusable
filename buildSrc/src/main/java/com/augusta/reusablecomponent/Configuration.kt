package com.augusta.reusablecomponent

object Configuration {
    const val compileSdk = 33
    const val targetSdk = 33
    const val minSdk = 21
    const val majorVersion = 1
    const val minorVersion = 2
    const val patchVersion = 1
    const val versionName = "$majorVersion.$minorVersion.$patchVersion"
    const val versionCode = 121
    const val snapshotVersionName = "$majorVersion.$minorVersion.${patchVersion + 1}-SNAPSHOT"
    const val artifactGroup = "com.holix.android"
}
