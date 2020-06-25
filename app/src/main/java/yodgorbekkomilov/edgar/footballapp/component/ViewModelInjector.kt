package yodgorbekkomilov.edgar.footballapp.component

import dagger.Component
import yodgorbekkomilov.edgar.footballapp.di.module.NetworkModule
import yodgorbekkomilov.edgar.footballapp.ui.FootballListViewModel
import yodgorbekkomilov.edgar.footballapp.ui.FootballViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies
     */
    fun inject(footballListViewModel: FootballListViewModel)
    /**
     * Injects required dependencies into the specified PostViewModel.
     * @param postViewModel PostViewModel in which to inject the dependencies
     */
    fun inject(footballViewModel: FootballViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}
