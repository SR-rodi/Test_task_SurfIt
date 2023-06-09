plugins {
    id(Plugins.application)
    id(Plugins.kotlin)
}

android {
    namespace = Config.namespace
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            // proguardFiles getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Config.jmvTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
    }
}

dependencies {

    implementation(project(Module.navGraph))
    implementation(project(Module.coreUi))
    implementation(project(Module.core))
    implementation(project(Module.database))
    implementation(project(Module.featureRating))
    implementation(project(Module.featureRatingWidget))

    implementation(Dependencies.Navigation.navigate)

    implementation(Dependencies.Di.koin)

    implementation(Dependencies.Database.room)

    implementation(Dependencies.Core.coreKtx)
    implementation(platform(Dependencies.Core.kotlinBoom))
    implementation(Dependencies.Core.lifecycle)
    implementation(Dependencies.Compose.activityCompose)
    implementation(platform(Dependencies.Compose.composeBom))
    implementation(Dependencies.Compose.composeUi)
    implementation(Dependencies.Compose.composeUiGraphics)
    implementation(Dependencies.Compose.composePreview)
    implementation(Dependencies.Compose.composeMaterial)
}