package com.jetbrains.handson.kmm.sdk

import com.jetbrains.handson.kmm.sdk.database.DatabaseDriverFactory
import com.jetbrains.handson.kmm.sdk.database.AppDatabase

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val db = AppDatabase(databaseDriverFactory.createDriver())

}
