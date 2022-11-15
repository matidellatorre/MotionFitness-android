package com.example.tp3_hci.util

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.tp3_hci.data.repository.SportRepository
import com.example.tp3_hci.data.repository.UserRepository
import com.example.tp3_hci.ui.appBar.MainAppBarViewModel
import com.example.tp3_hci.ui.home.HomeViewModel
import com.example.tp3_hci.ui.login.LoginViewModel
import com.example.tp3_hci.ui.main.MainViewModel

class ViewModelFactory constructor(
    private val sessionManager: SessionManager,
    private val userRepository: UserRepository,
    private val sportRepository: SportRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass) {
        when {
            isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(sessionManager, userRepository, sportRepository)
            isAssignableFrom(LoginViewModel::class.java) ->
                LoginViewModel(sessionManager, userRepository)
            isAssignableFrom(MainAppBarViewModel::class.java) ->
                MainAppBarViewModel(sessionManager, userRepository)
            isAssignableFrom(HomeViewModel::class.java) ->
                HomeViewModel(sessionManager, userRepository)
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}