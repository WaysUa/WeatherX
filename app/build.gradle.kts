import java.util.Properties

val file: File = project.rootProject.file("local.properties")
val localProperties = file.inputStream().bufferedReader().use {
    Properties().apply { load(it) }
}

plugins {
    id(Plugins.Application.dependency)
    id(Plugins.Android.dependency)
    id(Plugins.Ktlint.dependency) version (Plugins.Ktlint.version)
}

android {
    namespace = Config.appModulePackageName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.appModulePackageName
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName
        buildFeatures.buildConfig = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "API_KEY", "\"${localProperties.getProperty("API_KEY")}\"")
    }

    buildTypes {
        @Suppress("UnstableApiUsage")
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    viewBinding.enable = true
}

ktlint {
    android.set(true)
    ignoreFailures.set(false)
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.SARIF)
    }
}

dependencies {
    // Basic
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.constraintLayout)
    implementation(Dependencies.Android.material)
    implementation(Dependencies.Android.fragment)
    implementation(Dependencies.Google.playServicesLocation)
    // Unit Testing
    testImplementation(Dependencies.UnitTesting.JUnit.core)
    testImplementation(Dependencies.UnitTesting.KotlinX.coroutines)
    // Ui Testing
    androidTestImplementation(Dependencies.AndroidTesting.JUnit.core)
    androidTestImplementation(Dependencies.AndroidTesting.JUnit.ui)
    androidTestImplementation(Dependencies.AndroidTesting.Espresso.core)
    androidTestImplementation(Dependencies.AndroidTesting.AndroidX.core)
    androidTestImplementation(Dependencies.AndroidTesting.Barista.core)
    // Navigation
    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationUi)
    // Permissions
    implementation(Dependencies.PermissionX.core)
    // Retrofit, i don't use here buildSrc, throw some error faced with retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")
    // SmoothBottomNavigation
    implementation(Dependencies.SmoothBottomBar.core)
    // OkHttp
    implementation(Dependencies.OkHttp.core)
    // Splash Screen
    implementation(Dependencies.SplashScreen.main)
}
