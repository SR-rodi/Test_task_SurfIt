plugins {
    id(Plugins.library)
    id(Plugins.kotlin)
}

android {
    compileSdk = Config.compileSdk
    namespace = "ru.sr.nineteen.core_ui"
    defaultConfig {
        minSdk = Config.minSdk
    }
    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Config.jmvTarget
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
    }
}

dependencies {

    implementation(project(Module.core))

    implementation(Dependencies.Navigation.navigate)
    implementation(Dependencies.Compose.activityCompose)
    implementation(platform(Dependencies.Compose.composeBom))
    implementation(Dependencies.Compose.composeUi)
    implementation(Dependencies.Compose.composeUiGraphics)
    implementation(Dependencies.Compose.composePreview)
    implementation(Dependencies.Compose.composeMaterial)
}