package com.jetbrains.handson.kmm.sdk
import com.jetbrains.handson.kmm.sdk.cache.Database
import com.jetbrains.handson.kmm.sdk.cache.DatabaseDriverFactory

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database by lazy { Database(databaseDriverFactory) }
}
