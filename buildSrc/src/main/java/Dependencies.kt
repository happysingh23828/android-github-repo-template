package dependencies

object Dependencies {

    // add your modules variables here
    object Module {
        const val core = ":core"
    }


    object ClassPaths {
        const val gradleClasspath = "com.android.tools.build:gradle:${Version.gradleVersion}"
        const val googleService = "com.google.gms:google-services:${Version.googleServices}"
        const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-gradle:${Version.firebaseCrashlyticsGradle}"
        const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navigation}"
        const val kotlinGradlePluginClasspath =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
        const val dokkaPluginClasspath =
            "org.jetbrains.dokka:dokka-gradle-plugin:${Version.dokkaVeresion}"
        const val jacoco = "com.vanniktech:gradle-android-junit-jacoco-plugin:${Version.jacoco}"
    }

    object Plugins {
        const val ANDROID_APPLICATION = "com.android.application"
        const val ANDROID_LIBRARY = "com.android.library"
        const val GOOGLE_SERVICES = "com.google.gms.google-services"
        const val FIREBASE_CRASHLYTICS  = "com.google.firebase.crashlytics"
        const val KOTLIN_ANDROID = "kotlin-android"
        const val KOTLIN_KAPT = "kotlin-kapt"
        const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
        const val SAFE_ARGS = "androidx.navigation.safeargs.kotlin"
        const val DETEKT = "io.gitlab.arturbosch.detekt"
        const val JACOCO = "com.vanniktech.android.junit.jacoco"
    }

    object Lint {
        const val detekt = "io.gitlab.arturbosch.detekt:detekt-cli:${Version.detektVersion}"
        const val ktLint = "com.pinterest:ktlint:${Version.ktLint}"
    }

    object Firebase {
        const val core = "com.google.firebase:firebase-core:${Version.firebaseCore}"
        const val analytics = "com.google.firebase:firebase-analytics:${Version.firebaseAnalytics}"
        const val crashlytics = "com.google.firebase:firebase-crashlytics:${Version.firebaseCrashlytics}"
        const val messaging = "com.google.firebase:firebase-messaging:${Version.message}"
        const val play_services = "com.google.android.gms:play-services-auth:${Version.play_services}"
        const val play_plus = "com.google.android.gms:play-services-plus:${Version.play_plus}"
        const val location = "com.google.android.gms:play-services-location:${Version.location}"
        const val remoteConfig = "com.google.firebase:firebase-config:${Version.firebaseRemoteConfig}"
        const val playCore = "com.google.android.play:core:${Version.playCore}"

    }

    object Lifecycle {
        const val extension = "android.arch.lifecycle:extensions:${Version.lifecycle}"
        const val annotation_compliler = "android.arch.lifecycle:compiler:${Version.lifecycle}"

        // ViewModel and LiveData
        const val lifeCycleExtension =
            "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleVersion}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
        const val annotationProcessor = "androidx.annotation:annotation:1.0.0"
        const val annotationCompiler = "com.github.bumptech.glide:compiler:${Version.glide}"
    }

    object Gson {
        const val gson = "com.google.code.gson:gson:${Version.gson}"
    }

    object Kotlin {
        const val kotlin_stdlib_jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    }

    object OkHttp3 {
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Version.retrofit_log}"
        const val okHttp3 = "com.squareup.okhttp3:okhttp:3.12.1"
    }

    object Retrofit2 {
        const val adapterRxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Version.retrofit}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    }

    object AndroidX {
        const val fragment = "androidx.fragment:fragment:${Version.androidx}"
        const val annotation = "androidx.annotation:annotation:${Version.androidx}"
        const val core = "androidx.core:core:${Version.androidx}"
        const val coreKtx = "androidx.core:core-ktx:${Version.ktx}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Version.androidx_112}"
        const val materialDesign = "com.google.android.material:material:${Version.materialDesign}"
        const val support_recyclerview_v7 =
            "androidx.recyclerview:recyclerview:${Version.recyclerView}"
        const val appcompat = "androidx.appcompat:appcompat:${Version.androidx_100beta01}"
        const val vectordrawable =
            "androidx.vectordrawable:vectordrawable:${Version.androidx_100beta01}"
        const val legacySupport = "androidx.legacy:legacy-support-v4:${Version.legacySupport}"
        const val navigation = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Version.room}"
        const val rxjava2 = "androidx.room:room-rxjava2:${Version.room}"
        const val annotationProcessor = "androidx.room:room-compiler:${Version.room}"
    }

    object RxJava {
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Version.rxAndroid}"
        const val rxjava2 = "io.reactivex.rxjava2:rxjava:${Version.rx}"
        const val rxrelay2 = "com.jakewharton.rxrelay2:rxrelay:${Version.rxRelay}"
        const val rxBinding = "com.jakewharton.rxbinding3:rxbinding:${Version.rxBinding}"
    }

    object Dagger {
        const val dagger2 = "com.google.dagger:dagger:${Version.dagger2}"
        const val daggerAndroid = "com.google.dagger:dagger-android:${Version.dagger2}"
        const val daggerAndroidSupport =
            "com.google.dagger:dagger-android-support:${Version.dagger2}"
        const val processor = "com.google.dagger:dagger-android-processor:${Version.dagger2}"
        const val compiler = "com.google.dagger:dagger-compiler:${Version.dagger2}"
    }

    object Test {
        const val test_junit = "androidx.test.ext:junit:${Version.androidXJunit}"
        const val android_test_espresso_core =
            "androidx.test.espresso:espresso-core:${Version.espresso}"
        const val android_test_room = "android.arch.persistence.room:testing:${Version.room}"
        const val testing_core_testing = "android.arch.core:core-testing:${Version.lifecycle}"
        const val android_test_rules = "androidx.test:rules:${Version.rules}"
        const val android_test_runner = "androidx.test:runner:${Version.runner}"
        const val mockito = "org.mockito:mockito-core:${Version.mockito}"
        const val mockitoInLine = "org.mockito:mockito-inline:${Version.mockitoInline}"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Version.mockWebServer}"
        const val assert_j = "org.assertj:assertj-core:${Version.assertJVersion}"
        const val roboElectric = "org.robolectric:robolectric:${Version.roboElectric}"
    }

    object Support {
        const val supportV4 = "com.android.support:support-v4:${Version.supportLib}"
    }

    object ThirdPartiesLib {
        const val timber = "com.jakewharton.timber:timber:${Version.timber}"
        const val jodaTime = "joda-time:joda-time:${Version.jodaTime}"
        const val picasso = "com.squareup.picasso:picasso:${Version.picasso}"
    }

    const val javax = "javax.inject:javax.inject:${Version.javaxInject}"
    const val javaxjsr250 = "javax.annotation:jsr250-api:${Version.javaxAnnotation}"
    const val parceler = "org.parceler:parceler-api:${Version.parcelerVersion}"
    const val parcelerProcessor = "org.parceler:parceler-api:${Version.parcelerVersion}"
}
