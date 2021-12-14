package com.gmail.ivan.morozyk.mappy.model.data

import com.google.firebase.firestore.DocumentId

data class User(@DocumentId val id: String? = null, val email: String? = null, val name: String? = null)