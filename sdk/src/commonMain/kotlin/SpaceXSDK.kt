package com.jetbrains.handson.kmm.sdk

import com.jetbrains.handson.kmm.sdk.database.DatabaseDriverFactory
import com.jetbrains.handson.kmm.sdk.database.AppDatabase
import com.jetbrains.handson.kmm.sdk.entity.*

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val db = AppDatabase(databaseDriverFactory.createDriver())

    init {
        db.appDatabaseQueries.removeAllLaunches()
        db.appDatabaseQueries.insertLaunch(flightNumber = 1,
            missionName = "test1",
            launchYear = 1991,
            rocketId = "1",
            details = "",
            launchSuccess = true,
            launchDateUTC = "",
            missionPatchUrl = null,
            articleUrl = ""
        )
    }

    fun getFirstLaunchName(): String {
        val list: List<RocketLaunch> = db.appDatabaseQueries.selectAllLaunchesInfo(::mapLaunchSelecting).executeAsList()
        return list.first().missionName
    }

    private fun mapLaunchSelecting(
        flightNumber: Long,
        missionName: String,
        launchYear: Int,
        rocketId: String,
        details: String?,
        launchSuccess: Boolean?,
        launchDateUTC: String,
        missionPatchUrl: String?,
        articleUrl: String?,
        rocket_id: String?,
        name: String?,
        type: String?
    ): RocketLaunch {
        return RocketLaunch(
            flightNumber = flightNumber.toInt(),
            missionName = missionName,
            launchYear = launchYear,
            details = details,
            launchDateUTC = launchDateUTC,
            launchSuccess = launchSuccess,
            rocket = null,
            links = Links(
                missionPatchUrl = missionPatchUrl,
                articleUrl = articleUrl
            )
        )
    }

}
