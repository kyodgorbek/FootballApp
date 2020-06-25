package yodgorbekkomilov.edgar.footballapp.base

import androidx.lifecycle.ViewModel
import yodgorbekkomilov.edgar.footballapp.component.DaggerViewModelInjector
import yodgorbekkomilov.edgar.footballapp.component.ViewModelInjector
import yodgorbekkomilov.edgar.footballapp.di.module.NetworkModule
import yodgorbekkomilov.edgar.footballapp.ui.FootballListViewModel
import yodgorbekkomilov.edgar.footballapp.ui.FootballViewModel

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is FootballListViewModel -> injector.inject(this)
            is FootballViewModel -> injector.inject(this)
        }
    }
}