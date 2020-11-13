package ru.leadersofdigital.rosedu.core.extensions

import android.view.View

fun View.clicks(click: () -> Unit) = this.setOnClickListener {
    click.invoke()
}