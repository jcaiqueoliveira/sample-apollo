package sample.kanda.graphqlstudy

import android.app.Application
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient


class SampleApplication : Application() {

    lateinit var apolloClient: ApolloClient

    override fun onCreate() {
        super.onCreate()
        val okHttpClient = OkHttpClient.Builder()
                .build()
        apolloClient = ApolloClient.builder()
                .serverUrl("https://api.graphloc.com/graphql")
                .okHttpClient(okHttpClient)
                .build()
    }
}