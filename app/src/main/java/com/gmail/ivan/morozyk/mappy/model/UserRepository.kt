package com.gmail.ivan.morozyk.mappy.model

import com.gmail.ivan.morozyk.mappy.extentions.getResult
import com.gmail.ivan.morozyk.mappy.model.data.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
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

    suspend fun addNewUserWithGoogle(googleSignInIdToken: String) {
        val credential = GoogleAuthProvider.getCredential(googleSignInIdToken, null)
        firebaseAuth.signInWithCredential(credential).await()

        val user = firebaseAuth.currentUser
        user?.let {
            val userToAdd = User(email = user.email, name = user.displayName)
            firestore.collection("users").document(it.uid).set(userToAdd).await()
        }
    }
}