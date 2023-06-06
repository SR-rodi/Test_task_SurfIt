
plugins {
    id (Plugins.library)
    id (Plugins.kotlin)
    id (Plugins.ksp)


}

android {
    compileSdk = Config.compileSdk
    namespace = "ru.sr.nineteen.database"
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

    implementation (Dependencies.Database.roomRuntime)
    implementation (Dependencies.Database.room)
    annotationProcessor (Dependencies.Database.roomAnnotation)
    ksp (Dependencies.Database.ksp)

    implementation(Dependencies.Compose.activityCompose)
    implementation(platform(Dependencies.Compose.composeBom))
    implementation(Dependencies.Compose.composeUi)
    implementation(Dependencies.Compose.composeUiGraphics)
    implementation(Dependencies.Compose.composePreview)
    implementation(Dependencies.Compose.composeMaterial)
}