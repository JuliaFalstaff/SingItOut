import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.jfalstaff.singitout"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes.onEach {
        val properties = Properties()
        properties.load(project.rootProject.file("token.properties").inputStream())
        val tokenAuth = properties.getProperty("TOKEN_GENIUS", "")
        it.buildConfigField("String", "TOKEN_GENIUS", tokenAuth)
    }

    buildTypes.onEach {
        val properties = Properties()
        properties.load(project.rootProject.file("tokenRapid.properties").inputStream())
        val tokenRapidAuth = properties.getProperty("TOKEN_RAPID_GENIUS", "")
        it.buildConfigField("String", "TOKEN_RAPID_GENIUS", tokenRapidAuth)
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
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=enable")
    }
    buildFeatures {
        viewBinding = true
    }
}


dependencies {

    implementation(Dependencies.CORE_KTX_DEP)
    implementation(Dependencies.APPCOMPAT_DEP)
    implementation(Dependencies.MATERIAL_DEP)
    implementation(Dependencies.CONSTRAINT_DEP)
    testImplementation(Dependencies.JUNIT_DEP)
    androidTestImplementation(Dependencies.JUNIT_ANDROID_DEP)
    androidTestImplementation(Dependencies.ESPRESSO_CORE_DEP)

    //Retrofit
    implementation(Dependencies.RETROFIT_DEP)
    implementation(Dependencies.OKHTTP_LOGGING)

    //Coroutines
    implementation(Dependencies.COROUTINES_CORE_DEP)
    implementation(Dependencies.COROUTINES_KOTLIN)

    //ViewModel
    implementation(Dependencies.VIEWMODEL_LIFECYCLE_KTX_DEP)

    //Glide
    implementation(Dependencies.GLIDE_DEP)
    kapt(Dependencies.GLIDE_KAPT)

    //Paging 3/
    implementation(Dependencies.PAGING_DEP)

    //Moshi
    implementation(Dependencies.MOSHI_DEP)
    kapt(Dependencies.MOSHI_KAPT)
    implementation(Dependencies.MOSHI_RETROFIT_DEP)
    implementation(Dependencies.MOSHI_KOTLIN_DEP)
    implementation(Dependencies.MOSHI_CONVERTER_DEP)

    //Palette
    implementation(Dependencies.PALETTE_DEP)

    //Dagger 2
    implementation(Dependencies.DAGGER_2_DEP)
    kapt(Dependencies.DAGGER_2_KAPT_DEP)

    //Cicerone
    implementation(Dependencies.CICERONE_DEP)

    //Shimmering
    implementation(Dependencies.SHIMMER_DEP)

    implementation(Dependencies.SPLASH_DEP)
}