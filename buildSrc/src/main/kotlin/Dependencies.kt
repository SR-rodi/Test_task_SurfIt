import Dependencies.Versions.activityComposeVersion
import Dependencies.Versions.composeBomVersion
import Dependencies.Versions.coreKtxVersions
import Dependencies.Versions.koinVersion
import Dependencies.Versions.kotlinBoomVersions
import Dependencies.Versions.lifecycleVersions
import Dependencies.Versions.navigateVersion
import Dependencies.Versions.roomVersion

object Dependencies {

    internal object Versions {
        const val coreKtxVersions = "1.10.1"
        const val kotlinBoomVersions = "1.8.0"
        const val lifecycleVersions = "2.6.1"
        const val roomVersion = "2.5.1"
        const val koinVersion = "3.4.0"
        const val navigateVersion = "2.5.3"
        const val activityComposeVersion = "1.7.2"
        const val composeBomVersion = "2022.10.00"
    }

    object Compose {
        const val activityCompose = ("androidx.activity:activity-compose:$activityComposeVersion")
        const val composeBom = ("androidx.compose:compose-bom:$composeBomVersion")
        const val composeUi = ("androidx.compose.ui:ui")
        const val composeUiGraphics = ("androidx.compose.ui:ui-graphics")
        const val composePreview = ("androidx.compose.ui:ui-tooling-preview")
        const val composeMaterial = ("androidx.compose.material3:material3")
    }

    object Core {
        const val coreKtx = ("androidx.core:core-ktx:$coreKtxVersions")
        const val kotlinBoom = ("org.jetbrains.kotlin:kotlin-bom:$kotlinBoomVersions")
        const val lifecycle = ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersions")

    }

    object Navigation {
        const val navigate = ("androidx.navigation:navigation-compose:$navigateVersion")
    }

    object Database {
        val roomRuntime = ("androidx.room:room-runtime:$roomVersion")
        val room = ("androidx.room:room-ktx:$roomVersion")
        val roomAnnotation = ("androidx.room:room-compiler:$roomVersion")
        val ksp = ("androidx.room:room-compiler:$roomVersion")
    }

    object Di {
        val koin = ("io.insert-koin:koin-android:$koinVersion")
        val koinCompose = ("io.insert-koin:koin-core:$koinVersion")
        val koinAndroid = ("io.insert-koin:koin-androidx-compose:$koinVersion")
    }
}