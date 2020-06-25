package yodgorbekkomilov.edgar.footballapp.di.module

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import yodgorbekkomilov.edgar.footballapp.model.AppDatabase
import yodgorbekkomilov.edgar.footballapp.ui.FootballListViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FootballListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "football").build()
            @Suppress("UNCHECKED_CAST")
            return FootballListViewModel(db.footballDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}