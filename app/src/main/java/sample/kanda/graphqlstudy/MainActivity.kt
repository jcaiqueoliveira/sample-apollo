package sample.kanda.graphqlstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.ApolloQueryCall
import com.apollographql.apollo.rx2.Rx2Apollo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    lateinit var apolloClient: ApolloClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apolloClient = (application as SampleApplication).apolloClient

        Rx2Apollo
                .from(apolloQuery())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { data ->
                    Log.e("a", data.data().toString())
                }
    }

    fun apolloQuery(): ApolloQueryCall<AbacateQuery.Data> {
        return apolloClient
                .query(AbacateQuery("189.59.228.170"))
    }
}
