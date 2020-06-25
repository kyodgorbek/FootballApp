package yodgorbekkomilov.edgar.footballapp.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable

import io.reactivex.disposables.Disposable

import io.reactivex.schedulers.Schedulers
import yodgorbekkomilov.edgar.footballapp.FootballResponse
import yodgorbekkomilov.edgar.footballapp.R

import yodgorbekkomilov.edgar.footballapp.adapter.FootballAdapter
import yodgorbekkomilov.edgar.footballapp.base.BaseViewModel
import yodgorbekkomilov.edgar.footballapp.model.FootballDao
import yodgorbekkomilov.edgar.footballapp.network.FootballApi
import javax.inject.Inject

class FootballListViewModel(private val footballDao: FootballDao): BaseViewModel(){
    @Inject
    lateinit var footballApi: FootballApi
    val footballAdapter: FootballAdapter = FootballAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }

    private lateinit var subscription: Disposable

    init{
        loadPosts()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadPosts(){
        subscription = Observable.fromCallable { footballDao.all }
            .concatMap {
                    dbPostList ->
                if(dbPostList.isEmpty())
                    footballApi.getPosts().concatMap {
                            apiPostList -> footballDao.insertAll()
                        Observable.just(apiPostList)
                    }
                else
                    Observable.just(dbPostList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result as List<FootballResponse>) },
                { onRetrievePostListError() }
            )
    }

    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(footballList:List<FootballResponse>){
        footballAdapter.updatePostList(footballList)
    }

    private fun onRetrievePostListError(){
        errorMessage.value
    }
}