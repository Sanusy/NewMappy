package com.gmail.ivan.morozyk.mappy.util

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

private const val DEFAULT_WEB_CLIENT_ID =
    "491060353364-dntha4fvmoce2addl0ak9gfkg55nqtql.apps.googleusercontent.com"

class GetGoogleSignInIdToken : ActivityResultContract<Unit, String>() {
    override fun createIntent(context: Context, input: Unit): Intent {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(DEFAULT_WEB_CLIENT_ID)
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(context, gso)

        return googleSignInClient.signInIntent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        val task = GoogleSignIn.getSignedInAccountFromIntent(intent)
        val account = task.getResult(ApiException::class.java)!!
        return account.idToken!!
    }
}