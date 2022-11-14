package com.example.tp3_hci

import android.app.Application
import com.example.tp3_hci.data.network.SportRemoteDataSource
import com.example.tp3_hci.data.network.UserRemoteDataSource
import com.example.tp3_hci.data.network.api.RetrofitClient
import com.example.tp3_hci.data.repository.SportRepository
import com.example.tp3_hci.data.repository.UserRepository
import com.example.tp3_hci.util.SessionManager

class MyApplication : Application() {

    private val userRemoteDataSource: UserRemoteDataSource
        get() = UserRemoteDataSource(sessionManager, RetrofitClient.getApiUserService(this))

    private val sportRemoteDataSource: SportRemoteDataSource
        get() = SportRemoteDataSource(RetrofitClient.getApiSportService(this))

    val sessionManager: SessionManager
        get() = SessionManager(this)

    val userRepository: UserRepository
        get() = UserRepository(userRemoteDataSource)

    val sportRepository: SportRepository
        get() = SportRepository(sportRemoteDataSource)
}