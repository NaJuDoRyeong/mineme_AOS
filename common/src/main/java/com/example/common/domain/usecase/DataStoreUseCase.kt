package com.example.common.domain.usecase

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreUseCase @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {


    val bearerJsonWebToken: Flow<String?> =
        dataStore.data.map { preferences -> preferences[jsonWebToken_key]?.toBearerToken() }

    val myCode: Flow<String?> =
        dataStore.data.map { preferences -> preferences[user_code] }

    val permissionNum: Flow<Int?> =
        dataStore.data.map { preferences -> preferences[permission_num] }

    private fun String.toBearerToken(): String = "Bearer $this"


    suspend fun editJsonWebToken(jwt: String) {
        dataStore.edit {
            it[jsonWebToken_key] = jwt
        }
    }

    suspend fun editUserCode(userCode: String) {
        dataStore.edit {
            it[user_code] = userCode
        }
    }

    suspend fun editPermissionNum(num: Int) {
        dataStore.edit {
            it[permission_num] = num
        }
    }


    companion object {
        const val DATA_STORE_NAME = "app"

        private val jsonWebToken_key = stringPreferencesKey("JSON_WEB_TOKEN")
        private val permission_num = intPreferencesKey("PERMISSION_NUM")
        private val user_code = stringPreferencesKey("USER_CODE")
    }

}