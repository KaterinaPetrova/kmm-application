package com.jetbrains.handson.kmm.sdk
import com.jetbrains.handson.kmm.sdk.cache.Database
import com.jetbrains.handson.kmm.sdk.cache.DatabaseDriverFactory
import com.jetbrains.handson.kmm.sdk.network.SpaceXApi

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database by lazy { Database(databaseDriverFactory) }
    private val api by lazy { SpaceXApi() }

}
