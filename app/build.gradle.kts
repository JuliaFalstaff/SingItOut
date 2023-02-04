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

//    implementation 'androidx.core:core-ktx:1.7.0'
//    implementation 'androidx.appcompat:appcompat:1.5.1'
//    implementation 'com.google.android.material:material:1.7.0'
//    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.4'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.0'

        implementation(Dependencies.CORE_KTX_DEP)
        implementation(Dependencies.APPCOMPAT_DEP)
        implementation(Dependencies.MATERIAL_DEP)
        implementation(Dependencies.CONSTRAINT_DEP)
        testImplementation(Dependencies.JUNIT_DEP)
        androidTestImplementation(Dependencies.JUNIT_ANDROID_DEP)
        androidTestImplementation(Dependencies.ESPRESSO_CORE_DEP)

        //Retrofit
//    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
//    implementation 'com.squareup.okhttp3:logging-interceptor:4.9.0'
        implementation(Dependencies.RETROFIT_DEP)
        implementation(Dependencies.OKHTTP_LOGGING)

        //Coroutines
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1"
        implementation(Dependencies.COROUTINES_CORE_DEP)
        implementation(Dependencies.COROUTINES_KOTLIN)

        //ViewModel
//    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
        implementation(Dependencies.VIEWMODEL_LIFECYCLE_KTX_DEP)

        //Glide
//    implementation 'com.github.bumptech.glide:glide:4.12.0'
//    kapt 'com.github.bumptech.glide:compiler:4.12.0'
        implementation(Dependencies.GLIDE_DEP)
        kapt(Dependencies.GLIDE_KAPT)

        //Paging 3
//    def paging_version = "3.1.1"
//    implementation "androidx.paging:paging-runtime:$paging_version"
        implementation(Dependencies.PAGING_DEP)

        /*Moshi*/
//    def moshiVersion = "1.9.1"
//    implementation("com.squareup.moshi:moshi:$moshiVersion")
//    kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion")
//    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
//    implementation "com.squareup.moshi:moshi-kotlin:$moshiVersion"
        implementation(Dependencies.MOSHI_DEP)
        kapt(Dependencies.MOSHI_KAPT)
        implementation(Dependencies.MOSHI_RETROFIT_DEP)
        implementation(Dependencies.MOSHI_KOTLIN_DEP)
        implementation(Dependencies.MOSHI_CONVERTER_DEP)

        //Palette
//    implementation 'androidx.palette:palette-ktx:1.0.0'
        implementation(Dependencies.PALETTE_DEP)

        //Dagger 2
//    implementation 'com.google.dagger:dagger:2.40'
//    kapt 'com.google.dagger:dagger-compiler:2.40'
        implementation(Dependencies.DAGGER_2_DEP)
        kapt(Dependencies.DAGGER_2_KAPT_DEP)

        //Cicerone
//    implementation 'com.github.terrakok:cicerone:7.1'
        implementation(Dependencies.CICERONE_DEP)

        //Shimmering
//    implementation 'com.facebook.shimmer:shimmer:0.5.0'
        implementation(Dependencies.SHIMMER_DEP)
    }
}