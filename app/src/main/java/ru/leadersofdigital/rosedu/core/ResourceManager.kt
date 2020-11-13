package ru.leadersofdigital.rosedu.core

import android.content.Context
import androidx.annotation.StringRes

class ResourceManager(private val context: Context) {

    fun getString(@StringRes stringRes: Int) = context.getString(stringRes)

    fun getString(@StringRes stringRes: Int, vararg string: String) = context.getString(stringRes, *string)

}