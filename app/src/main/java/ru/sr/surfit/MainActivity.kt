package ru.sr.surfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import ru.sr.surrfit.graph.setNavigate
import ru.sr.surrfit.theme.LocalNavigateController
import ru.sr.surrfit.theme.SurfTheme
import ru.sr.surrfit.tree.NavigationTree

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfTheme {
                NavHost(
                    modifier = Modifier
                        .background(SurfTheme.colors.background)
                        .fillMaxSize(),
                    navController = LocalNavigateController.current,
                    startDestination = NavigationTree.RatingScreen.name
                ) {
                    setNavigate()
                }
            }
        }
    }
}