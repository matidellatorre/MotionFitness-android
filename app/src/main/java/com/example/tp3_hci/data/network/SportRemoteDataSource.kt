package com.example.tp3_hci.data.network

import com.example.tp3_hci.data.network.api.ApiSportService
import com.example.tp3_hci.data.network.model.NetworkPagedContent
import com.example.tp3_hci.data.network.model.NetworkSport

class SportRemoteDataSource(
    private val apiSportService: ApiSportService
) : RemoteDataSource() {

    suspend fun getSports() : NetworkPagedContent<NetworkSport> {
        return handleApiResponse {
            apiSportService.getSpots()
        }
    }

    suspend fun getSport(sportId: Int) : NetworkSport {
        return handleApiResponse {
            apiSportService.getSport(sportId)
        }
    }

    suspend fun addSport(sport: NetworkSport) : NetworkSport {
        return handleApiResponse {
            apiSportService.addSport(sport)
        }
    }

    suspend fun modifySport(sport: NetworkSport) : NetworkSport {
        return handleApiResponse {
            apiSportService.modifySport(sport.id!!, sport)
        }
    }

    suspend fun deleteSport(sportId: Int){
        handleApiResponse {
            apiSportService.deleteSport(sportId)
        }
    }
}