package com.gmail.ivan.morozyk.mappy.extentions

import com.google.firebase.firestore.DocumentReference
import kotlinx.coroutines.tasks.await

suspend inline fun <reified T> DocumentReference.getResult(): T? {
    return get().await().toObject(T::class.java)
}