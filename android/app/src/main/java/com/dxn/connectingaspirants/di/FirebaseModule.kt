package com.dxn.connectingaspirants.di

import com.dxn.connectingaspirants.data.repositories.ChatRepositoryImpl
import com.dxn.connectingaspirants.data.repositories.FirebaseRepositoryImpl
import com.dxn.connectingaspirants.domain.repositories.ChatRepository
import com.dxn.connectingaspirants.domain.repositories.FirebaseRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.google.firebase.firestore.ktx.firestore
import kotlinx.coroutines.ExperimentalCoroutinesApi


@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirestoreDb() = Firebase.firestore

    @Provides
    @Singleton
    fun provideFirebaseRepository(
        firebaseAuth: FirebaseAuth,
        firestoreDb: FirebaseFirestore
    ): FirebaseRepository {
        return FirebaseRepositoryImpl(firebaseAuth, firestoreDb.collection("users_collection"))
    }

    @ExperimentalCoroutinesApi
    @Provides
    @Singleton
    fun provideChatRepository(
        firebaseAuth: FirebaseAuth,
        firestoreDb: FirebaseFirestore
    ): ChatRepository {
        return ChatRepositoryImpl(
            firebaseAuth,
            firestoreDb.collection("chats_collection"),
            firestoreDb.collection("users_collection"),
        )
    }


}