package yodgorbekkomilov.edgar.footballapp.ui


import androidx.lifecycle.MutableLiveData
import yodgorbekkomilov.edgar.footballapp.FootballResponse
import yodgorbekkomilov.edgar.footballapp.base.BaseViewModel

class FootballViewModel: BaseViewModel() {
    private val clubName = MutableLiveData<String>()

    private val countryName = MutableLiveData<String>()
    private val clubValue = MutableLiveData<String>()
    private val clubImage = MutableLiveData<String>()
    private val europeanTitle = MutableLiveData<String>()

    fun bind(football: FootballResponse){
        clubName.value= football[0].name
        countryName.value = football[1].country
        clubValue.value = football[2].value.toString()
        clubImage.value = football[3].image
        europeanTitle.value = football[4].europeanTitles.toString()

    }

    fun getClubName():MutableLiveData<String>{
        return clubName
    }

    fun getCountryName():MutableLiveData<String>{
        return countryName
    }

    fun getClubValue():MutableLiveData<String>{
        return clubValue
    }

    fun getImage():MutableLiveData<String> {
 return clubImage

    }


    fun getEuropeanTitle():MutableLiveData<String> {
        return europeanTitle

    }
}