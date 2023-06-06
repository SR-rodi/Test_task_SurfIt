package ru.sr.surfit.presentation

import androidx.lifecycle.ViewModel
import ru.sr.surrfit.firstrunlistener.FirstRunListener
import ru.sr.surrfit.navigation.tree.NavigationTree


class MainViewModel(
    private val firstRunListener: FirstRunListener,
) : ViewModel() {

    fun getStartDestination(): NavigationTree {
        return if (firstRunListener.getFirstRun())
            NavigationTree.RatingScreen else NavigationTree.PrefillScreen
    }
}