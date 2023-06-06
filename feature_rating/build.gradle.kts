
plugins {
    id (Plugins.library)
    id (Plugins.kotlin)
}

android {
    compileSdk = Config.compileSdk
    namespace = "ru.sr.nineteen.feature_rating"
    defaultConfig {
        minSdk = Config.minSdk
    }
    buildFeatures {
        compose = true
    }

    compileOptions   {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility  = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Config.jmvTarget
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
    }
}

dependencies {

    implementation(project(Module.coreUi))
    implementation(project(Module.core))
    implementation(project(Module.database))

    implementation(Dependencies.Di.koin)
    implementation(Dependencies.Di.koinCompose)
    implementation(Dependencies.Di.koinAndroid)

    implementation(Dependencies.Compose.activityCompose)
    implementation(platform(Dependencies.Compose.composeBom))
    implementation(Dependencies.Compose.composeUi)
    implementation(Dependencies.Compose.composeUiGraphics)
    implementation(Dependencies.Compose.composePreview)
    implementation(Dependencies.Compose.composeMaterial)
}