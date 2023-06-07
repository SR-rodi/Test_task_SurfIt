package ru.sr.surfit.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sr.surrfit.graph.setNavigate
import ru.sr.surrfit.theme.LocalNavigateController
import ru.sr.surrfit.theme.SurfTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfTheme(isNightMode = false) {
                window.statusBarColor = SurfTheme.colors.background.toArgb()
                window.navigationBarColor = SurfTheme.colors.background.toArgb()
                NavHost(
                    modifier = Modifier
                        .background(SurfTheme.colors.background)
                        .fillMaxSize(),
                    navController = LocalNavigateController.current,
                    startDestination = viewModel.getStartDestination().name
                ) {
                    setNavigate()
                }
            }
        }
    }
}