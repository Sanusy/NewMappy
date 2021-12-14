package com.gmail.ivan.morozyk.mappy.model

import com.gmail.ivan.morozyk.mappy.extentions.getResult
import com.gmail.ivan.morozyk.mappy.model.data.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) {

    suspend fun getCurrentUser(): User? {
        val userId = firebaseAuth.currentUser?.uid

        return if (userId != null) {
            firestore.collection("users")
                .document(userId).getResult()
        } else null
    }

    suspend fun addNewUserWithEmailAndPassword(name: String, email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).await()

        val user = firebaseAuth.currentUser
        val profileUpdates = userProfileChangeRequest {
            displayName = name
        }

        user?.let {
            it.updateProfile(profileUpdates)

            val userToAdd = User(email = email, name = name)
            firestore.collection("users").document(it.uid).set(userToAdd).await()
        }
    }

    suspend fun addNewUserWithGoogle() {
    }
}

private const val CLIENT_ID =
    "491060353364-dntha4fvmoce2addl0ak9gfkg55nqtql.apps.googleusercontent.com"