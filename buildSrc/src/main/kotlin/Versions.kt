object Versions {
    const val coreKtxVersion = "1.7.0"
    const val appcompatVersion = "1.5.1"
    const val materialVersion = "1.7.0"
    const val constraintLayoutVersion = "2.1.4"
    const val junitVersion = "4.13.2"
    const val junitAndroidTestVersion = "1.1.4"
    const val espressoVersion = "3.5.0"
    const val coroutinesCoreVersion = "1.5.2"
    const val coroutinesAndroidVersion = "1.6.1"
    const val retrofit2Version = "2.9.0"
    const val okhttp3LoggingInterceptorVersion = "4.9.0"
    const val lifecycleLivedataVersion = "2.5.1"
    const val lifecycleViewModelVersion = "2.4.0"
    const val glideVersion = "4.12.0"
    const val shimmerVersion = "0.5.0"
    const val dagger2Version = "2.40"
    const val paletteApiVersion = "1.0.0"
    const val ciceroneVersion = "7.1"
    const val moshiVersion = "1.9.1"
    const val moshiConverterVersion = "2.9.0"
    const val pagingVersion = "3.1.1"
}

object Dependencies {
    const val CORE_KTX_DEP = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val APPCOMPAT_DEP = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val MATERIAL_DEP = "com.google.android.material:material:${Versions.materialVersion}"
    const val CONSTRAINT_DEP =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val JUNIT_DEP = "junit:junit:${Versions.junitVersion}"
    const val JUNIT_ANDROID_DEP = "androidx.test.ext:junit:${Versions.junitAndroidTestVersion}"
    const val ESPRESSO_CORE_DEP = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"

    // ViewModel
    const val VIEWMODEL_LIFECYCLE_KTX_DEP =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelVersion}"

    // LiveData
    const val LIFECYCLE_LIVEDATA_KTX_DEP =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLivedataVersion}"

    //Retrofit
    const val RETROFIT_DEP = "com.squareup.retrofit2:retrofit:${Versions.retrofit2Version}"
    const val OKHTTP_LOGGING =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3LoggingInterceptorVersion}"

    //Glide
    const val GLIDE_DEP = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val GLIDE_KAPT = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"

    //Coroutines
    const val COROUTINES_CORE_DEP =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCoreVersion}"
    const val COROUTINES_KOTLIN =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroidVersion}"

    //Shimmering
    const val SHIMMER_DEP = "com.facebook.shimmer:shimmer:${Versions.shimmerVersion}"

    //Dagger 2
    const val DAGGER_2_DEP = "com.google.dagger:dagger:${Versions.dagger2Version}"
    const val DAGGER_2_KAPT_DEP = "com.google.dagger:dagger-compiler:${Versions.dagger2Version}"

    //Palette Api
    const val PALETTE_DEP = "androidx.palette:palette-ktx:${Versions.paletteApiVersion}"

    //Cicerone
    const val CICERONE_DEP = "com.github.terrakok:cicerone:${Versions.ciceroneVersion}"

    //Moshi
    const val MOSHI_DEP = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
    const val MOSHI_KAPT = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"
    const val MOSHI_RETROFIT_DEP = "com.squareup.retrofit2:converter-moshi:${Versions.moshiVersion}"
    const val MOSHI_KOTLIN_DEP = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    const val MOSHI_CONVERTER_DEP = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverterVersion}"

    //Paging 3
    const val PAGING_DEP = "androidx.paging:paging-runtime:${Versions.pagingVersion}"
}