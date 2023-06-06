import Dependencies.Versions.coreKtxVersions
import Dependencies.Versions.kotlinBoomVersions
import Dependencies.Versions.lifecycleVersions

object Dependencies {

   internal object Versions{
      const val  coreKtxVersions = "1.10.1"
      const val  kotlinBoomVersions = "1.8.0"
      const val  lifecycleVersions = "2.6.1"
    }

    object Compose {
        const val activityCompose = ("androidx.activity:activity-compose:1.7.2")
        const val composeBom = ("androidx.compose:compose-bom:2022.10.00")
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

}