package com.jetbrains.handson.kmm.sdk
import com.jetbrains.handson.kmm.sdk.cache.Database
import com.jetbrains.handson.kmm.sdk.cache.DatabaseDriverFactory
import com.jetbrains.handson.kmm.sdk.entity.RocketLaunch
import com.jetbrains.handson.kmm.sdk.network.SpaceXApi

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = SpaceXApi()

    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearDatabase()
                database.createLaunches(it)
            }
        }
    }
}
