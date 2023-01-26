package com.jfalstaff.singitout.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.jfalstaff.singitout.presentation.navigation.AppScreen
import com.jfalstaff.singitout.presentation.navigation.IScreens
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface CiceroneModule {

    @Binds
    fun bindAppScreens(impl: AppScreen): IScreens

    companion object {
        @ApplicationScope
        @Provides
        fun provideCicerone() = Cicerone.create()


        @ApplicationScope
        @Provides
        fun provideRouter(cicerone: Cicerone<Router>): Router {
            return cicerone.router
        }

        @ApplicationScope
        @Provides
        fun provideNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder {
            return cicerone.getNavigatorHolder()
        }
    }
}