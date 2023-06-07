
plugins {
    id (Plugins.library)
    id (Plugins.kotlin)
    id ("kotlin-parcelize")
}

android {
    compileSdk = Config.compileSdk
    namespace = "ru.sr.nineteen.feature_rating_widget"
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

    implementation(project(Module.core))
    implementation(project(Module.database))

    implementation(Dependencies.Glance.glance)
    implementation(Dependencies.Glance.glanceAppwidget)
    implementation(Dependencies.Gson.gson)

    implementation(Dependencies.Database.room)

    implementation(Dependencies.Compose.activityCompose)
    implementation(platform(Dependencies.Compose.composeBom))
    implementation(Dependencies.Compose.composeUi)
    implementation(Dependencies.Compose.composeUiGraphics)
    implementation(Dependencies.Compose.composePreview)
    implementation(Dependencies.Compose.composeMaterial)
}