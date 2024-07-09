package com.example.datastore.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow

class User(private val context : Context) {
    private val Context.dataStore by preferencesDataStore(name="dataStore")

    private val lastName = stringPreferencesKey("last_name")
    private val middleName = stringPreferencesKey("middle_name")
    private val age = intPreferencesKey("age")
    private val gender = booleanPreferencesKey("gender")

    val text : Flow<String> = context.dataStore.data
        .map { preferences ->
            context.dataStore.edit {
                preferences[lastName] ?: ""
            }
        }

    suspend fun setName(name: String) {
        context.dataStore.edit { preferences ->
            preferences[lastName] = name
        }
    }
}